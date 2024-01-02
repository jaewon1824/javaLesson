package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        
        int n1 = 23,n2=34,n3=32;
        int max;
        // 1) 조건식이 참/거짓 각각 실행명령어가 다릅니다.
        if(n1>n2) {
        max=n1;
        }
        else {
        max=n2;
       }
        // 2) 조건식이 참일 때만 실행하는 명령어가 있습니다.
        if( max < n3) {
            max=n3;
            System.out.println("n1="+n1 +",n2="+n2 +",n3="+n3);
            System.out.println("최대값 max = "+ max);
        }
        
        n1=99; n2=88; n3=77;
        System.out.println("조건 삼항연산으로 다시 구현해보기");
        //조건 삼항연산을 대입문에 활용해 봅니다.
        max= (n1>n2? n1:n2);
        max = (max<n3? n3:max);
        System.out.println("n1="+n1 +",n2="+n2 +",n3="+n3);
            System.out.println("최대값 max = "+ max);
       
    }
    
}
