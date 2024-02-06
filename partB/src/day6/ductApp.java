package day6;

public class ductApp {
    public static void main(String[] args) {
        
    
    duct[] cart = new duct[10];
    
    cart[0] = new BBB(123000, "MTB", 25);
    cart[3] = new BBB(99000, "삼천리", 15);
    cart[1] = new Elect(35000, "USB");
    cart[5] = new Elect(527000, "스마트TV");
    cart[7] = new Elect(2250000, "lg냉장고");

    if(cart[5] instanceof Elect){
        Elect tv = (Elect) cart[5];
        tv.setKwh(0.9);
        System.out.println(tv.power());
    } 

    for (duct d : cart) {
        if( d != null && d.price >= 100000)
        System.out.println(d);
    }

    for(int i = 0; i < cart.length; i++){
        if(cart[i]!= null && cart[i].price >= 100000){
            System.out.println(cart[i]);
        }
    }

    for (duct b : cart) {
        if(b != null && b instanceof BBB){
            BBB B = (BBB) b;
            System.out.println(B.ride());
        
        }
    }
        System.out.println(cart[3].sell(20));

        System.out.println(cart[5].sell("사운드바"));
     

}
}
