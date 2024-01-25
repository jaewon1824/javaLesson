package IO.day15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        
        System.out.println("1. 현재 날짜와 시간을 구하여 출력하기");
        LocalDate currentDate = LocalDate.now();        //객체생성 메소드 now(), new 연산을 대신함.
        System.out.println("\tLocalDate 현재 날씨 : " + currentDate);

        System.out.println("2. ");
        LocalTime currnTime = LocalTime.now();          //10억분의 1초(ns) 까지 구해줍니다.
        System.out.println("\tLocalTime 현재 시간 : " + currnTime);
        
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("\tLocalTime 현재 날짜와 시간 : " + currDateTime);

        System.out.println("2. 특정 날짜와 시간을 지정해서 객체를 생성합니다.");
        LocalDate mybirth = LocalDate.of(1994, 02, 18);
        // of 메소드 : 객체를 생성하고 값을 초기화합니다.
        LocalTime mybirth_time = LocalTime.of(17, 20);
        System.out.println("\tLocalDate.of(1994, 02, 18)" + mybirth);
        System.out.println("\tLoclalTime.of(17, 20) : " + mybirth_time);

        //java.time 패키지에 다른 클래스 테스트
        System.out.println("3. 날짜 사이의 간격 계산하기");
        System.out.println("\t내가 태어난지 ..년 ..월 ..일 이 지났습니다.");
        Period between = Period.between(mybirth, currentDate);
        System.out.println(between.getYears() + " 년");
        System.out.println(between.getMonths() + " 월");
        System.out.println(between.getDays() + " 일");


        System.out.println("4. 날짜 사이의 간격 계산하기(단위 : 년 또는 월 또는 일)");
        System.out.println("\t내가 태어난지 ...년(개월 또는 일)이 지났습니다.");
        System.out.println(ChronoUnit.DAYS.between(mybirth, currentDate) + " 일");
        System.out.println(ChronoUnit.MONTHS.between(mybirth, currentDate) + " 월");
        System.out.println(ChronoUnit.YEARS.between(mybirth, currentDate) + " 년");

        System.out.println("5. 내 생일로부터 10000일 이후 날짜는?");
        LocalDate day10000 = mybirth.plusDays(10000);
        System.out.println("\t10000 이후 = " + day10000);

        System.out.println("6. 오늘 날짜로부터 10000일 이전 날짜는?");
        LocalDate before10000 = currentDate.minusDays(10000);
        System.out.println("\t10000 이전 = " + before10000);
        System.out.println("7. 계산 검증 테스트 - 3일 이전");
        System.out.println(currDateTime.minusDays(3));
        System.out.println(currDateTime.plusDays(3));

        System.out.println("8. 날짜의 출력 패턴 설정하기");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
        // 시간 hh 분 mm 초 ss 밀리세컨드 SSS     월과 분의 mm이 겹쳐 월은 대문자 MM 구분
        System.out.println(currentDate.format(formatter));
        System.out.println(currDateTime.format(formatter2));
        
        
    }
}
