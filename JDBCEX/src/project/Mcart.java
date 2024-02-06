package project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.dao.BuyMenudao;
import project.dao.Membersdao;
import project.dao.Menudao;
import project.vo.BuyMenuVo;
import project.vo.McustomBuyVo;
import project.vo.MembersVo;
import project.vo.MenuVo;

public class Mcart {

    private BuyMenudao buyDao = new BuyMenudao();
    private Menudao Menudao = new Menudao();
    private List<BuyMenuVo> cart = new ArrayList<>(); // 장바구니
    private Membersdao memberdao = new Membersdao();

    private Map<String, Integer> priceMap = null;

    public Mcart() {

        this.priceMap = Menudao.getPriceMap();

        System.out.println(priceMap);
    }

    private void showMenu() {
        System.out.println(".".repeat(100));
        System.out.println("\t[C] 카테고리별 상품 조회        [P] 상품명 검색");
        System.out.println("\t[M]나의 구매내역               [D] 환불           [X] 구매 종료");
        System.out.println("\t[J]회원가입 [E]회원정보 검색    [S]회원정보 변경    ");
        System.out.println("\t::장바구니::[A] 담기  [L] 목록  [R] 삭제   [Q] 구매 수량 변경  [Y] 모두 구매 ");
        System.out.println(".".repeat(100));
    }

    private void showMyPage(String customerid) {
        List<McustomBuyVo> result = buyDao.selectBuyList(customerid);
        for (McustomBuyVo vo : result)
            System.out.println(vo);
    }

    private void showMenuListByCategory() {
        System.out.println("카테고리 : 버거  사이드  음료  기타");
        System.out.print("카테고리 입력__");
        String Category = System.console().readLine();
        List<MenuVo> MenuList = Menudao.selectCategory(Category);
        for (MenuVo vo : MenuList)
            System.out.println(vo);
    }

    public void searchMenuListByMname() {
        System.out.print("상품명 검색어 입력__");
        String Mname = System.console().readLine();
        List<MenuVo> MenuList = Menudao.selectMname(Mname);
        for (MenuVo vo : MenuList)
            System.out.println(vo);
    }

    public void searchmembers(String customerid) {
        System.out.print("아이디 검색어 입력__");
        String code = System.console().readLine();
        System.out.println(buyDao.MemberShip(code));
    }

    private void addCartItem(String customerid) {
        System.out.println(".................. 장바구니 :: 물품 담기 ...................");
        System.out.print("구매할 상품코드 입력하세요.__");
        String menuId = System.console().readLine();
        System.out.print("구매할 수량 입력하세요.__");
        int menuquantity = Integer.parseInt(System.console().readLine());
        cart.add(new BuyMenuVo(0, customerid, menuId, menuquantity, null));
    }

