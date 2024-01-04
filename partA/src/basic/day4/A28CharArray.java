package basic.day4;

public class A28CharArray {

// 문자열은 문자의 집합 따라서 문자열 구성하는 문자 하나씩 가져와 배열에 저장해 봅시다.
    public static void main(String[] args) {
        String message = "Hello World~ 자바는 맛있다.";
        
        //문자열의 길이 만큼 배열의 크기를 정합니다.
        char[] messageArray = new char[message.length()];

        for(int i=0; i<message.length(); i++){
            char temp = message.charAt(i);
            System.out.println(temp);
            messageArray[i] = temp;

        }
        //char 배열의 특징. 배열이름으로 println 하면 문자열처럼 출력됩니다.
        System.out.println("~~~~~~~~ 메시지 원문 :");
        System.out.println(messageArray);

        // 고대 암호 : '모모'가 '나연'이 한테 비밀 메시지를 보냅니다. 암호문을 만듭니다.
        //             두 사람이 알고 있는 비밀키 값 key=7을 정했습니다. 암호문은 ??
        int key =7;
        for(int i=0; i<message.length(); i++){
            messageArray[i]+=key;
        }
        System.out.println("~~~~~~~~ 모모가 나연이한테 보낸 비밀 메시지 :");
        System.out.println(messageArray);

        System.out.println("나연이는 받은 메시지를 읽으려면 암호문을 풀었습니다.");
        for(int i=0; i<message.length(); i++){
        messageArray[i] -=key;
    }
        System.out.println(messageArray);
}    
}
