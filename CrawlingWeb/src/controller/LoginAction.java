package controller;

import model.member.MemberDAO;
import model.member.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 만약 존재하는 아이디라면 비밀번호를 체크, 그리고 올바른 비밀번호라면 로그인 성공
        // 만약 아이디가 존재하지 않는다면 경로는 로그인 페이지
        ActionForward forward = null;
        MemberDAO dao = new MemberDAO();
        MemberVO vo = new MemberVO();
        vo.setUid(request.getParameter("uid"));
        vo.setUpw(request.getParameter("upw"));
        if(dao.selectOne(vo)){ // 만약 로그인이 되었다면 세션에 uid 를 저장
            // id 와 pw 를 통하여 로그인 되었는지 저장
            forward = new ActionForward();
            HttpSession session = request.getSession();
            session.setAttribute("uid", vo.getUid());
            forward.setPath("main.do"); // 메인으로
            forward.setRedirect(true); // 넘길 데이터가 없으니 sendRedirect
        }
        else{
            PrintWriter out = response.getWriter(); // 스크립트 printwriter
            out.println("<script>alert('Invalid user!');history.go(-1);</script>"); // forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
        }
        return forward;
    }
}
