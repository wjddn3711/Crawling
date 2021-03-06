<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Generic - Spectral by HTML5 UP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
</head>
<body class="is-preload">

<!-- Page Wrapper -->
<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="index.jsp">FashCom</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="#menu" class="menuToggle"><span>Menu</span></a>
                    <div id="menu">
                        <ul>
                            <li><a href="main.do">Home</a></li>
                            <li><a href="learn.jsp">Learn More</a></li>
                            <mytag:login/>
                            <mytag:productList/>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </header>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>크롤링 설계서</h2>
            <p>자바 기반의 jsoup을 활용한 웹 크롤링</p>
        </header>
        <section class="wrapper style5">
            <div class="inner">

                <h3>1. 무신사 현재 랭킹 정보 크롤링 </h3>
                <h6>(옷이름, 브랜드명, 가격, 이미지 URL)</h6>
                <p>
                    <span class="image fit">
                        <img src="images/craw_img1.png" alt="크롤링이미지예시1">
                    </span>
                </p>
                <hr />
                <h4>1.1 옷이름 정보</h4>
                <p>
                    <span class="image fit">
                        <img src="images/craw_find_cloth_1.png" alt="옷이름 크롤링1">
                    </span>
                    - list_info > a<br>
                    - a 태그의 inner text 로 되어있다.<br><br>
                    <span class="image fit">
                        <img src="images/craw_find_cloth_2.png" alt="옷이름 크롤링2">
                    </span>
                    - "배송"을 제외 할 수 있도록 문자열 가공<br><br>
                    <span class="image fit">
                        <img src="images/craw_find_cloth_2.png" alt="옷이름 크롤링2">
                    </span>
                    - text() 를 통해 불러온 값은 String 문자열이기에 charAt() 과 subString() 을 통하여 문자열을 가공한다<br><br>
                    <strong>[코드]:</strong>
            <pre>
                <code>
                    Elements cl_name = doc.select(".list_info a");
                    ArrayList<String> cloth = new ArrayList<>();
                    for (Element element : cl_name) { String target = element.text();
                    for (int i = 0; i < target.length()-1; i++) {
                        if(target.charAt(i)=='배' && target.charAt(i+1)=='송'){
                            target = target.substring(i+3); // 만약 "배송" 을 포함한다면 뒤에 공백 제외 슬라이싱 break;
                            }
                        }
                    cloth.add(target);
                    }
                </code>
            </pre>
                    - target.length 까지를 범위로 하면 boundary 문제로 인해 length-1 을 범위로 한다<br>
                    - 만약 문자열에 '배'+'송' 이 있다면 '송'의 뒤부분 부터 문자열을 슬라이싱한다<br>
                    - 다만 공백으로 나뉘어져 있기에 i+2 가 아닌 i+3 을 해주었다
                </p>
                <hr />
                <h4>1.2 옷 브랜드 정보</h4>
                <p>
                    <span class="image fit">
                        <img src="images/craw_find_brand_1.png" alt="옷이름 크롤링1">
                    </span>
                    - class="item_title" > a > text<br><br>
                    <strong>[코드]:</strong>
                <pre>
            <code>
                Elements cl_brand = doc.select(".item_title a");
                ArrayList<String> brand = new ArrayList<>();
                for (Element element : cl_brand) {
                    String target = element.text();
                    brand.add(target);
                }
            </code>
                </pre>
                    - 추가적인 문자열 가공 없이 브랜드들을 리스트에 담는다
                </p>
                <hr />
                <h4>1.3 옷 가격 정보</h4>
                <p>
                    <span class="image fit">
                        <img src="images/craw_find_price_1.png" alt="옷이름 크롤링1">
                    </span>
                    - class="price" > text<br><br>
                    <span class="image fit">
                        <img src="images/craw_find_price_2.png" alt="옷이름 크롤링1">
                    </span>
                    - 가격같은 경우 text에 두개의 가격이 존재했기에 가장 마지막에 있는 가격이 현재 가격으로 잡고 파싱한다<br><br>
                    <strong>[코드]:</strong>
            <pre>
                <code>
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
                </code>
            </pre>
                - price 는 가격이 두개이상 존재할 뿐만 아니라 가공하여 정수형으로 만들어줘야 한다<br>
                - 우선 가장 마지막에 오는 가격을 저장하고 "원"과 콤마를 제거해준 뒤 리스트에 담는다
                </p>
                <hr>
                <h4>1.4 옷 이미지 정보</h4>
                <p>
                    <span class="image fit">
                        <img src="images/craw_find_img_1.png" alt="옷이름 크롤링1">
                    </span>
                    - class="lazyload lazy" > data-original<br>
                    - src 속성 값을 통하여 가공한다<br><br>
                    <strong>[코드]:</strong>
            <pre>
                <code>
            Elements cl_img = doc.select(".lazyload");
            ArrayList<String> image = new ArrayList<>();
            for (Element element : cl_img) {
                image.add(element.attr("data-original")); // attr 속성값을 통하여 이미지 src 를 찾는다
            }
                </code>
            </pre>
                </p>
                <hr>
                <h4>1.5 최종 결과 확인</h4>
                <span class="image fit">
                        <img src="images/craw_find_result.png" alt="옷이름 크롤링1">
                </span>
                <hr>
                <h3>2. 무신사 크롤링 데이터 DB 삽입 </h3>
                <h6>Mysql 을 통한 크롤링 데이터 삽입</h6>
                <span class="image fit">
                        <img src="images/craw_db_table.png" alt="옷이름 크롤링1">
                </span>
                <hr>
                <h4>2.1 JDBC 연결</h4>
                <p>
                <pre>
                    <code>
            connection = DriverManager.getConnection(sqlUrl, user, password); // db 에 접속
            pstmt = connection.prepareStatement(sql_selectAll);
            ResultSet rs = pstmt.executeQuery();
                    </code>
                </pre>
                - 만약 현재 DB에 저장된 값이 있다면 rs.next()는 false 를 반환하기 때문에 이를 통하여 update 를 진행할지 insert 를 진행할지 결정한다<br>
                </p>
                <hr>
                <h4>2.2 Update</h4>
                <p>
            <pre>
                <code>
            if(rs.next()){
                pstmt = connection.prepareStatement(sql_update);
                for (int i = 0; i < cloth.size(); i++) {
                    pstmt.setString(1, cloth.get(i)); // 옷이름
                    pstmt.setString(2, brand.get(i)); // 브랜드 이름
                    pstmt.setString(5,image.get(i)); // 이미지
                    pstmt.setInt(3,price.get(i)); // 가격
                    pstmt.setInt(4,i+1); // 랭킹
                    pstmt.executeUpdate(); // update 쿼리 수행
                }
            }
                </code>
            </pre>
            <pre>
                <code>
        String sql_update = "update musinsa set cloth=?, brand=?, price=?, image=? where ranking=?";
                </code>
            </pre>
                - prepareStatement 를 통하여 옷이름, 브랜드, 가격, 이미지를 세팅하고 랭킹이 일치하는 곳에 업데이트를 진행한다
                </p>
                <hr>
                <h4>2.3 Insert</h4>
                <p>
            <pre>
                <code>
            else{
                pstmt = connection.prepareStatement(sql_insert);
                for (int i = 0; i < cloth.size(); i++) {
                    pstmt.setInt(1,i+1); // 랭킹
                    pstmt.setInt(4,price.get(i)); // 가격
                    pstmt.setString(2, cloth.get(i)); // 옷이름
                    pstmt.setString(3, brand.get(i)); // 브랜드 이름
                    pstmt.setString(5,image.get(i));
                    pstmt.executeUpdate(); // insert 쿼리 수행
                }
            }
                </code>
            </pre>
            <pre>
                <code>
            String sql_insert  = "insert into musinsa(ranking, cloth, brand, price, image) values (?,?,?,?,?)";
                </code>
            </pre>
                - prepareStatement 를 통하여 옷이름, 브랜드, 가격, 이미지를 세팅하여 insert를 진행한다
                </p>





            </div>
        </section>
    </article>

    <!-- Footer -->
    <footer id="footer">
        <ul class="icons">
            <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
        </ul>
        <ul class="copyright">
            <li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
        </ul>
    </footer>

</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>