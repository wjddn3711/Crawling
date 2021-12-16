package model.member;

import model.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    // 로그인 하게 될때 신규 회원가입 insert 와 회원 탈퇴 delete, 로그인 정보 확인을 위한 selectOne 이 있어야함

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    String sql_selectOne = "select * from users where uid = ?";
    String sql_insert = "insert into users(uid,upw,uname,uemail) values (?,?,?,?)";
    public boolean selectOne(MemberVO vo){
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_selectOne);
            pstmt.setString(1, vo.getUid()); //vo에서 받아온 uid 가 있는지 확인
            rs = pstmt.executeQuery();
            if(rs.next()){ // 만약 해당하는 아이디가 존재한다면
                System.out.println("아이디는 맞음 [로깅]");
                if(rs.getString("upw").equals(vo.getUpw())){
                    System.out.println("비밀번호 맞음 [로깅] 로그인 성공!");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mDAO 로그인중 오류발생");
        } finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
        return false;
    }

    public boolean insert(MemberVO vo) {
        conn = JDBCUtil.connect();
        try {
            pstmt=conn.prepareStatement(sql_insert);
            pstmt.setString(1, vo.getUid());
            pstmt.setString(2, vo.getUpw());
            pstmt.setString(3, vo.getUname());
            pstmt.setString(4,vo.getUemail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("MemberDAO insert중 문제발생!");
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
        return true;
    }
}
