package basic.day2;

public class A09CharacterTest {
    public static void main(String[] args) {
        

        /*
         * 1. 문자 '나' 부터 '냿' 까지 while문으로 출력해보기  -> 변수 char start= '나';
         * 2.  모두 몇개의 문자가 있는지 갯수 구하기. int codeNa, codeNet 
         */
        
        char start = '나';
        char end = '낟';
        int codeNa = start;
        
        while (start<=end) {
            System.out.println(start++);
        } 
        int codeNad = end;
        
        System.out.println("\nstart=??" + start);

        System.out.println("\n\n\n'나'~'낟'까지 문자의 개수 = " + (codeNad-codeNa+1));
        
    
    
    
    
    }  
    }
    

