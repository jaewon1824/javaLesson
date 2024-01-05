package day6;

public class B06productMain {
    public static void main(String[] args) {
        
        //product 객체를 4개 만들어보겠습니다.
        product snack = new product("새우깡", 1200, "농심", new String[3]);
        product drink = new product("사이다", 2200, "롯데", new String[3]);
        product fruit = new product("부사", 12000, "우리", new String[3]);
        product icecream = new product("투게더", 7000, "빙그레", new String[3]);
        

        //출력해봅시다.
        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);

        /*day6.product@2f92e0f4     - 2f92e0f4은 객체 참조값(식별값) -> 주소라고 부릅시다.
        day6.product@28a418fc       - day6.product 는 패키지이름. 클래스이름.
        day6.product@5305068a
        day6.product@1f32e575
        */

        System.out.println(snack.getDate());
        System.out.println(drink.getDate());
        System.out.println(fruit.getDate());
        System.out.println(icecream.getDate());

        //퀴즈 snack의 etc 필드 배열요소 0번에 "10개 묶음" 문자열을 저장하세요.
        String [] temp = snack.getEtc();             //가져온 값 어떻게 저장할까?
        temp[0]="10개 묶음";
        System.out.println(snack.getDate());
        // snack.setprice          // set 메소드 없음 -> 오류
        // snack.price = 1000;     //private  -> 오류

        product[] mycarts = new product[5];             //product 객체 배열 - product 타입으로 만들어진 객체의 참조값 저장 배열
        mycarts[0]=drink;
        mycarts[1]=icecream;
        //mycarts[2]=drink;
        mycarts[3]=fruit;
        mycarts[4]=snack;
        
        System.out.println("~~~ mycarts ~~~");
        //배열이므로 반복문으로 출력할 수 있습니다.     -getDate() 메소드 사용
        for(int i=0; i<mycarts.length; i++){
            if(mycarts[i] !=null)
            System.out.println(mycarts[i].getDate());       // mycarts[i]가 null일 때에는 메모리 할당이 안된 상태. 메소드 사용 못합니다.
        }

    }
}
