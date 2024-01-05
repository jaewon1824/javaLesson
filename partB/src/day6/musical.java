package day6;
import java.util.Arrays;

public class musical {

    private String play;
    private String theater;
    private int [] price;
    private String [] seat;
  

    
    public musical(String play, int []price, String theater, String[] seat){
        this.play=play;
        this.price=price;
        this.theater=theater;
        this.seat=seat;
     


        
    }

    public String getPlay() {
        return play;
    }
    public int[] getPrice() {
        return price;
    }
    public String getTheater() {
        return theater;
    }
    public String [] getSeat() {
        return seat;
    }
   
    public String getByte(){
       return String.format("%s\t %s\t %s\t %s",play,theater,Arrays.toString(price),Arrays.toString(seat));
    }
    
}
