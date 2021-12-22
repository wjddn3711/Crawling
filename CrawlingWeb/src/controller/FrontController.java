package controller;

import controller.common.ActionForward;
import controller.product.ProductListAction;
import controller.product.ProductSearchAction;
import controller.users.LoginAction;
import controller.users.LogoutAction;
import controller.users.NewAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDO(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDO(request,response);
    }

    private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.요청을 파악
        String uri = request.getRequestURI();
        System.out.println(uri);
        String cp = request.getContextPath();
        System.out.println(cp);
        String command = uri.substring(cp.length()+1,uri.length()-3);
        System.out.println(command);

        // 로직이 바뀌어도 서버데이터에 부담을 주지 않는다
        ActionForward forward = null;
        // 파라미터를 줄여 서버 부담을 줄인다 (action 파라미터를 url 로 받지 않음)
        // 2. 각 요청에 대한 Controller 처리를 수행
        if(command.equals("main")){
            response.sendRedirect("main.jsp");
        }
        else if (command.equals("login")){
            try{
                forward = new LoginAction().execute(request, response);
            }catch (Exception e){
                System.out.println("로그인 진행중 문제 발생!");
            }
        }
        else if (command.equals("new")) {
            try{
                forward = new NewAction().execute(request, response);
            }catch (Exception e){
                System.out.println("회원가입 진행중 문제 발생!");
            }
        }
        else if(command.equals("logout")){
            try{
                forward = new LogoutAction().execute(request, response);
            }catch (Exception e){
                System.out.println("로그아웃 진행중 문제 발생!");
            }
        }
        else if(command.equals("productList")){
            try{
                forward = new ProductListAction().execute(request, response);
            }catch (Exception e){
                System.out.println("상품리스트 진행중 문제 발생!");
            }
        }
        else if(command.equals("search")){
            try{
                System.out.println("서칭");
                forward = new ProductSearchAction().execute(request, response);
            }catch (Exception e){
                System.out.println("상품리스트 서칭 진행중 문제 발생!");
            }
        }

        if(forward!=null){
            if(forward!=null){
                if(forward.isRedirect()){
                    response.sendRedirect(forward.getPath());
                }
                else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                    dispatcher.forward(request,response);
                }
            }
        }
    }
}
