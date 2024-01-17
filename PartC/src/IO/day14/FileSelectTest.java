package IO.day14;

import javax.swing.JFrame;
import java.awt.FileDialog;
import java.util.HashMap;
import java.util.Map;
public class FileSelectTest {
    
    public static void main(String[] args) {
        
        //GUI : Graphic User Interface
        // java.awt와 java.swing에서 제공합니다.
        showDialog();
        
    }

    public static Map<String,String> showDialog(){

        JFrame jf = new JFrame();
        //jf.setSize(200, 200);
        jf.setVisible(false);

        FileDialog fd = new FileDialog(jf,"파일 선택",FileDialog.LOAD);
        fd.setVisible(true);
        // System.out.println("선택한 폴더 : " + fd.getDirectory());   //폴더 = 디렉토리
        // System.out.println("선택한 파일 : " + fd.getFile());
        // System.out.println(fd.getDirectory().replace("\\", "\\\\") + fd.getFile());
        Map<String,String> map = new HashMap<>();
        map.put("folder", fd.getDirectory().replace("\\", "\\\\"));
        map.put("filename", fd.getFile());
        return map;
    }
}
