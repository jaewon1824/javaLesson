package day7;

//Shape 클래스 상속 예시2
public class Diamond extends Shape{
    
    
    //생성자 정의가 명시적으로 없으면 기본생성자르 실행
    //자식 클래스는 부모클래스 기본생성자를 먼저 생성합니다.

    //자식이지만 부모가 private 으로 했으므로 오류
    //public void setShapeName(String shapeName){
     //   this.shapeName = shapeName;
    //}

    //부모가 protected로 선언한 필드는 자식은 자유롭게 접근 가능함.
    public void setEtc(String etc){
        this.etc=etc;
    }


    
    @Override
    public void draw() {
       System.out.println("다이아몬드 "+ this.getShapeName() +" 를 그립니다.");
       
    }

    //자식클래스가 정의한 인스턴스 메소드 -Diamond 타입으로 선언한 참조변수만 실행할 수 있음
    public void iAmDiamond(){
        System.out.println("나는 다이아몬드 ~ 반짝반짝!!");
    }


    
    public void setround(int round){
        this.round=round;
    }


    //Object 클래스의 toString 메소드를 오버라이드
    //                  ob2 toString = day7.Diamond@1fb3ebeb 가 기본인 것을 다른 문자열로 바꿈.
    @Override
    public String toString() {
        return "Diamond []";
    }

    /* 
     * 접근 한정자
     * public               : 모두에게 공개
     * private              : 모두에게 숨기기 같은 클래스 안에서만 사용. (은닉성)
     * protected            : 같은 패키지 클래스와 (다른 패키지인 경우)자식에게만 공개
     *                           ㄴ Shape의 etc는 자식인 Triangle, Diamond 에게는 공개 / 같은 패키지 B10DiamondTest 에게도 공개
     *                           ㄴ 그 외의 경우는 비공개. 다른 패키지이지만 자식 클래스라면 공개
     * 아무것도 안씀         : 거의 사용하지 않습니다. 같은 패키지 클래스에게만 공개
     *                          ㄴ day7패키지 클래스에게는 모두 공개 / 그 외에는 숨기기
     */

    
    
}
