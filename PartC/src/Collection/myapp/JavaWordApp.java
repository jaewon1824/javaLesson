package Collection.myapp;

import java.util.List;
import java.util.Map;

public class JavaWordApp {
    public static void main(String[] args) {
        
        //단어장을 시작하는 프로그램입니다.
        
        //1. 단어장을 생성
        JavaWordBook myBook = new JavaWordBook();

        //2. 단어 추가
        JavaWord neWord = new JavaWord("public", "공용의", 1);
        myBook.addword(neWord);
        myBook.addword(new JavaWord("Private", "개인적인", 1));
        myBook.addword(new JavaWord("protected", "보호하는", 1));
        myBook.addword(new JavaWord("Iterate", "반복하다", 3));
        myBook.addword(new JavaWord("Collection", "수집", 2));
        myBook.addword(new JavaWord("application", "응용프로그램", 2));
        myBook.addword(new JavaWord("binary", "2진수의", 3));

        //메모장 출력
        myBook.wordAllPrint();

        //3. 단어 조회
        
        // 영어단어 입력하면 찾아주기
        String findText = "";
        JavaWord result = myBook.searchWord(findText);
        System.out.println(findText + "조회 결화 : " + result);

        // List<JavaWord>searchWordByLevel(int level)

       List<JavaWord> list = myBook.searchWordByLevel(3);
       myBook.wordListPrint(list);

        //4. 단어 삭제





    }
    
}
