package basic.day1;

//변수 활용 연습  (1줄 주석 단축키는 ctrl + / )
/*문제  : 어떤 학생의 중간고사 총점은 322 , 과목수는 4개 입니다. 모두 항상 정수입니다.
	이 학생의 평균을 구하려고 합니다. 변수는 총점은 sum, 과목개수는 count 로 합니다.
	평균(나눗셈 연산은 / )를 계산합니다.  정수 / 정수 = 정수 
	1) 평균을 저장할 변수를 정수 avgInt   2) 평균을 저장할 변수를 실수 avgDouble 각각 해보세요.
	계산한 1) 2)를 각각 출력 합니다. => 오류가 생길까요?
*/
public class A04DataCasting {

	public static void main(String[] args) {
		int sum;
		int count;
		int avgInt;
		double avgDouble;
		
		//업데이트 예정 : 사용자로부터 값을 입력하도록 합니다.
		sum =322;
		count=4;
		avgInt = sum/count;
		avgDouble = sum/count;		            //1)
		// sum/count 는 정수연산으로 결과는 80. 이 값이 double 변수에 저장되면서 .0 만 생깁니다. 
		
		System.out.println("정수형식 평균 :" + avgInt);
		System.out.println("실수형식 평균 :" + avgDouble);
		
		// sum 또는 count 중 하나를 실수 형식으로 바꾸어서 나눗셈을 하면 결과가 80.5 가 나옵니다.
		avgDouble = (double)sum/count;			//2)sum을 강제로 변환(캐스팅)
		System.out.println("실수형식으로 변환 후 평균 :" + avgDouble);
		

		System.out.println("자동 캐스팅도 있습니다.");
		double dnum = 34;           // dnum은 double 형식, 34는 정수형식. 정수를 실수로 변환은 자동
		//int inum = 3.1415;          // inum은 int 형식, 3.1415는 실수형식. 실수를 정수로 변환은 강제(수동)
	    int inum=(int)3.1415;
     
	    System.out.println("자동 캐스팅된 34 = " + dnum);
		System.out.println("강제(수동) 캐스팅된 3.1415 = " + inum);
		inum = (int)3.6789;
		System.out.println("강제(수동) 캐스팅된 3.6789 =" + inum);

	 /*
	  * 복습 : 기본 자료형을 크기 순서대로 나열해 봅시다.
	  * byte < short < int < long < float <double
	  *  1       2      4      8      4      8             byte     
	  * 
	  * char 문자형을 코드값 구하기 위해 정수로 캐스팅할 때 0~65535를 충분히 저장할 수 있는
	  * int 정수형으로 캐스팅합니다.
	   */
	
	} 
}
