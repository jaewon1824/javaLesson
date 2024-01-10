package day9;

import java.util.Arrays;
import java.util.Comparator;

public class C21ArraySortTest {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int[] numbers = {67,34,77,89,82};
        System.out.println("초기 numbers = " + Arrays.toString(numbers));
        Arrays.sort(numbers);       
        System.out.println("정렬 후 numbers = " + Arrays.toString(numbers));

        
        String[] names = {"momo","nayeon","dahyeon","Zewi","Bio"};
        System.out.println("초기 names =" + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("초기 names =" + Arrays.toString(names));

        // Arrays.sort(배열변수) : 기본형 배열, String 배열의 오름차순 정렬 가능합니다.
        // -> 내림차순 정렬 또는 다른 참조타입에 대한 정렬은 메소드 두번째 인자로 정렬 기준 공식을 인터페이스로 전달합니다.

        // 순차정렬 알고리즘 : 가장 단순한 알고리즘.

        //내림차순 정렬 - Comparator는 <> 제너릭타입에 기본형을 사용 못합니다.
        //               기본형은 Wrapper 클래스 사용합니다.
        Integer[] numbers2 = {67,34,77,89,82};
        Arrays.sort(numbers2,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              
                return o2-o1;
            }

            
        });

     Arrays.sort(numbers2,(o1,o2) -> {return o2-o1;});
        
    }
}
