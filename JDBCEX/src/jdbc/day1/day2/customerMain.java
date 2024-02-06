package jdbc.day1.day2;

import project.dao.TblCustomerDao;
import project.vo.customerVo;

public class customerMain {
    public static void main(String[] args) {
        System.out.println("[고객관리 시스템] 고객을 조회합니다.");
        System.out.println("고객 아이디 입력 __ ");
        String customerId = System.console().readLine();
        System.out.println("\n~~~~~~~~~ 조회 결과 ~~~~~~~~~~~~~~~~");
        TblCustomerDao dao = new TblCustomerDao();
        customerVo vo = dao.gCustomer(customerId);
        System.out.println(vo);
        if(vo==null)
            System.out.println("조회한 고객이 존재하지 않습니다.");
        else
            System.out.println(vo);
       
    }
    
}
