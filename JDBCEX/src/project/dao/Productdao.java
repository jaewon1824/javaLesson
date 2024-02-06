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

import project.vo.ProductVo;

//selectByCategory , selectByPname 메소드 만듭시다
public class Productdao {

    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static List<ProductVo> selectByCategory(String Category) {
        // 2. 카테고리로 검색하기
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT WHERE CATEGORY = ?  ORDER BY PNAME";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Category);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) { // 조회결과는 n행 가능성 예측
                ProductVo vo = new ProductVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
                list.add(vo);
            }

        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public static List<ProductVo> selectByPname(String Pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT WHERE PNAME LIKE '%' || ? || '%' \r\n ORDER BY CATEGORY";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Pname);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductVo vo = new ProductVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));

                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
        }
        return list;
    }

    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> result = new HashMap<>();
        String sql = "SELECT PCODE , PRICE \r\n" +
                "FROM TBL_PRODUCT";
        try (Connection connection = getConnection(); // auto close // 1)서버와의 연결
                PreparedStatement pstmt = connection.prepareStatement(sql);) { // 2) 연결된 서버로 실행할 SQL전달 서버가 SQL 컴파일
            // 할일 2 :매개변수 바인딩 : 매개변수 타입에 맞는 메소드를 실행합시다.
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.put(rs.getString(1),
                        rs.getInt(2));
            }

            // buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수 = 0
        } catch (SQLException e) {
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }
        // close는 자동으로 합니다. finally 없음
        return result;
    }

}
