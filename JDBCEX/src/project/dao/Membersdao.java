package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.MembersVo;

public class Membersdao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void join(MembersVo vo) {
        String sql = "insert into tbl_members(code,name,email,phone_number,age) " +
                "values (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, vo.getCode());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getPhoneNumber());
            pstmt.setInt(5, vo.getAge());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        } // close

    }

    public List<MembersVo> gCode(String code) { // 쿼리로 변경 result set 변경 리스트로 변경
        List<MembersVo> list = new ArrayList<>();
        String sql = "select * from tbl_members where code = ? ";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MembersVo vo = new MembersVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));

                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(" ID 입력 오류 : " + e.getMessage());
        } // close
        return list;
    }

    public void updateN(MembersVo vo) {

        String sql = "update tbl_members set name = ? where code =?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getCode());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 실행 예외 발생 : " + e.getMessage());
        }
    }

    public void updateE(MembersVo vo) {

        String sql = "update tbl_members set email = ? where code =?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setString(2, vo.getCode());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 실행 예외 발생 : " + e.getMessage());
        }
    }

    public void updateP(MembersVo vo) {

        String sql = "update tbl_members set phone_number = ? where code =?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getPhoneNumber());
            pstmt.setString(2, vo.getCode());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 실행 예외 발생 : " + e.getMessage());
        }
    }

    public void delete(String code) {

        String sql = "delete from tbl_members where code = ?";
        try (Connection connection = getConnection(); // auto close
                PreparedStatement pstmt = connection.prepareStatement(sql);) { // 매개변수 바인딩
            pstmt.setString(1, code);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생 : " + e.getMessage());
        }
    }

    public List<MembersVo> allMembers() {
        List<MembersVo> list = new ArrayList<>();
        String sql = "select * from tbl_Members";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MembersVo vo = new MembersVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                list.add(vo);
            }

        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
        }
        return list;
    }

}
