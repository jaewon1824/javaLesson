package Collection.myapp;



// 자바프로그램에서 사용되는 영어단어 데이터 저장할 클래스
public class JavaWord {
    //추상메소드 정의
   
    private String english;
    private String korean;
    private int level;          // 0 : 초급 , 1 : 중급 , 2 : 고급
    
    public JavaWord(String english, String korean, int level) {
        this.english=english;
        this.korean=korean;
        this.level=level;
    }



    @Override
    public String toString() {
        return this.english + "," + this.korean + "," + this.level;
    }
    
    //getter            //setter는 필요할 때 작성
    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }

    public int getLevel() {
        return level;
    }

    

}
