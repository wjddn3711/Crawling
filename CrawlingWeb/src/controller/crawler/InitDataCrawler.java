package controller.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class InitDataCrawler {
    static String url= "https://search.musinsa.com/ranking/best";
    static String cl_name = ".list_info a";
    static String cl_price = ".price";
    static String cl_brand = ".item_title a";
    static String cl_img = ".lazyload";

    public static Document connect(){ // 연결 메서드
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        } catch (IOException e) {
            System.out.println("url 접근중 이상 발생!");
        }
        return null;
    }

    public static ArrayList<String> getName (Document doc){ // css 쿼리중 각 항목에 해당하는 쿼리를 뽑아 이름을 반환한다
        ArrayList<String> result = new ArrayList<String>();
        Elements names = doc.select(cl_name);
        // 타겟에 포함된 '배'와 '송'을 슬라이싱
        for (Element element : names) {
            String target = element.text();
            for (int i = 0; i < target.length() - 1; i++) {
                if (target.charAt(i) == '배' && target.charAt(i + 1) == '송') {
                    target = target.substring(i + 3); // 만약 "배송" 을 포함한다면 뒤에 공백 제외 슬라이싱
                    break;
                }
            }
            result.add(target);
        }
        return result;
    }

    public static ArrayList<Integer> getPrice (Document doc){
        ArrayList<Integer> result = new ArrayList<>();
        Elements prices = doc.select(cl_price);
        for (Element element : prices) {
            String target = element.text();
            String[] dummy = target.split(" ");
            if (dummy.length > 1) {
                // 만약 가격이 두개 이상 존재한다면 가장 마지막 값이 현재 가격이다
                target = dummy[dummy.length - 1];
            }
            target = target.substring(0, target.length() - 1); // 마지막 "원" 제거
            target = target.replaceAll("\\,", ""); // , 콤마 제거
            result.add(Integer.valueOf(target));
        }
        return result;
    }
    // 브랜드 찾기 메서드
    public static ArrayList<String> getBrand (Document doc){
        ArrayList<String> result = new ArrayList<String>();
        Elements brands = doc.select(cl_brand);
        for (Element element : brands) {
            result.add(element.text());
        }
        return result;
    }

    public static ArrayList<String> getImg (Document doc){
        ArrayList<String> result = new ArrayList<String>();
        Elements images = doc.select(cl_img);
        for (Element image : images) {
            result.add(image.attr("data-original")); // data-original 속성 값에 img url 이 저장되어있다
        }
        return result;
    }
}
