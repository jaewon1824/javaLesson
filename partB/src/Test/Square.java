package Test;

import day7.Shape;

public class Square extends Shape{              //extends Shape 로 Shape클래스를 상속받음

    
    //etc setter
    public void setEtc(String etc){
        this.etc = etc;     //Shape의 상속 클래스는 etc 필드 직접 사용
                            //protected 이기 때문에 부모의 클래스를 사용 함.
    }
    
    
    //round setter
    public void setround(int round){
    //   this.round = round;         // 오류 : Shape과 같은 패키지 아니므로 직접 사용 못함.
                                    // 접근한정자가 없는 클래스이므로 같은 패키지가 아닌 곳에서는 사용 못함.
    }

    @Override
    public void draw() {
        System.out.println("정사각형 "+ this.getShapeName() +" 를 그립니다.");
    }




}   
