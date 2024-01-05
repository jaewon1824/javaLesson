package day6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B05ConstructorTest {
    public static void main(String[] args) {
        
        MyClass4 my = new MyClass4();
        System.out.println("기본생성자 실행");
        System.out.println("\tfield2 : "+ my.getField2());
       
        System.out.println("\n인자 1개 커스텀 생성자 실행");
        MyClass4 my1 = new MyClass4(999);
        System.out.println("\tfield2 : "+ my1.getField2());
        MyClass4 my2 = new MyClass4("Hello");
        System.out.println("\tfield1 : "+ my2.getField1());
       
        System.out.println("\n인자2개 커스텀 생성자 실행");
        MyClass4 my3 = new MyClass4("java",222);
        System.out.println("\tmy3 field1 : "+ my3.getField1());
        System.out.println("\tmy3 field2 : "+ my3.getField2());
    
        System.out.println("\n인자3개 커스텀 생성자 실행");
        MyClass4 my4 = new MyClass4("good", 234, new double[3]);    
        System.out.println("\tmy3 field1 : "+ my4.getField1());
        System.out.println("\tmy3 field2 : "+ my4.getField2());
        System.out.println("\tmy3 field3 : "+ my4.getField3());
        System.out.println("\tmy3 field3 : "+ Arrays.toString(my4.getField3()));

        //기본생성자와 setter가 없는 MyClass5 객체생성합니다.
        MyClass5 my5 = new MyClass5("language", 1111, new double[3]);
        //MyClass5 my6 = new MyClass5();      //오류. 기본생성자가 없는 클래스입니다.

        System.out.println("MyClass5 객체 확인");
        System.out.println("\tmy3 field1 : "+ my5.getField1());
        System.out.println("\tmy3 field2 : "+ my5.getField2());
        System.out.println("\tmy3 field3 : "+ my5.getField3());

        MyClass3 test = new MyClass3();
        test.setField1("파이썬");
        System.out.println(9999);
        System.out.println(new double[]{1.2,34.56,123.45});
        //기본생성자는 set 메소드로 직접 값을 초기화하는 것이 조금 불편합니다.
        //          -> 초기화를 위해서는 커스텀 생성자가 좋습니다.

        //결론 : MyClass3 과 같이 생성자 메소드가 직접 정의된 것이 없으면 기본생성자만 사용 가능합니다.
        //                                                      ㄴ  기본 생성자가 생략되어 있는 상태입니다.
        //       MyClass5 와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면 기본생성자는 생략하고 사용못합니다.
        //                        사용하고 싶으면 직접 정의해야 합니다.
        //                              ㄴ  public MyClass5() {}
    }
    
}
