package jdbc.day1.day2;

public class CartApp {
    public static void main(String[] args) {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.println("아이디 입력 __");

        //상품 목록을 선택한 카테고리에 대해 보여주기   (구매할 상품 조회)
        //또는 상품명으로 검색  (구매할 상품 조회)
        //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
        
        System.out.println("[1] 구매하기   [2] 구매 취소    [3] 구매수량 변경   [4] 구매 종료");
        int select = Integer.parseInt(System.console().readLine());
        boolean run = true;
        
        System.out.println(" 프로그램 시작합니다. ".repeat(1));
       
       
        while (run) {       //메뉴 선택 반복
            
            System.out.println("\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 구매 하기");
            System.out.println("\t 2. 구매 취소");
            System.out.println("\t 3. 구매수량 변경");
            System.out.println("\t 4. 구매 종료");
            System.out.println("선택 > ");
            
            
            
            
            
            
            
            
            
            
            
            switch (select) {
                case 1 :            //[1] 장바구니 담기 - buy 에 insert (1행)
                    
                    break;

                case 2 :            //[2] 구매 취소 - delete
                           
                    break;

                case 3 :            //[3] 구매수량 변경 - update
                   
                    break;

                case 4 :
                    
                    break;
                           
                            
                default:
                    break;
            }
        }
    }
}   //tbl_buy 테이블을 대상으로 insert update delete 할 수 있는 dao클래스 만들기 tblBuyDao.java
    //        테이블 컬럼과 1:1 대응되는 BuyVo.java
    //        테이블 PK 컬럼은 Buy_idx -> update, delete 의 조건 컬럼입니다.
