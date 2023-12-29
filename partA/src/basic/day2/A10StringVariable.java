package basic.day2;

public class A10StringVariable {
    
    public static void main(String[] args) {
        //string은 문자열 : 문자('')의 집합. 문자열 리터럴은 기호 ""를 사용합니다.
        String message = "Hello~ 안녕!! 하이하이";

        //char imo = '😊' ;     //char은 2byte 이모지는 4바이트 따라서 문자형으로 저장이 안됨.
        String imo = "😂";    // 이모지는 문자열로 저장해야 합니다.
        System.out.println(message);
        System.out.println("메세지 '" + message + "'의 길이 :" + message.length());

        message = "welcome~ java world!!!!";
        System.out.println("메세지 '" + message + "'의 길이 :" + message.length());

        // String 으로 선언된 변수는 '객체'입니다. 그래서 메소드를 갖고 필요한 기능들을 제공해줍니다.
        System.out.println(imo);

        //자바 string의 중요한 메소드 7가지씩 조사해서 테스트해보기

        String start = "저녁";
        String end = "뭐 먹지";
        System.out.println(start.concat(end));

        String star = "dofemfdklfjefj six";
        String moon = star.substring(15);
        System.out.println(moon);

        String memo = "dkluyhfklewqanfkl wsdahjf";
        System.out.println(memo.indexOf('w'));
        System.out.println(memo.lastIndexOf('w'));
        System.out.println(memo.charAt(19));
        System.out.println(imo.isEmpty());
        
        String hot = "summer icecream";
        String cool = hot.replace("summer", "winter");
        System.out.println(cool);
        String hotup = hot.toUpperCase();
        System.out.println(hotup);
        String hotlo = hotup.toLowerCase();
        System.out.println(hotlo);
        System.out.println(hot.substring(0, 1).toUpperCase());
        
    }
}
