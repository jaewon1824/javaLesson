package IO.day15;


import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/* 
 * 자바에서 날짜 형식을 지원하는 클래스
 * 1)java.util 패키지의 Date,Calendar 클래스 : jdk 1.1 버전부터.
 * 2)java.sql 패키지의 Date,Timestamp 클래스 : jdk 1.1 버전부터. 데이터베이스와 연동되는 타입
 * 3)java.time 패키지의 LocalDate, LocalTime, LocalDateTime 클래스 : jdk 1.8 버전부터.
 *              ㄴ 날짜, 시간과 관련된 많은 클래스 들과 메소드가 제공.
 */

public class JavaDateTypeTest {

    public static void main(String[] args) {
        
        //10진수값 출력 포맷을 지정합니다.
        DecimalFormat df = new DecimalFormat("###,###,###,###");

        long now = System.currentTimeMillis();
        System.out.println("1. 현재시간을 1970년 1월 1일 0시 기준으로 구합니다. 단위 : ms(1/1000초)");
        System.out.println("\t현재 시간 = " +now+" ms");
        System.out.println("\t현재 시간 = " + df.format(now)+" ms");
        System.out.println("--- 현재시간을 ms로 구하는 방식은 모든 프로그래밍언어에서 사용합니다.");

        System.out.println("\n2. 약 54년을 직접 ms로 계산해 봅니다.");
        long oneday = 24*60*60*1000;            //1일 24시간에 대한 ms값
        long oneyear = 365* oneday;
        System.out.println("\t1일 24시간 = " + df.format(oneday) + " ms");
        System.out.println("\t1년 365일 = " + df.format(oneyear) + " ms");
        System.out.println("\t54년 = " + df.format(54*oneyear) + " ms");
        System.out.println("\t55년 = " + df.format(55*oneyear) + " ms");

        System.out.println("\n3. 날짜 클래스로 생성합니다.");
        System.out.println("java.util.Date 클래스 :" +new Date());
        System.out.println("*java.util.Date 클래스 getTime() :" + new Date().getTime());
        System.out.println("-------------------------------------------");
        //java.sql.Date는 기본생성자 동작 없습니다. long 타입 인자가 필요합니다.
        System.out.println("*java.sql.Date 클래스 : " + new java.sql.Date(54*oneyear));
        System.out.println("*java.sql.Date 클래스 : " + new java.sql.Date(new Date().getTime()));
        
        
        System.out.println("------------------------------------------------");
        System.out.println("java.util.Calendar 클래스 : " + Calendar.getInstance());
        System.out.println("=> private 생성자이고 객체를 만들어 전달해 주는 getInstance 메소드");

        

        
    }
}