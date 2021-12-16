package controller;

import model.member.MemberDAO;
import model.member.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionForward forward = null;
        // vo 를 통해 넘겨받는다
        MemberDAO dao= new MemberDAO();
        MemberVO vo = new MemberVO();
        vo.setUid(request.getParameter("uid"));
        vo.setUpw(request.getParameter("upw"));
        vo.setUemail(request.getParameter("uemail"));
        vo.setUname(request.getParameter("uname"));
        System.out.println(vo);
        if(dao.insert(vo)){
            // 회원 가입 성공시
            forward = new ActionForward();
            System.out.println("회원 가입 성공 [로그]");
            forward.setPath("login.jsp"); // 로그인 페이지로 이동
            forward.setRedirect(true); // DB에 저장되었으니 sendredirect
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Please Enter other ID!');history.go(-1);</script>");
        }

        return forward;
    }
}
