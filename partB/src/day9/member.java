package day9;


/* 
 * 인터페이스 예시 - 비교 가능한 객체 만들기
 *              ㄴ 객체 비교 방법 1) Comparable 인터페이스 구현하도록 합니다.
 * Comparable<member> 는 <>안에 타입을 표시합니다. 이런 방식을 제너릭타입
 *                    제너릭 타입은 클래스 또는 인터페이스의 메소드에게 타입을 매개변수로 전달하기 위한 방식.
 *                    이 때 타입이 실행 시점에서 결정되기 때문이다. 기본형은 Wrapper클래스로 사용
 *                    Comparable 인터페이스가 실행하는 메소드에 member 타입을 전달합니다.
 * Comparable : 비교할 수 있는
 */
public class member implements Comparable<member> {
    private String id;
    private int age;

    public member(String id, int age){
        this.id=id;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    
    @Override
    public String toString() {
        return "member [id=" + id + ", age=" + age + "]\n";
    }

    //Comparable 인터페이스의 추상메소드 comaparTo 를 구현합니다.
    @Override
    public int compareTo(member o) {        //메소드의 인자 타입 member는 <> 제너릭타입과 동일하게 만들어집니다.
            //현재 객체 this를 인자로 전달하는 member 객체와 비교합니다.
            //비교 기준은 요구사항에 따라 개발자가 정합니다.
            //만약에 이름으로 한다면
           // return this.id.compareTo(o.id);           //오름차순
           return o.id.compareTo(this.id);              //내림차순. 순서가 변경되어
            //만약에 나이로 한다면
      
       // return this.age - o.age;                      
       // return o.age-this.age;
    }
}
