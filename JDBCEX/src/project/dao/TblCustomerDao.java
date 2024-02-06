package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.customerVo;

public class TblCustomerDao {

    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //회원가입
    public void join(customerVo vo){
        // 할일 1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
        String sql="insert into tbl_custom(custom_id,name,email,age,reg_date) " + 
        "values (?, ?, ?, ?, sysdate)";
        try (Connection connection = getConnection();       //auto close    // 1)서버와의 연결 
            PreparedStatement pstmt = connection.prepareStatement(sql);)  {     //2) 연결된 서버로 실행할 SQL전달 서버가 SQL 컴파일
                //할일 2 :매개변수 바인딩 : 매개변수 타입에 맞는 메소드를 실행합시다.
                pstmt.setString(1, vo.getCustomeId());
                pstmt.setString(2, vo.getName());
                pstmt.setString(3, vo.getEmail());
                pstmt.setInt(4, vo.getAge());

                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally 없음
    }

    //회원정보수정
    public void modify(customerVo vo) {

        String sql=  "update tbl_custom set email = ?, age = ? where custom_id = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   //매개변수 바인딩
                pstmt.setString(3, vo.getCustomeId());
                pstmt.setString(1, vo.getEmail());
                pstmt.setInt(2, vo.getAge());

                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("modify 실행 예외 발생 : " + e.getMessage());
        }
    }
    //회원 탈퇴
    public void delete(String customerId) {

        String sql=  "delete from tbl_custom where custom_Id = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   //매개변수 바인딩
                pstmt.setString(1, customerId);
               
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생 : " + e.getMessage());
        }
    }

    //회원정보 PK 조회 - 조회 결과 행 개수는? : select * from tbl_custom where custom_id = ?
    //                    ㄴ 0개 : 조회 결과 없다. 조회결과가 있다면 only 1개
    //                    ㄴ 리턴 타입 customerVo
    public customerVo gCustomer(String customerId){
        customerVo vo = null;
        String sql = "select * from tbl_custom where custom_id = ?";
        
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, customerId);
                ResultSet rs = pstmt.executeQuery();

            if(rs.next()){  //첫번째 행 조회결과가 있으면 true, 없으면 false
                //할일 : 객체 만들어서 vo변수에 참조시키기
                vo = new customerVo(rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getDate(5));
            }
        } catch (SQLException e) {
            System.out.println(" getCustomer 예외 발생 ~!!" + e.getMessage());
        }
        return vo;
    }


    //관리자를 위한 기능 : 모든 회원정보 조회 : select * from tbl_custom
    public List<customerVo> allCustomers() {
        List<customerVo> list= new ArrayList<>();
        String sql = "select * from tbl_custom";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customerVo vo = new customerVo(rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getDate(5));
                list.add(vo);   
            }
            
           // dao 메소드에는 특별한 목적이 아니면 출력문 작성 안합니다.
        } catch (SQLException e) {
            System.out.println(" 예외 발생 ~!!" + e.getMessage());
            e.printStackTrace();
        }
        return list;        //select 조회 결과를 자바객체 List와 매핑하여 리턴.
    }
    
}
