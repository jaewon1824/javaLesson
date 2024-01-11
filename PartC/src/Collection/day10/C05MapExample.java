package Collection.day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C05MapExample {

    public static void main(String[] args) {
    /*
      Map<k,v> : key 값으로 value를 가져오기.   key와 value는 모든 타입 Object입니다.
                 key 는 중복된 값을 가질 수 없습니다. key와 value 모두 순서가 없습니다.
                 맵에 입력한 순서대로 접근해야 한다면 LinkedHashMaip 또는 정렬(Key 기준)된 방식으로 접근해야 한다면 TreeMap
      Map의 구성요소 : Key, Value 중에서 Key는 Set의 특성을 갖고 있습니다. 
      
     
     
     */
      Map<String,String> map = new TreeMap<>();  //LinkedHashMap<>();  //HashMap<>();
      
      map.put("tw", "트와이스");
      map.put("nu", "뉴진스");
      map.put("as", "에스파");
      map.put("gr", "소녀시대");
      map.put("tw", "원더걸스");                // key값이 중복되어서 트와이스 -> 원더걸스
      map.put("js", "뉴진스");
      System.out.println("map 의 크기 = " + map.size());
      System.out.println("map 에 저장된 문자열 = " + map);
      Scanner sc = new Scanner(System.in);
      while(true) {System.out.println("찾을 값에 대한 key를 입력하세요. >>> ");

      System.out.println("map의 get 메소드 테스트");
      String key = sc.nextLine();
      if (key.equals("end"))        //end 입력하면 while 종료
      break;
      System.out.println("당신이 원하는 key의 값 = " + map.get(key));}
      
      System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
      System.out.println("\t map.keySet() ?" + map.keySet());
      Iterator<String> mapIterator = map.keySet().iterator();       //key값으로 반복자를 생성합니다.
      int cnt =0;
      while(mapIterator.hasNext()) {
         String temp =mapIterator.next();           //반복자가 가져온 값은 key입니다.
         System.out.println(String.format("count=%d , key= %s , value=%s", cnt++,temp,map.get(temp)));

    }
    System.out.println("== for 반복자로 출력하기 ==");
    for (String key : map.keySet()) {
        System.out.println(String.format("count=%d , key= %s , value=%s", cnt++,key,map.get(key)));
    }


    System.out.println("mpa.values() ? " + map.values());
    System.out.println("map.containsKey(\"tt\") ? " + map.containsKey("tt"));
    System.out.println("map.containsKey(\"js\") ? " + map.containsKey("js"));
    System.out.println("map.containsValue(\"에스파\") ? " + map.containsValue("에스파"));
    System.out.println("map.containsValue(\"잇지\") ? " + map.containsValue("잇지"));
}
}