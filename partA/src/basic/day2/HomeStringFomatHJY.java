package basic.day2;

public class HomeStringFomatHJY {
    
   public static void main(String[] args) {
    
    int t = 100;
    System.out.println(String.format("10진수(%d) : 2진수(%s), 8진수(%o), 16진수(%x)", t, Integer.toBinaryString(t), t, t));

    
    
    int i = 23;

    System.out.println(String.format("%d_", i));
    System.out.println(String.format("%5d_", i));
    System.out.println(String.format("%-5d_", i));
    System.out.println(String.format("%05d_", i));



    i = 123456789;

    System.out.println(String.format("%,d_", i));
    System.out.println(String.format("%,15d_", i));
    System.out.println(String.format("%,-15d_", i));
    System.out.println(String.format("%,015d_", i));
    



    
    i = 123456789;

    System.out.println(String.format("%,d_", i));
    System.out.println(String.format("%,15d_", i));
    System.out.println(String.format("%,-15d_", i));
    System.out.println(String.format("%,015d_", i));




    double n = 123.45678;

    System.out.println(3.4);
    System.out.println(n);
    System.out.println();

    System.out.println(String.format("%f_", 3.4));
    System.out.println(String.format("%f_", n));
    System.out.println(String.format("%.6f_", n));
    System.out.println(String.format("%15f_", n));
    System.out.println(String.format("%-15f_", n));
    System.out.println(String.format("%.3f_", n));
    System.out.println(String.format("%.2f_", n));
    System.out.println(String.format("%15.2f_", n));
    System.out.println(String.format("%-15.2f_", n));
    System.out.println(String.format("%015f_", n));
    System.out.println(String.format("%015.2f_", n));


   System.out.println("Unicode 코드 → 문자");
   System.out.println(String.format("48 → %c, 57 → %c", 48, 57));
   System.out.println(String.format("65 → %c, 90 → %c", 65, 90));
   System.out.println(String.format("97 → %c, 122 → %c", 97, 122));
   System.out.println(String.format("44032 → %c, 55203 → %c", 44032, 55203)); //  U+AC00, U+D7A3
   }


   
   


}
