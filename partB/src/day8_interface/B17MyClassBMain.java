package day8_interface;

public class B17MyClassBMain {
    public static void main(String[] args) {
        
        MyClassB myb = new MyClassB();

        //다중구현 클래스인 MyClassB는 두가지 업 캐스팅 가능합니다.
        InterfaceA ifa = new MyClassB();
        InterfaceX ifx = new MyClassB();

        

        myb.methodA();
        myb.methodB(12);
        myb.methodC("흠");
        ifx.methodX();
        ifa.methodA();
        //ifx.methodA();              //오류 : methodA는 InterfaceA의 추상메소드 methodX는 InterfaceX의 추상메소드
        //ifa.methodX();              // 다른 인터페이스 참조 타입으로는 메소드 실행 못함.
       
        InterfaceX ix = (InterfaceX) ifa;      
        ix.methodX();


    }
    
}
