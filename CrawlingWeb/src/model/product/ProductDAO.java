package model.product;

import model.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;

    String sql_insert = "insert into clothes(ranking, name, brand, price, image) values(?,?,?,?,?)";
    String sql_delete = "delete from clothes";
    String sql_select = "select * from clothes";
    String sql_selectSearch = "select * from clothes where name like ? or brand like ?";

    public ArrayList<ProductVO> selectSearch(String keyword) {
        ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
        ProductVO vo = null; //초기 vo null 로
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_selectSearch);
            pstmt.setString(1, "%"+keyword+"%");
            pstmt.setString(2, "%"+keyword+"%");
            rs = pstmt.executeQuery();
            while(rs.next()){
                vo = new ProductVO();
                vo.setRanking(rs.getInt("ranking"));
                vo.setName(rs.getString("name"));
                vo.setPrice(rs.getInt("price"));
                vo.setBrand(rs.getString("brand"));
                vo.setImage(rs.getString("image"));
                datas.add(vo);
            }
            rs.close();
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("product selectSearch 중 문제 발생");
        }finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
        return null;
    }


    public ArrayList<ProductVO> selectAll(){
        ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
        ProductVO vo = null; //초기 vo null 로
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_select);
            rs = pstmt.executeQuery();
            while(rs.next()){
                vo = new ProductVO();
                vo.setRanking(rs.getInt("ranking"));
                vo.setName(rs.getString("name"));
                vo.setPrice(rs.getInt("price"));
                vo.setBrand(rs.getString("brand"));
                vo.setImage(rs.getString("image"));
                datas.add(vo);
            }
            rs.close();
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("product selectAll 중 문제 발생");
        }finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
        return null;
    }

    public void insertAll(ArrayList<ProductVO> datas){
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_insert);
            for (ProductVO data : datas) {
                pstmt.setInt(1,data.getRanking());
                pstmt.setString(2,data.getName());
                pstmt.setString(3,data.getBrand());
                pstmt.setInt(4,data.getPrice());
                pstmt.setString(5,data.getImage());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("init 데이터 insert 중 문제발생");
        } finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
    }

    public void deleteAll(){
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_delete);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("init 데이터 delete 중 문제발생");
        }
    }
}
