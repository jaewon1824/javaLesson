package basic.day4;

//구글드라이브에 올리기
public class A25MySampleMethod {
    public static void main(String[] args) {
        //A22번 1) ~ 5) 을 각각 메소드로 정의해 보기 - 메소드안에서 출력문 만들지 않기
        // 1) sumToN , 2) multiply1ToN , 3) sumMToN , 4) multiplyMToN , 5) multiplyNof2
        // 6) 구구단 '출력'하는 메소드. 리턴은 void. printGuguDan
    
        
        int result = addMToN(2,5);
        boolean isOk=checkJumsu(67);
    
    
    printGuguDan();

    
    
    }
    private static boolean checkJumsu(int i) {
        return i>=0 && i<=100;
    }
    private static int addMToN(int i, int j) {
        int sum=0;
        for(int k=i; k<=j; k++){
            sum+=k;
        }
        return 0;
    }
    public static int sumToN(int a){
       
        int sum=0;
       for (int i=1; i<=a; i++)
        sum +=i;
     return sum;
    }

    public static long multiply1ToN(int n){

        long result=1;
        for(int i=1; i<=n; i++) 
            result *= i;
            return result;
        
    }

    public static int sumMToN(int d, int f) {
       
        int sum=0;
        for(int i=d; i<=f; i++) 
            sum+=i;
            return sum;
        }

    public static long multiplyMToN(int d, int f) {
       
        long result=1;
        for(int i=d; i<=f; i++) 
            result *=i;
            return result;
        
    }

    public static long multiplyNof2(int n){
     
        long result=1;
        for(int i=1; i<=n; i++) 
            result *=2;
            return result;
        
    }

    public static void printGuguDan() {
        for(int i=2; i<=9; i++) {
            for(int j=1; j<=9; j++){
            System.out.println(String.format("%3d x%3d = %3d",i,j,i*j));
            }

        }
    }
}
    
    

