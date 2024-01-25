package koreait.test;

public abstract class Product {
    protected int price;
    protected String prdName;

   

   public String getPrdName() {
       return prdName;
   }
   public int getPrice() {
       return price;
   }

   public void setPrdName(String prdName) {
       this.prdName = prdName;
   }

   public void setPrice(int price) {
       this.price = price;
   }

   public abstract String sell(Object object);
@Override
public String toString() {
    return "prdName=" + prdName + ", pirce=" + price;
}


   
}
