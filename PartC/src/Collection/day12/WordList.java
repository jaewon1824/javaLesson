package Collection.day12;

import java.util.List;

import Collection.myapp.JavaWord;

public interface WordList {

    //최대 단어 개수 100개를 설정한다면
    public static final int MAX_LENGTH=100;

    //추상메소드 정의 - 구현내용은 클래스의 특징에 따라 정의됩니다.
     JavaWord getWord(int i);
    List<JavaWord> list();
    void add(JavaWord word);
    int indexOfWord(String english,int position);
    JavaWord remove(int index);
    List<JavaWord> searchAllByEnglish(String english);
    void print();

    //만약에, 이미 구현 클래스 외에
    //이후 구현에는 적용하고 싶은 메소드가 있다면
    //default 키워드로 정의

    default List<JavaWord> search(Object ojbect){
        return null;
    }
    

}