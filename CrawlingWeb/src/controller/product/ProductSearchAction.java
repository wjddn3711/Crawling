package controller.product;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductSearchAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);
        ArrayList<ProductVO> datas = dao.selectSearch(keyword);
        request.setAttribute("datas",datas);
        for (ProductVO data : datas) {
            System.out.println(data);
        }

        ActionForward forward = new ActionForward();
        forward.setPath("product.jsp");
        forward.setRedirect(false); //forward 로 넘김
        return forward;
    }
}
