package basic.day1;

public class probChangeMoney {
    
public static void main(String[] args) {
    
    int myWon=1000000;           //여행 경비 (100만원)
    double toYen;                //환전한 엔화 값

    int cost=98760;                    //여행 비용
    int myYen;                   // 남은 여행 경비
    double toWon;                   //남은 경비 환전한 원화 값


    double yenTowonRate=9.29;    //1엔이 몇 원? 살때
    double wonToYenRate=8.97;    //1엔이 몇 원? 팔때


    
    System.out.println("::: 한/일 23.12.28 기준 환율 :::");
    System.out.println("살 때 1엔 = " + yenTowonRate);
    System.out.println("팔 때 1엔 = " + wonToYenRate);
    
    System.out.println("::: 원화를 엔화로 환전하기 :::");
    System.out.println("환전할 원화는 "  + (myWon) + "원 입니다.");
    toYen = myWon/yenTowonRate;
    System.out.println("원화를 엔화로 바꿀 때 : " + (toYen) + "원 입니다.");
    
    System.out.println("::: 엔화를 원화로 환전할 경우 :::");
    System.out.println("일본에서 사용한 금액은 " + (cost) + "엔 입니다.");
    myYen = (int)toYen - cost;
    System.out.println("남은 엔화는 얼마인가요?" + myYen + "엔");
    toWon = myYen*wonToYenRate;
    System.out.println("엔화를 원화로 바꿀 때_: "+ toWon + "원");



}}
