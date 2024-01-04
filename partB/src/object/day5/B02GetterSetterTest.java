package object.day5;

public class B02GetterSetterTest {
    public static void main(String[] args) {
        
        MyClass2 momo = new MyClass2();
        System.out.println("MyClass2 의 field1 값(초기) :"+ momo.getField1());
        momo.setFiled1("나는 모모!!");
        System.out.println("MyClass2 의 field1 값(변경 후) :"+ momo.getField1());
        String message = "WELCOME~!!";
        momo.setFiled1(message);
        System.out.println("MyClass2 의 field1 값(변경 후) :"+ momo.getField1());
    

        
        System.out.println("MyClass2 의 field2 값(초기) :"+ momo.getField2());
        momo.setFiled2(999);
        momo.printDate();
        System.out.println("MyClass2 의 field2 값(변경 후) :"+  momo.getField2());
        int test = 1212;
        momo.setFiled2(test);
        System.out.println("MyClass2 의 field2 값(변경 후) :"+ momo.getField2());
        System.out.println("지금까지의 momo 객체 값들은... ");

        momo.printDate();

        System.out.println("~~~ field3은 double배열 타입입니다. ~~~ :");
        double [] dArray = momo.getField3();
        System.out.println("field3 : " +dArray);
        System.out.println("field 3 : "+momo.getField3());
        double [] tempArray = {1.2,3.44,67.12};
        System.out.println("변경된 field3 확인합니다.");
        momo.printDate();
        momo.setFiled3(new double[5]);
        momo.setFiled3(tempArray);
        System.out.println("변경된 field3 확인합니다.");
        momo.printDate();
        
        //setField3을 변수로 전달했을 때

        tempArray[2]=3.1415;
        System.out.println("변경된 field3 확인합니다.");
        momo.printDate();
        


       
        
    
       
}
}
