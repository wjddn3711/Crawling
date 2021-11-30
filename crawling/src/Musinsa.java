import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.*;
import java.util.ArrayList;


public class Musinsa {
    public static void main(String[] args) {
        // 무신사 베스트 랭킹을 받아와 DB에 넣고 원하는 품목중 랭킹에 등록된 상품을 조회할 수 있도록 한다
        // 브랜드, 옷이름, 가격을 디비에 담을 것이다
        String url = "https://search.musinsa.com/ranking/best";

        // DB 사용 변수들
        String sqlUrl = "jdbc:mysql://localhost:3306/JDBC";
        String user = "root";
        String password = "dnflwlq0527!";
        String sql_selectAll = "select * from musinsa";
        String sql_update = "update musinsa set cloth=?, brand=?, price=? where ranking=?";
        String sql_insert  = "insert into musinsa(ranking, cloth, brand, price) values (?,?,?,?)";


        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
//             Jsoup 해당 url 에 연결하여 html 코드를 가져온다
//             .text = HTML 에서 텍스트만 가져옴 (JS 코드는 생략)
//             .html = html 자체를 가져온다
            Document doc = Jsoup.connect(url).get(); // html 파싱
//            System.out.println(doc); // html 코드를 갖고오기
            // Document.select() 는 JS 의 쿼리셀럭터와 같다

            //옷 이름 찾기
            Elements cl_name = doc.select(".list_info a");
            ArrayList<String> cloth = new ArrayList<>();
            for (Element element : cl_name) {
                String target = element.text();
                for (int i = 0; i < target.length() - 1; i++) {
                    if (target.charAt(i) == '배' && target.charAt(i + 1) == '송') {
                        target = target.substring(i + 3); // 만약 "배송" 을 포함한다면 뒤에 공백 제외 슬라이싱
                        break;
                    }
                }
                cloth.add(target);
            }

            //브랜드 이름 찾기
            Elements cl_brand = doc.select(".item_title a");
            ArrayList<String> brand = new ArrayList<>();
            for (Element element : cl_brand) {
                String target = element.text();
                brand.add(target);
            }

            //가격 찾기
            Elements cl_price = doc.select(".price");
            ArrayList<Integer> price = new ArrayList<>();
            for (Element element : cl_price) {
                String target = element.text();
                String[] dummy = target.split(" ");
                if (dummy.length > 1) {
                    // 만약 가격이 두개 이상 존재한다면 가장 마지막 값이 현재 가격이다
                    target = dummy[dummy.length - 1];
                }
                target = target.substring(0,target.length()-1); // 마지막 "원" 제거
                target = target.replaceAll("\\,",""); // , 콤마 제거
                price.add(Integer.valueOf(target));
            }

            // 결과값 확인 로깅
//            for (int i = 0; i < cloth.size(); i++) {
//                System.out.println("\n랭킹 : "+(i+1)+
//                        "\n옷 : "+cloth.get(i)+
//                        "\n브랜드 : "+brand.get(i)+
//                        "\n가격 : "+price.get(i));
//            }
            connection = DriverManager.getConnection(sqlUrl, user, password); // db 에 접속
            pstmt = connection.prepareStatement(sql_selectAll);
            ResultSet rs = pstmt.executeQuery();
            // 만약 현재 db에 저장된 것이 있다면 rs.next()는 false
            // 민약 저장된 db가 존재한다면
            if(rs.next()){
                pstmt = connection.prepareStatement(sql_update);
                for (int i = 0; i < cloth.size(); i++) {
                    pstmt.setString(1, cloth.get(i)); // 옷이름
                    pstmt.setString(2, brand.get(i)); // 브랜드 이름
                    pstmt.setInt(3,price.get(i)); // 가격
                    pstmt.setInt(4,i+1); // 랭킹
                    pstmt.executeUpdate(); // update 쿼리 수행
                }
            }
            else{
                pstmt = connection.prepareStatement(sql_insert);
                for (int i = 0; i < cloth.size(); i++) {
                    pstmt.setInt(1,i+1); // 랭킹
                    pstmt.setInt(4,price.get(i)); // 가격
                    pstmt.setString(2, cloth.get(i)); // 옷이름
                    pstmt.setString(3, brand.get(i)); // 브랜드 이름
                    pstmt.executeUpdate(); // insert 쿼리 수행
                }
            }
            //개수 확인
//            System.out.println("옷이름 개수: " + cloth.size() + "\n브랜드 개수: " + brand.size() + "\n가격 개수: " + price.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
