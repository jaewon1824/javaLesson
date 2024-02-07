package jdbc.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.dao.Productdao;
import project.dao.tblBuyDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

//static 이 많아지면 상속의 특징을 사용할 수 없습니다. 멀티 스레드 환경에 적합하지 않습니다.
//       -> 여기서는 테스트를 위해 static 사용 중입니다.
public class CartApp_2 {

    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회     [P] 상품명 검색    [M] 나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }

    public static void showMyPage() {

    }

    public static void main(String[] args) {

        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerId = System.console().readLine();
        System.out.println(customerId + " 님 환영합니다.");
        boolean run = true;

        while (run) { // 메뉴 선택 반복
            tblBuyDao buyDao = new tblBuyDao();
            showMenu();
            System.out.println("선택 >>> ");
            // int select = Integer.parseInt(System.console().readLine());
            String select = System.console().readLine();
            switch (select) {
                case "M", "m": // 나의 구매내역
                    List<CustomerBuyVo> result = buyDao.selectBuyList(customerId);
                    for (CustomerBuyVo vo : result)
                        System.out.println(vo);
                    break;

                case "C", "c":
                    System.out.println("카테고리 : A1-과일 A2-수입과일 B1-인스턴스 B2-선물세트 C1-과자류");
                    System.out.println("카테고리 입력__");
                    String category = System.console().readLine();
                    List<ProductVo> productList = Productdao.selectByCategory(category);
                    for (ProductVo vo : productList)
                        System.out.println(vo);
                    break;

                case "P", "p":
                    System.out.println("상품명 검색어 입력__");
                    String Pname = System.console().readLine();
                    productList = Productdao.selectByCategory(Pname);
                    for (ProductVo vo : productList)
                        System.out.println(vo);
                    break;

                case "B", "b":
                    System.out.print(" 상품코드를 입력하세요. __ ");
                    String pcode = System.console().readLine();

                    System.out.print(" 수량을 입력하세요. __ ");
                    int quantity = Integer.parseInt(System.console().readLine());

                    BuyVo vo = new BuyVo(0, customerId, pcode, quantity, null);

                    if (buyDao.insert(vo) == 1)
                        System.out.println("상품을 담았습니다.");
                    else // 참조테이블에 없는 값 입력했을 때
                        System.out.println("상품코드 또는 고객아이디 오류입니다.");
                    break;

                case "D", "d":
                    System.out.println("구매 취소할 번호 입력 __");
                    int buy_idx = Integer.parseInt(System.console().readLine());
                    if (buyDao.delete(buy_idx) == 1)
                        System.out.println("정상적으로 취소되었습니다.");
                    else
                        System.out.println("없는 구매번호 입니다.");
                    break;

                case "Q", "q":
                    System.out.println("수정할 구매 번호를 입력하세요. __");
                    buy_idx = Integer.parseInt(System.console().readLine());
                    System.out.println("변경할 수량을 입력하세요. __");
                    quantity = Integer.parseInt(System.console().readLine());
                    // Map을 사용해봅시다.
                    Map<String, Integer> arg = new HashMap<>();
                    arg.put("buy_idx", buy_idx);
                    arg.put("quantity", quantity);
                    // quantity = Integer.parseInt(System.console().readLine());
                    // vo = new BuyVo(Buyidx, customerId, null, quantity, null);
                    if (buyDao.update(arg) == 1)
                        System.out.println("정상적으로 수정완료 되었습니다.");
                    else
                        System.out.println(("없는 구매번호 입니다."));
                    break;

                case "X", "x":
                    run = false;
                    break;
                default:
                    break;
            }
        }

    }
} // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java
  // 테이블 컬럼과 1:1 대응되는 BuyVo.java
  // 테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.
  // insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.
