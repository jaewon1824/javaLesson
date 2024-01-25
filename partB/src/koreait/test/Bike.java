package koreait.test;


// 객체의 구성 요소 : 인스턴스 필드와 인스턴스 메소드
// 클래스의 구성 요소 : 객체의 구성 요소 + static 메소드와 필드
// 클래스는 객체가 만들어지는 인스턴스 요소를 정의하는 상위 개념.
public class Bike extends Product {
  
    
    private int speed;
  
    public Bike(int speed, int price, String prdName) {
        this.speed = speed;
        this.price = price;
        this.prdName = prdName;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //getter setter ride 메소드 : 인스턴스 필드를 대상으로 처리 기능을 갖습니다. 인스턴스 메소드
    //                            객체 = 인스턴스
    public String ride() {
        
       return "당신은 이것을 시속 " + this.speed + "km로 탈 수 있습니다.";
    }


    @Override
    public String sell(Object object) {
        return String.format("[%s] 행사 - %d%%인하" , prdName,object);
        
    }

    @Override
    public String toString() {
        return "Bike [" + super.toString()+", speed=" + speed + "]";
    }


    

    

    

    

}

class Electronics extends Product {
    private double kwh;             //필드 : 클래스에 소속된 변수. 클래스 전역에 사용가능한 변수

    public Electronics(int price, String prdName) {
       
        this.price=price;
        this.prdName=prdName;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double power(){
        return kwh*24;
    }

    @Override
    public String sell(Object object) {
    
        return String.format("[%s]증정-%s", prdName,object);
    }

    // product 클래스에서 toString 재정의 한 것을 자식클래서가 또 다시 재정의
    // 또는 직접 입력
    @Override
    public String toString() {
        return "Electronics ["+super.toString()+", kwh=" + kwh + "]";
    }

    
   

   

   

}
