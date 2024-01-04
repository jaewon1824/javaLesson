package basic.day4;

//For문 복습 :1) ~ 5) 까지 구현.    6)구구단 출력하기(for in for)
public class A22ForReview {
    public static void main(String[] args) {
        
        int m;
        int n;
        int sum=0;        //덧셈 결과를 저장할 변수
        int result=1;     //곱셈 결과를 저장할 변수이기 떄문에 1로 시작

        //1) 1부터 정수 n까지 더하기
        n=10;
        for (int i=1; i<=n; i++)  {
             sum += i;       //sum=sum+i;
       }
        System.out.println(String.format("1부터 %d까지의 합계 : %d", n,sum));
        System.out.println("문제1) 1부터 "+n + "까지의 합계 :" +sum);
        //2) 1부터 정수 n까지 곱하기
        n=20;                   //int 타입은 정수 -2147483648 ~ +2147483647 그래서 곱셈결과 큰 값이 나올것을 예상하면 long 타입으로 합니다.
                                // n=20으로 int result에 결과를 저장하면 -음수값이 나옵니다. (오버플로우)
        long longresult=1;
        for(int i=1; i<=n; i++){
           longresult *= i;
        System.out.println(String.format("문제2) 1부터 %d까지의 곱 : %,d", n,longresult));
        }
        //3) 시작 값 정수 m부터 마지막 값 n까지 더하기
        m=5; n=8;
        sum=0;                  //초기화 꼭 필요
        for(int i=m;i<=n;i++) {
            sum+=i;
            System.out.println(String.format("문제3) %d부터 %d까지의 합계 : %d", m,n,sum));

        }
        
        //4) 시작 값 정수 m부터 마지막 값 n까지 곱하기
        m=5; n=8;
        longresult=1;       //초기화 필요
        for(int i=m; i<=n; i++) {
            longresult*=i;
            System.out.println(String.format("문제4) %d부터 %d까지의 곱셈 : %,d", m,n,longresult));
        }

        //5) 2의 n승 구하기 : 2를 n번 곱하기 (2진수에서는 많이 사용되는 연산)
        n=10;
        longresult=1;       //초기화 꼭 필요
        for(int i=1; i<=n; i++) {
            longresult*=2;
            System.out.println(String.format("문제4) 2의 %d승 구하기 : %,d", n,longresult));
        }
        



    }
    
}
