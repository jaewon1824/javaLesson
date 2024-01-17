package IO.day14;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;

import IO.javaword.JavaWordList;

public class ReviewProb {
    

    public static void main(String[] args) {
     
        prob_10();
        
        
    }

    public static void prob_8(){
            JavaWordList words = new JavaWordList("단어장.txt");
            words.fileLoad();
           // words.remove(-9);       //words.remove(10);
            //개발자가 만드는 예외 :
            // 1) 예외가 발생되는 문법오류, 실행 오류 없지만 값의 범위를 제한하기 위해 예외 발생
            // 2) 기존 발생하는 예외를 새로운 내용으로 변경할 때        
        }

    public static void prob_10(){
        
        byte[] buffer = new byte[20];
        try {
            //최대 20바이트 실제 입력한 바이트는 정수값 리턴
            int b = System.in.read(buffer);         //입력기능 다양하게 만든 것이 Scanner 클래스
            System.out.println("입력 바이트 수 : " + b);
            //System.out.println("입력한 문자열 : " + new String(buffer));
            System.out.println("입력한 문자열 정수 변환 : " + Integer.parseInt(new String(buffer).trim()));     //trim() 은 엔터까지 무시해줌
        } catch (IOException | NumberFormatException e) {       //2개의 예외를 처리합니다. 참고 : || 논리적인 or,|는 비트단위 or
            System.out.println("IOException 또는 NumberFormatException 예외를 처리합니다.");
          
            e.printStackTrace();
            //e.printStackTrace(); 메소드로 실행되는 결과 예시. trace는 추적하다.
            /* 예외원인을 추적해서 출력.
             * Exception in thread "main" java.lang.IllegaLAgumentException: 단어장이 꽉 찼습니다.
             */
        }

        }
    


    
}
