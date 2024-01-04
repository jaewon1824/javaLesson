package basic.day4;

public class A21VariableArea {
    
    static int number2=99999;               //1. 클래스 범위에서 사용되는 변수
    int number=999;                         
    public static void main(String[] args) {
        
        //변수ㅠ의 선언 위치 -> 변수 사용 범위가 결정됩니다.
        int a= 23;                          //2. 메인 메소드 범위에서 사용되는 변수

        for(int i=0; i<10; i++){            //3. for(특정) 블럭 안에서 사용되는 변수 - i
            System.out.println("i= "+i);
            
        }

        while (a==23) {                //참
        int count;                          //3. while(특정) 블럭 안에서 사용되는 변수 -count
            System.out.println(("a=" +a));
            count=100;
            System.out.println("count=" +count);
            a=24;                      //종료 조건이 없으면 무한 반복(loop)
        }

        
        System.out.println("a="+a);
        
        System.out.println("i="+i);             //문법적인 오류 - 이 지점에서 i는 알 수 없는 변수 for에서 끝났기 때문
        System.out.println("count="+count);     //문벅적인 오류 - 이 지점에서 count 역시 알 수 없는 변수 while에서 끝남
       /* 
            진도를 이후에 나갈 내용입니다. : main 메소드가 static 메소드입니다. static은 static끼리만 서로 사용할 수 있습니다. static main 이기 때문에 static가 없는 number은 오류
        */
        //system.out.println("number="+ number);        //static이 아닌 클래스 선언 변수는 사용 못함.
        System.out.println("number="+number);   
        System.out.println("number="+number2);
    }
    
}
