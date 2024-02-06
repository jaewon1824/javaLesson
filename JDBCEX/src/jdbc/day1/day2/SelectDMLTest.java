package jdbc.day1.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.day1.OracleConnectionUtil;
import project.vo.customerVo;


public class SelectDMLTest {
    public static void main(String[] args) {
        // 테이블 select 결과를 메소드 실행하여 받으면 
        // 그 데이터는 콘솔에서 출력이 되거나  브라우저 화면 출력 또는 다른 목적으로 사용 될 수 있습니다.
        List<customerVo> result = selectAll_4();
        System.out.println("전체 회원 조회 결과");
        System.out.println(result);
    }
    public static List<customerVo> selectAll_4() {
        //4. 레코드 행 1개를 자바 객체와 1:1로 매핑하기 - 레코드 행이 많다면 List에 저장하기
        List<customerVo> list= new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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

    public static void selectAll_3() {
        //3. 레코드 행 1개를 자바객체와 1:1로 매핑하기
        //                  조회결과를 자바 객체로 만들어야 프로그램을 개발할 수 있습니다.
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customerVo vo = new customerVo(rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getDate(5));
                System.out.println(vo);             // customerVo 클래스의 toString 메소드로 출력합니다
                
            }
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생 ~!!" + e.getMessage());
            e.printStackTrace();
        }
       
}

    public static void selectAll_2() {
        // 2. rs.next() 를 반복해서 레코드 끝까지 위치 이동 확인하기
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            int count = 0;

            while (rs.next()) {         //읽어올 다음 레코드가 있으면 True
            System.out.println("no : " + count++);
            System.out.println(rs.getString("custom_id"));    
            System.out.println(rs.getString("name"));    
            System.out.println(rs.getString("email"));    
            System.out.println(rs.getInt("age"));    
            System.out.println(rs.getDate("reg_date"));    
            System.out.println(rs.getTimestamp("reg_date")); //java.sql.Timestamp
            }
            System.out.println("총 " + count + "개의 레코드 행을 조회 했습니다.");
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생 ~!!" + e.getMessage());
            e.printStackTrace();
        }
    }
   
    public static void selectAll_1() {
        // 1. rs.next() 로 결과 행 집합안에서 레코드 위치 이동 확인하기
        Connection connection = OracleConnectionUtil.getConnection();

        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();    //쿼리 실행하고 결과 행 집합을 처리하는 인터페이스 : ResultSet
            rs.next();  //결과 행 집합의 첫번째 행을 접근하기 위해 꼭 한번은 실행해야 할 메소드 next
                        //next 메소드는 rs객체의 다음 행을 접근 할 수 있게 포인터 이동합니다.
            System.out.println(rs.getString(1));    //1번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(2));    //2번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(3));    //3번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getInt(4));    //4번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getDate(5));    //5번 인덱스 컬럼 값 가져오기 java.sql.Date를 리턴합니다.
            System.out.println(rs.getTimestamp(5)); //java.sql.Timestamp

            rs.next();  //결과 행 집합의 첫번째 행을 접근하기 위해 꼭 한번은 실행해야 할 메소드 next
            //next 메소드는 rs객체의 다음 행을 접근 할 수 있게 포인터 이동합니다.
            System.out.println(rs.getString(1));    //1번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(2));    //2번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(3));    //3번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getInt(4));    //4번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getDate(5));    //5번 인덱스 컬럼 값 가져오기 java.sql.Date를 리턴합니다.
            System.out.println(rs.getTimestamp(5)); //java.sql.Timestamp
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생 ~!!" + e.getMessage());
            e.printStackTrace();
        }

    
    }
    
}