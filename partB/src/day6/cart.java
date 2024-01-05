package day6;


public class cart {

    private String userid;
    private String [] productNames;
    private int [] prices;
    private int total_Money;
    

   public void total_Money(int[] select){   //setter 역할
    int sum=0;
    for(int i=0; i<select.length; i++){
        int temp = select[i];
        if(temp == -1) break;       //반복문 중지 
       sum +=prices[temp];
    }
        this.total_Money=sum;
        //return sum;
   }

    public int gettotal_Money(){
        return total_Money;
    }


      /*  public void settotal_Money(int total_Money){
        this.total_Money = total_Money;
    }
    */
    public String getuserid(){
        return this.userid;
    }

    public String [] getproductNames() {
        return this. productNames;
    }

    public int [] getprices() {
        return this.prices;
    }

   
    public void setuserid(String userid){
        this.userid = userid;
    }
    
    public void setproductNames(String [] productNames){
        this.productNames = productNames;
    }

    public void setprice(int [] prices){
        this.prices = prices;
    }

  

    /*public int total_Money(int [] select){
        
        for(int i=0; i<select.length; i++){
            total_Money += select[i];
           
        }        
         return total_Money;
    }*/

    
}
