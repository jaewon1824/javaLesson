package basic.day4;

public class probStringReverse {
    public static void main(String[] args) {
        
        String message = "Hello World";         //length : 11, 인덱스는 0~10
        char[] messagearray = new char[message.length()];
        System.out.println("기존 원문");
        System.out.println(message);

        int cidx = message.length()-1;              // 10
        for(int i=0; i<message.length();i++){
            char temp = message.charAt(i);          //i = 0 일 때 
            messagearray[cidx]=temp;                //cidx=10
            //i=1 일 때 cidx = 9
            cidx--;
        }
      
        System.out.println(messagearray);

        

  
    }
    
}