    private void showCartList() {
        long totalMoney = 0;
        System.out.println(".................. 장바구니 :: 목록 보기...................");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("번호 : " + i + " 물품 : " + cart.get(i));
            totalMoney += cart.get(i).getMenuQuantity() * priceMap.get(cart.get(i).getMenuId());
        }
        System.out.println("총 구매금액 : " + totalMoney);
    }

    private void removeCartItem() {
        System.out.println(".................. 장바구니 :: 물품 삭제 ...................");
        System.out.print("삭제할 번호 입력__");
        int index = Integer.parseInt(System.console().readLine());
        if (index < 0 || index >= cart.size()) {
            System.out.println("잘못된 장바구니 상품번호 입니다.");
            return; // 메소드 종료
        }
        cart.remove(index);
        System.out.println("물품을 장바구니에서 삭제했습니다.");
    }

    private void buyCartItems() {
        if (cart.size() == 0) {
            System.out.println("장바구니가 비었습니다. 물품을 담아주세요~~");
            return;
        }
        System.out.println(".................. 장바구니 :: 물품 모두 구매 ...................");
        int result = buyDao.insertMany(cart);
        if (result > 0) {
            System.out.println("물품 구매가 정상적으로 완료되었습니다.");
            cart.clear();
        } else {
            System.out.println("장바구니 물품 구매 실패했습니다.");
        }
    }

    private void removemenu() {
        System.out.println("구매 취소할 번호 입력 __");
        int buy_idx = Integer.parseInt(System.console().readLine());
        if (buyDao.delete(buy_idx) == 1)
            System.out.println("정상적으로 취소되었습니다.");
        else
            System.out.println("없는 구매번호 입니다.");
    }

    private void modifymenu() {
        System.out.println("장바구니에서 수정할 구매 번호를 입력하세요. __");
        int index = Integer.parseInt(System.console().readLine());
        System.out.println("변경할 수량을 입력하세요. __");
        int menuquantity = Integer.parseInt(System.console().readLine());

        if (index < 0 || index >= cart.size()) {
            System.out.println("잘못된 장바구니 상품번호 입니다.");
            return;
        }
        cart.get(index).setMenuQuantity(menuquantity);
        System.out.println("장바구니에서 수량이 변경되었습니다.");
    }

    private void joinmember() {
        System.out.println("가입하실 아이디를 입력하세요. __");
        String newCode = System.console().readLine();
        System.out.println("가입하실 성함을 입력하세요. __");
        String newName = System.console().readLine();
        System.out.println("가입하실 이메일을 입력하세요. __");
        String newEmail = System.console().readLine();
        System.out.println("가입하실 핸드폰번호를 입력하세요. __");
        String newPhoneNumber = System.console().readLine();
        System.out.println("가입하실 고객님의 나이를 입력하세요. __");
        int newAge = Integer.parseInt(System.console().readLine());
        System.out.println("회원가입이 완료되었습니다.");
        MembersVo vo = new MembersVo(newCode, newName, newEmail, newPhoneNumber, newAge);

        memberdao.join(vo);
    }

    private void joinupdate() {
        boolean run = true;

        System.out.println("변경하실 회원의 아이디를 입력해주세요. __");
        String customerid = System.console().readLine();
        while (run) {
            System.out.print("변경하실 회원정보를 영어로 입력해주세요. __ ");
            String select = System.console().readLine();

            switch (select) {
                case "name":
                    System.out.println("변경하실 이름을 입력해주세요. __");
                    String name = System.console().readLine();
                    MembersVo vo = new MembersVo(customerid, name, null, null, 0);
                    vo.setName(name);
                    memberdao.updateN(vo);
                    break;

                case "email":
                    System.out.println("변경하실 이메일 주소를 입력해주세요. __");
                    String email = System.console().readLine();
                    MembersVo vo1 = new MembersVo(customerid, null, email, null, 0);
                    vo1.setEmail(email);
                    memberdao.updateE(vo1);

                    break;
                case "phone":
                    System.out.println("변경하실 휴대폰번호를 입력해주세요. __");
                    String phoneNumber = System.console().readLine();
                    MembersVo vo2 = new MembersVo(customerid, null, null, phoneNumber, 0);
                    vo2.setPhoneNumber(phoneNumber);
                    memberdao.updateP(vo2);

                    break;
                default:
                    run = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Mcart app = new Mcart();
        app.start();

    }

    public void start() {

        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        List<MembersVo> list = memberdao.gCode(customerid);
        if (list.size() <= 0) {
            System.out.println("아이디를 찾을 수 없습니다.");
            System.out.println("구매를 위해 필요한 사용자 회원가입을 시작합니다.");
            joinmember();
            return;
        } else {
            System.out.println(customerid + " 님 환영합니다.♡");
        }
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("선택 >>> ");
            String select = System.console().readLine();
            switch (select) {
                case "M", "m":
                    showMyPage(customerid);
                    break;
                case "E", "e":
                    searchmembers(customerid);
                    break;
                case "J", "j":
                    joinmember();
                    break;
                case "S", "s":
                    joinupdate();
                    break;
                case "D", "d":
                    removemenu();
                    break;
                case "Q", "q":
                    modifymenu();
                    break;
                case "C", "c":
                    showMenuListByCategory();
                    break;
                case "P", "p":
                    searchMenuListByMname();
                    break;
                case "A", "a":
                    addCartItem(customerid);
                    break;
                case "L", "l":
                    showCartList();
                    break;
                case "R", "r":
                    removeCartItem();
                    break;
                case "Y", "y":
                    buyCartItems();
                    break;
                case "X", "x":
                    run = false;
                    break;
                default:
                    break;
            }
        }

    }
}
