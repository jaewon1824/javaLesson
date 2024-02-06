package day6;

public class BBB extends duct{

    private int speed;

    public BBB(int price, String prdname , int speed) {
        this.price = price;
        this.prdName = prdname;
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String ride(){
        return "당신은 이것을 시속 " + speed + "km 로 탈 수 있습니다.";
    }
    @Override
    public String sell(Object object) {
        return String.format("[%s]행사 - %s%%인하", prdName,object);
    }
    @Override
    public String toString() {
        return "BBB ["+prdName + speed + price+"]";
    }

}

class Elect extends duct{

    private double kwh;

    public Elect(int price, String prdname) {
        this.price = price;
        this.prdName = prdname;

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
        return String.format("[%s]증정 - %s", super.prdName,object);
    }
    @Override
    public String toString() {
        return "Elect["+prdName +",\t"+ price +",\t"+ kwh+"]";
    }

    
}
