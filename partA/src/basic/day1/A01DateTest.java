package basic.day1;
/* 패키지?
 * 인터넷 주소 https://developers.kakao.com/  와 같은 형식에서  developers.kakao.com 을 도메인네임이라고 하며 , 
 * 자바의 패키지이름은 보통 이것을 com.kakao.developers 와 같이 높은 단계 부터 표시하여 이름을 정한다.
 * 클래스의 소속 그룹을 표시하는 이름이다. 자바 객체지향프로그램은 클래스 단위로 작성이 됩니다. 개발자가 클래스 이름을 정합니다.
 */

public class A01DateTest {
public static void main(String[] args) {
    //(1)데이터 저장
    int age = 19;                                 //나이
    double weight = 57.891234567890;              //몸무게
    boolean isAdult;                              //성인 여부
    char grade = 'C';                             //등급

    //(2) 데이터 값 변경 - 대입문 또는 연산자 활용

    //예, 다이어트 한달 후에 1.3kg 감량된 몸무게
    weight = weight - 1.3;
    // weight -= 1.3;                          //weight = weight - 1.3 수식을 줄여서 쓰는 형식

    //예, 7년동안 직장생활을 열심히 하면 나이가 몇살이 되나요?
    age = age + 7;
    // age += 7;

    isAdult = age >=20;                       //실행(연산)순서 :  >= 를 실행한 후에 =(대입) 실행

    grade='B';



    
}

}
/*
 * vs code 단축키 : 
 *     저장 : Ctrl+s , 실행 : F5 , 입력 취소 : Ctrl+z
 *     한줄 복사 : Alt+Shift+위/아래방향키 , 한줄 삭제 :Ctrl+ShiftK+ 
 *     줄바꿈 : Ctrl + Enter , 같은 단어에 대한 다중 커서 : Ctrl+ Shift +L 
 *     변수명 변경 : F2  (파일명,폴더명 등등 모든 이름 변경 F2 와 동일)
 *     자동 완성 : Ctrl+스페이스바 , 라인 이동 : Alt + 위/아래방향키
 *     오류 수정 가이드 보기 : ctrl+ .
 *     왼쪽 액티브바 보이기/숨기기 ctrl + b
 *     한줄씩 실행하며 디버깅하기 : 중단점은 첫번째 명령어. -> f5로 디버깅 시작 -> f10으로 한줄씩 디버깅 확인
 */