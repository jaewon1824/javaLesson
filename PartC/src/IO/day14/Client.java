package IO.day14;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.awt.FileDialog;

import javax.swing.JFrame;

//socket.png 그림참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다.
//                     서버와 클라이언트 연결 과정이 다르기 떄문.

public class Client {


    public static void main(String[] args) {
        Socket socket = null;
        
        try {
            System.out.println("[클라이언트] 프로그램 입니다.");
            socket = new Socket();
            //시간 중지 타임 설정
            Thread.sleep(3000);     //3초간 중지 (3000ms)
            //서버에서 설정한 bind 정보와 같은 객체를 만듭니다.
            socket.connect(new InetSocketAddress("192.168.30.29",5050));
            System.out.println("__연결성공 하였습니다.");

            //서버가 보낸 메시지 받기
            //서버가 클라이언트에게 데이터 보내기 : 출력스트림
            InputStream is = socket.getInputStream();     //클라이언트와 서버가 연결된 소켓으로 출력스트림 생성
            DataInputStream dis = new DataInputStream(is);        //보조 스트림
            String message = dis.readUTF();
            System.out.println(message);   

            //서버에게 인사말 보내기
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            System.out.println("서버에게 보낼 메시지를 쓰세요._");
            message = System.console().readLine();
            dos.writeUTF("\tFrom 클라이언트 >> " + message);

            //이미지 파일을 서버에 보내기 (업로드)
            // String filePath = "C:\\Users\\Administrator\\Downloads\\계곡.jpg";
            Map<String,String> map = FileSelectTest.showDialog();
            String filePath = map.get("folder") + map.get("filename");
            //파일명을 서버에게 보내서 서버도 원래 파일명으로 다운로드 하도록
            dos.writeUTF(map.get("filename"));
            //파일입력을 받아 소켓으로 출력하기
            FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int b;
            while ((b=bis.read()) != -1) {      //파일에서 읽어오기
                dos.write(b);                   //소켓출력                
            }
            System.out.println("파일 업로드 완료!!");

        } catch (IOException | InterruptedException e) {
                e.printStackTrace();
        }finally{
            try{socket.close(); } catch(IOException e){}
        }
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