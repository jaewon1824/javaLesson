package basic.day4;

public class A23GuguDan {
    public static void main(String[] args) {
        
        /*
         *  구구단은 반복의 반복입니다.
         *  2에 곱하기를 1부터 9까지 합니다. (1~9까지)
         *  3에 곱하기를 1부터 9까지 합니다.
         * ,,,
         * ,,,
         * ,,,
         */
    
    for(int i=2;i<=9;i++)
    {   
        System.out.println("지금 ..." +i + "단을 출력합니다.");
        for(int j=1;j<=9;j++) {
        System.out.println(String.format("%3d x %3d = %3d", i,j,i*j));
    
    }
    }
    
    
    
    
    
        }
    
}
