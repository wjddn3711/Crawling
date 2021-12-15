package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 만약 존재하는 아이디라면 비밀번호를 체크, 그리고 올바른 비밀번호라면 로그인 성공
        // 만약 아이디가 존재하지 않는다면 경로는 로그인 페이지
        
    }
}
