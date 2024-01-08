package day6;

public class musicalMain {
    
    public static void main(String[] args) {
        

     

        musical play = new musical("연극",new int[4],"LG아트센터",new String[4]);
        musical musical = new musical("뮤지컬",new int[4],"블루스퀘어",new String[4]);
        musical movie = new musical("영화",new int[4],"메가박스",new String[4] );
        musical opera = new musical("오페라",new int[4],"세종문화회관",new String[4] );
        musical concert = new musical("콘서트",new int[4],"월드컵경기장",new String[4]);

        
        String[] temp = play.getSeat();
        temp[0]="VIP";
        temp[1]="OP";
        temp[2]="Royal";
        temp[3]="Super";

        String[] inum = musical.getSeat();
        inum[0]="VIP";
        inum[1]="OP";
        inum[2]="Royal";
        inum[3]="Super";

        String[] yn = movie.getSeat();
        yn[0]="COMFORT";
        yn[1]="MX";
        yn[2]="DOLBY";
        yn[3]="pUPPY";

        String[] en = opera.getSeat();
        en[0]="VIP";
        en[1]="OP";
        en[2]="Royal";
        en[3]="Super";

        String[] tp = concert.getSeat();
        tp[0]="Standing";
        tp[1]="FREE";
        tp[2]="Royal";
        tp[3]="Super";

        int[] pr = play.getPrice();
        pr[0]=180000;
        pr[1]=150000;
        pr[2]=130000;
        pr[3]=100000;

        int[] pre = musical.getPrice();
        pre[0]=180000;
        pre[1]=150000;
        pre[2]=130000;
        pre[3]=100000;

        int[] prt = movie.getPrice();
        prt[0]=18000;
        prt[1]=15000;
        prt[2]=13000;
        prt[3]=10000;

        int[] prf = opera.getPrice();
        prf[0]=170000;
        prf[1]=140000;
        prf[2]=130000;
        prf[3]=100000;

        int[] prs = concert.getPrice();
        prs[0]=100000;
        prs[1]=80000;
        prs[2]=70000;
        prs[3]=60000;


        System.out.println(play.getByte());
        System.out.println(musical.getByte()); 
        System.out.println(movie.getByte());
        System.out.println(opera.getByte());
        System.out.println(concert.getByte());


        

        
    }
    
}
