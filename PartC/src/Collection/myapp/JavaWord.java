package Collection.myapp;

// 자바프로그램에서 사용되는 영어단어 데이터 저장할 클래스
public class JavaWord {
    private String english;
    private String korea;
    private int level;          // 0 : 초급 , 1 : 중급 , 2 : 고급
    
    public JavaWord(String english, String koea, int level) {
        this.english=english;
    }



    @Override
    public String toString() {
        return this.english + "," + this.korea + "," + this.level;
    }
    
    //getter            //setter는 필요할 때 작성
    public String getEnglish() {
        return english;
    }

    public String getKorea() {
        return korea;
    }

    public int getLevel() {
        return level;
    }

    

}
