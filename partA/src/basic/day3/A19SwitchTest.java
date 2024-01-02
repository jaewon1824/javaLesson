package basic.day3;

import java.util.Scanner;

//switch 는 if 조건식이 equal (==) 을 여러번 검사하는 경우에 사용.
//		   조건식에서 검사하는 값은 정수(byte,short,int,long), char, 문자열 형식만 가능합니다.
public class A19SwitchTest {

	public static void main(String[] args) {

		// 키보드 입력 : 진도 상관없이 방법만 알고 써보겠습니다.


		int menu =3;
		Scanner sc = new Scanner(System.in);           //system.in 은 표준입력
		boolean run=true;                   //while에 쓰일 조건 변수
       while(run){		//종료조건은 사용자가 '5'를 입력하는 것입니다.
		System.out.println(":::: 쇼핑몰 사용자 마이페이지 ::::");
		System.out.println("1:장바구니   2:찜 상품   3.배송 조회   4.구매 목록  5.종료");
		System.out.print("선택 하세요. >>>> ");
		menu = sc.nextInt();               //키보드 입력을 위한 커서가 보이면 값을 입력해 주세요.

		switch (menu) {
			case 1:    //menu==1 ?
				System.out.println("장바구니 🎁🎁🎁🎁 .많이 담아 주세요.");
				break;	   //아래의 명령어들을 실행하지 않고 switch{ .. } 를 끝냅니다.
			case 2:   //menu==2 ?
				System.out.println("찜 상품 입니다.❤❤");
				break;
			case 3:   //menu==3 ?
				System.out.println("배송 조회 🚚🚛🚚🚛 ");
				break;
			case 4:   //menu==4 ?
				System.out.println("구매 목록 입니다.");
				break;
			case 5:   //menu==5 ?
				System.out.println("종료 입니다.");
				run = false;
				break;
			default:   //값이 1,2,3,4,5 모두 아닌경우
				System.out.println("잘못된 선택 입니다.");
				break;
		}   //switch 끝
	}		//while  끝
	System.out.println("프로그램을 종료합니다.");

		
	} //main 끝

} //class end
