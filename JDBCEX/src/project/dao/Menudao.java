package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.MenuVo;

public class Menudao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<MenuVo> selectCategory(String Category) {
        // 2. 카테고리로 검색하기
        List<MenuVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_Menu WHERE CATEGORY = ?  ORDER BY MNAME";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Category);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) { // 조회결과는 n행 가능성 예측
                MenuVo vo = new MenuVo(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4));
                list.add(vo);
            }

        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
        }
        return list;
    }

    public List<MenuVo> selectMname(String Mname) {
        List<MenuVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_Menu WHERE MNAME LIKE '%' || ? || '%'";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Mname);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MenuVo vo = new MenuVo(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4));

                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
        }
        return list;
    }

    public Map<String, Integer> getPriceMap() {
        Map<String, Integer> result = new HashMap<>();
        String sql = "SELECT MCODE , MPRICE \r\n" +
                "FROM TBL_Menu";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.put(rs.getString(1),
                        rs.getInt(2));
            }

        } catch (SQLException e) {
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }
        return result;
    }

}
