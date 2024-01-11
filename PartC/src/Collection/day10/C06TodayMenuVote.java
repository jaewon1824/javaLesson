package Collection.day10;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;             //Map안에서 구성요소로 정의된 Entry 요소

public class C06TodayMenuVote {
    //Map 연습
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String menu = "Chicken, Spaghetti, Gopchang, Bulgogi, Pork belly";
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("Chicken", 0);
        map.put("Spaghetti", 0);
        map.put("Gopchang", 0);
        map.put("Bulgogi", 0);
        map.put("Pork belly", 0);

        System.out.println("오늘의 메뉴 투표합니다.");
        System.out.println("메뉴 = " + menu);
        Scanner sc = new Scanner(System.in);
         
        while (true) {
            System.out.println("영문 메뉴 이름 입력 >>> ");
            String key = sc.nextLine();
            if(key.equals("end")) break;
            if(map.containsKey(key)){
            int value = map.get(key);
            // value++; map.put(key, value); =
           map.put(key,++value);
            } else{
           //없는 메뉴 입력하면
        System.out.println("투표에 없는 메뉴이군요. 추가하겠습니다.");
        map.put(key,1);         //새로운 메뉴 초기화
        menu += "," + key;            //메뉴 문자열 수정
        }

        
        }
        System.out.println("투표가 종료되었습니다.");
        System.out.println(map);
        System.out.println(Collections.max(map.keySet()));
        System.out.println(Collections.max(map.values()));
        // value 최대값의 key는 무엇?           //key,value 를 한쌍으로 만든 타입이 Entry

        Comparator<Entry<String,Integer>> comparator = new Comparator<Entry<String,Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                
                return o1.getValue()-o2.getValue();
            }

            
        };

        Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),comparator);
        System.out.println("최다 득표 결과");
        System.out.println("\t 메뉴이름 : " + maxEntry.getKey());
        System.out.println("\t 투표수 : " + maxEntry.getValue());

        sc.close();
      
    }
    
}
