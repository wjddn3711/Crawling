package controller.users;

import controller.common.Action;
import controller.common.ActionForward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // 세션 정보 삭제
        ActionForward forward = new ActionForward();
        forward.setPath("main.do");
        forward.setRedirect(true);
        return forward;
    }
}
