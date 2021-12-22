package controller;

import controller.crawler.InitDataCrawler;
import model.product.ProductDAO;
import model.product.ProductVO;
import org.jsoup.nodes.Document;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;

@WebListener
public class InitialListner implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public InitialListner() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        ProductDAO dao = new ProductDAO();
        ProductVO vo = null;
        ArrayList<ProductVO> datas = new ArrayList<ProductVO>();

        Document doc = InitDataCrawler.connect();
        ArrayList<String> names = InitDataCrawler.getName(doc);
        ArrayList<String> brands = InitDataCrawler.getBrand(doc);
        ArrayList<Integer> prices = InitDataCrawler.getPrice(doc);
        ArrayList<String> images = InitDataCrawler.getImg(doc);

        for (int i = 0; i < names.size(); i++) {
            vo = new ProductVO();
            vo.setRanking(i+1);
            vo.setName(names.get(i));
            vo.setBrand(brands.get(i));
            vo.setPrice(prices.get(i));
            vo.setImage(images.get(i));
            datas.add(vo);
        }

        dao.insertAll(datas); // 초기 데이터 삽입

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        ProductDAO dao = new ProductDAO();
        dao.deleteAll();
    }
}
