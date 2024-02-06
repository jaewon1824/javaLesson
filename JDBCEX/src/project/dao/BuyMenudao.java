package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import project.vo.BuyMenuVo;
import project.vo.McustomBuyVo;
import project.vo.MemberShipVo;

public class BuyMenudao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int delete(int buy_index) {
        int result = 0;
        String sql = "delete from tbl_buy_menu where buy_index = ?";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, buy_index);
            result = pstmt.executeUpdate();
            // buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수 = 0
        } catch (SQLException e) {
            System.out.println("구매 취소 실행 예외 발생 : " + e.getMessage());
        } // close는 자동으로 합니다. finally 없음
        return result;
    }

    public int insert(BuyMenuVo vo) {
        String sql = "insert into tbl_buy_menu(buy_index,customer_Id,menu_id,menu_Quantity,buy_date) " +
                "values (burger_seq.nextval, ?, ?, ?, sysdate)";
        int result = 0;
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getCustomerId());
            pstmt.setString(2, vo.getMenuId());
            pstmt.setInt(3, vo.getMenuQuantity());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매하기 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }

    public int update(Map<String, Integer> arg) {
        int result = 0;
        String sql = "update tbl_buy_menu set menu_Quantity = ?  where buy_index = ?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, arg.get("menuquantity"));
            pstmt.setInt(2, arg.get("buy_idx"));
            result = pstmt.executeUpdate();
            // buy_index 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수 = 0
        } catch (SQLException e) {
            System.out.println("구매수량 수정 실행 예외 발생 : " + e.getMessage());
        } // close
        return result;
    }

    public List<McustomBuyVo> selectBuyList(String CustomerId) {
        List<McustomBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_INDEX , MENU_ID , MNAME, MPRICE, MENU_QUANTITY , BUY_DATE \r\n" +
                "FROM TBL_BUY_MENU tb\r\n" +
                "JOIN TBL_MENU tm\r\n" +
                "ON tb.MENU_ID = tm.MCODE \r\n" +
                "WHERE tb.CUSTOMER_ID = ?" +
                "ORDER BY BUY_DATE DESC";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, CustomerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                McustomBuyVo vo = new McustomBuyVo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getTimestamp(6));

                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
        }
        return list;
    }

    public List<MemberShipVo> MemberShip(String Customerid) {
        List<MemberShipVo> list = new ArrayList<>();
        String sql = " SELECT tm.*, tbm.total,\r\n" +
                "   CASE \r\n" +
                "     WHEN tbm.total BETWEEN 1 AND 10 THEN '일반'\r\n" +
                "     WHEN tbm.total BETWEEN 11 AND 20 THEN '우수'\r\n" +
                "     WHEN tbm.total > 20 THEN 'VIP'\r\n" +
                "     ELSE '기타'\r\n" +
                "   END AS MEMBERSHIP\r\n" +
                "FROM TBL_MEMBERS tm\r\n" +
                "JOIN (\r\n" +
                "   SELECT CUSTOMER_ID, sum(MENU_QUANTITY) total\r\n" +
                "   FROM TBL_BUY_MENU\r\n" +
                "   WHERE to_char(BUY_DATE, 'yyyy') = to_char(SYSDATE, 'yyyy')\r\n" +
                "   GROUP BY CUSTOMER_ID\r\n" +
                ")  tbm ON tbm.CUSTOMER_ID = tm.CODE\r\n" +
                "   WHERE CUSTOMER_ID = ?";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Customerid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberShipVo vo = new MemberShipVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("멤버쉽 예외 발생 ~!!" + e.getMessage());
        }
        return list;
    }

    public int insertMany(List<BuyMenuVo> cart) {
        String sql = "insert into tbl_buy_menu(buy_index,customer_Id,menu_id,menu_Quantity,buy_date) " +
                "values (burger_seq.nextval, ?, ?, ?, sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (BuyMenuVo vo : cart) {
                pstmt.setString(1, vo.getCustomerId());
                pstmt.setString(2, vo.getMenuId());
                pstmt.setInt(3, vo.getMenuQuantity());
                pstmt.addBatch();
                count++;
            }
            pstmt.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            }
            count = -1;
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외 발생 : " + e.getMessage());
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e1) {
            }
        }
        return count;
    }

}
