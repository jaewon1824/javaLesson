package basic.day3;

import java.util.Scanner;

// if ~ else if ~ else if ~ ....
public class A18IfElseIfTest {

	public static void main(String[] args) {
		
		int menu;

		System.out.println(":::: 쇼핑몰 사용자 마이페이지 ::::");
		System.out.println("1:장바구니   2:찜 상품   3.배송 조회   4.구매 목록  5.종료");
		System.out.print("선택 하세요. >>>> ");
		
		menu=4;
		
		//동일한 값인지 비교 : 관계연산자 == 또는 != 
		if(menu==1) {
			System.out.println("장바구니 🎁🎁🎁🎁 .많이 담아 주세요.");
		}else if(menu ==2) {
			System.out.println("찜 상품 입니다.❤❤");
		}else if(menu ==3) {
			System.out.println("배송 조회 🚚🚛🚚🚛 ");
		}else if(menu ==4) {
			System.out.println("구매 목록 입니다.");
		}else if(menu ==5) {
			System.out.println("종료 입니다.");
		}else {
			System.out.println("잘못된 선택 입니다.");
		}
		
		System.out.println("메뉴 선택 종료합니다.");


		int jumsu = 100;
		String grade;
		//점수가 90~100이면 'A' , 80~89점이면 'B' , 70~79점이면 'C' , 60~69점이면 'D' , 60점 미만은 'F'
		
		//유효한 점수 데이터 인지 검사합니다.
		if(jumsu > 100 || jumsu < 0) {
			System.out.println("점수는 0~100 사이의 정수값 입니다.");
			return;				//main 결과를 반환. 프로그램 종료가 됩니다.
		}

		// 100점 보다 큰 값은 일단 제외하고 간단하게 예시.
		if(jumsu >=90) grade="A";
		else if( jumsu>=80)  grade="B";   //점수가 90점보다 작은 값일떄
		else if( jumsu>=70)  grade="C";
		else if( jumsu>=60)  grade="D";
		else // 점수가 60점보다 작은 값
			grade="F";

		System.out.println("점수 =" + jumsu + ", 학점=" +grade);
		
		
	}
	
}

