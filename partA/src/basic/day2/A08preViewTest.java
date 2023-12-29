package basic.day2;

public class A08preViewTest {

  
    public static void main(String[] args) {
          char start = 'A';

    // 반복명령 while 맛보기 while은 ~하는 동안 (조건이 참인 동안에)
     while(start<='Z')  {      // <= 는 작거나 같다(비교) 
    System.out.println(start++);
    }
    System.out.println();
    while (start> 'A'){
        System.out.print(--start);
    }
}
}





















