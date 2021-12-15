package controller;

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
        else if (command.equals("new")){

        }
    }
}
