import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Greating {
    static String name = " .card-content__title"; // url 에서 이름을 담고 있는 css class
    static String price = " .card-content__price-discount"; // url 에서 가격을 담고 있는 css class
    static String img = " .lazyload";
    static String sub = " .card-content__text";
    public static Document connect(){
        String url = "https://www.zipbanchan.co.kr/shop/goods/goods_list.php";
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        } catch (IOException e) {
            System.out.println("url 접근중 이상 발생!");
        }
        return null;
    }

    public static ArrayList<String> getName (String page, Document doc){ // css 쿼리중 각 항목에 해당하는 쿼리를 뽑아 이름을 반환한다
        ArrayList<String> result = new ArrayList<String>();
        Elements names = doc.select(page+name);
        for (Element name : names) {
            result.add(name.text());
        }
        return result;
    }

    public static ArrayList<Integer> getPrice (String page, Document doc){
        ArrayList<Integer> result = new ArrayList<>();
        Elements prices = doc.select(page+price);
        for (Element price : prices) {
            String target = price.text();
            target = target.substring(0, target.length() - 1); // 마지막 "원" 제거
            target = target.replaceAll("\\,", ""); // , 콤마 제거
            result.add(Integer.valueOf(target)); // 결과에 저장
        }
        return result;
    }
    public static ArrayList<String> getSub (String page, Document doc){
        ArrayList<String> result = new ArrayList<String>();
        Elements subs = doc.select(page+sub);
        for (Element element : subs) {
            result.add(element.text());
        }
        return result;
    }

    public static ArrayList<String> getImg (String page, Document doc){
        ArrayList<String> result = new ArrayList<String>();
        Elements images = doc.select(page+img);
        for (Element image : images) {
            result.add(image.attr("data-src")); // data-src 속성 값에 img url 이 저장되어있다
        }
        return result;
    }

    public static void main(String[] args) {
        Document doc = connect();
        // 메인 요리
        String main = "#catecd_001007";
        // 국
        String soup = "#catecd_001006";
        // 무침
        String seasonedSideDish = "#catecd_001003";
        // 볶음
        String friedSideDish = "#catecd_001009";
        // 조림
        String braisedSideDish = "#catecd_001002";

        // 각 요리 별로 메서드들을 호출하여 ArrayList 로 저장된 정보를 갖고 올 수 있다
        /*
        ArrayList<String> 음식이름 = getName(페이지명, doc);
        ArrayList<String> 음식정보 = getSub(페이지명, doc);
        ArrayList<Integer> 음식가격 = getPrice(페이지명, doc);
        ArrayList<String> 음식이미지 = getImg(페이지명, doc);
         */


        // 반찬 (무침, 볶음, 조림)
        // 조림
        ArrayList<String> bsName = getName(braisedSideDish, doc);
        ArrayList<Integer> bsPrice = getPrice(braisedSideDish, doc);
        ArrayList<String> bsSub = getSub(braisedSideDish,doc);
        ArrayList<String> bsImg = getImg(braisedSideDish,doc);
        // 무침
        ArrayList<String> ssName = getName(seasonedSideDish, doc);
        ArrayList<Integer> ssPrice = getPrice(seasonedSideDish,doc);
        ArrayList<String> ssSub = getSub(seasonedSideDish,doc);
        ArrayList<String> ssImg = getImg(seasonedSideDish,doc);
        // 볶음
        ArrayList<String> fsName = getName(friedSideDish,doc);
        ArrayList<Integer> fsPrice = getPrice(friedSideDish,doc);
        ArrayList<String> fsSub = getSub(friedSideDish,doc);
        ArrayList<String> fsImg = getImg(friedSideDish, doc);
        // 테스트
        for (int i = 0; i < bsName.size(); i++) { // 어차피 모두 동일한 사이즈이므로 아무거나 해도 상관없음
            System.out.println("반찬 번호 : "+(i+1));
            System.out.println("반찬 이름 : "+bsName.get(i));
            System.out.println("반찬 설명 : "+bsSub.get(i));
            System.out.println("반찬 가격 : "+bsPrice.get(i));
            System.out.println("반찬 이미지 : "+ bsImg.get(i));
            System.out.println("=========================================================================");
        }

        // product type 를 3개로 분류 할 수 있음 : 국, 반찬, 메인
    }

}
