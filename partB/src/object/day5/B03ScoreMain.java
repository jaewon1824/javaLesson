package object.day5;

import java.util.Arrays;

public class B03ScoreMain {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        //학생 4명의 성적을 저장해보세요.
        //1학년 2명(모모,다현) 3과목    2학년 2명(나연,쯔위) 4과목
        //  점수는 마음대로 저장하세요.

      
          
            Score jae = new Score(); 
    
            jae.setname("모모");
            jae.setgrade(1);
            int [] lnum = jae.getjumsues();
            int inum [] = {45, 67, 43};
            
            
            System.out.println(jae.getname()+"의 학년은"+ jae.getgrade() +"학년 입니다. \n올해 모모의 성적은 각각 " + Arrays.toString(inum)+"입니다.") ;


            jae.setname("다현");
            jae.setgrade(1);
            int inumh [] = {65, 87, 54};
            
            
            System.out.println(jae.getname()+"의 학년은"+ jae.getgrade() +"학년 입니다. \n올해 다현의 성적은 각각 " + Arrays.toString(inumh)+"입니다.") ;


            jae.setname("나연");
            jae.setgrade(2);
            int inumg [] = {86, 37, 64, 23};
            
            
            System.out.println(jae.getname()+"의 학년은"+ jae.getgrade() +"학년 입니다. \n올해 나연의 성적은 각각 " + Arrays.toString(inumg)+"입니다.") ;


            jae.setname("쯔위");
            jae.setgrade(2);
            int inuma [] = {82, 57, 34, 93};
            
            
            System.out.println(jae.getname()+"의 학년은"+ jae.getgrade() +"학년 입니다. \n올해 쯔위의 성적은 각각 " + Arrays.toString(inuma)+"입니다.") ;


            jae.printScore();
        }

    
    

    }
    

