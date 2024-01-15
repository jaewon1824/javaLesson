package Collection.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// JavaWord 여러개를 저장할 클래스 입니다.
//          조회 기능에 유리한 Map을 사용하겠습니다.
public class JavaWordBook {
    //굳이 List 대신 Map을 사용한 이유 : 조회와 삭제를 편하게 하려고
    //조회 이외에는 특히 출력에는 map.values()로 value값만 사용.
    private Map<String,JavaWord> wordBook;
    //key : 영어단어, key값은 중복이 안되고 순서가 없습니다.
    //value : JavaWord (영어,한글,레벨)

    //getter        //Map 객체 리턴
    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }

public JavaWordBook() {
    this.wordBook = new TreeMap<>();
    //key 값인 영어 단어 순으로 정렬하여 접근.
}

    //단어추가
    public void addword(JavaWord word){
        this.wordBook.put(word.getEnglish(), word);
    }

    //Map의 특징 - key값을 이용해서 조회와 삭제할 수 있습니다.
    //단어조회 - (비교) 리스트에서는 for 반복으로 찾기
    public JavaWord searchWord(String english) {
        return this.wordBook.get(english);
    }

    //단어삭제 - (비교) 리스트에서는 for 반복으로 찾기. 인덱스로 삭제.
    public void removeWord(String english){
        this.wordBook.remove(english);
        

    }

    //전체 단어 출력하기
    public void wordAllPrint(){
        List<JavaWord> all = new ArrayList<>(this.wordBook.values());
        wordListprint(all);
    }
    //인자로 전달된 list 출력하기
    public void wordListPrint(List<JavaWord> list){
        System.out.println("~".repeat(20)+"~ 단어장 ~ ".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %s", "<english>,", "<korea>", "<level>"));
        for(JavaWord word : list) {
            System.out.println(String.format("%-15s %-15s\t %d", word.getEnglish(),word.getKorean(),word.getLevel()));
        
    }
    }
    public List<JavaWord> searchWordByLevel(int level) {
        List<JavaWord> results = new ArrayList<>();
        // To Do : 인자로 전달된 level 만 results 리스트에 저장하기
        for (JavaWord word : this.wordBook.values()){
            if(word.getLevel()==level)
                    results.add(word);

        }
        return results;
    }
    
    


    private void wordListprint(List<JavaWord> all) {
    }
}

