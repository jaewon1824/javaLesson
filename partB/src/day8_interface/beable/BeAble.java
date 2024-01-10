package day8_interface.beable;

@FunctionalInterface		// 추상메소드가 1개인지 체크해주는 주석
public interface BeAble {			//~~ 할 수 있는
	String beAble(); 		// 1개이므로 오류가 아님
}

/**
 * InnerBeAble
 */
interface InrBeAble {
	//public 이 아닌 인터페이스를 하나 더 정의할 수 있습니다.
	//한개의 파일에 여러개 클래스 또는 인터페이스 정의 가능함.

	
}
