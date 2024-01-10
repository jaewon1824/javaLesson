package day7;

public class day7Answer {

    /* OX 문제 답

        1)O
        2)X
        3)X
        4)X
        5)O


      단답형 문제 답

      extends

      객관식 문제 답

      1) 1,3
      2) 1

      코딩문제 답

*/
}

class Mountain {

	private double heieht;
	
	public Mountain(double heieht) { 
        this.heieht = heieht; 
        }
	
	protected double getHeieght() { 
        return heieht; 
    }
}




class Bukhansan extends Mountain {
	
    private int time;
	
	public Bukhansan(double heieht, int time) {
		super(heieht);
		this.time = time;
	}
	protected int getTime() { return time; }
	
	public void print() {
		System.out.println("북한산의 정상 높이는 : " +getHeieght() +" 이며 " +"보통 소요되는 시간은 "+ time + " 시간 정도이다.");
	}
}




