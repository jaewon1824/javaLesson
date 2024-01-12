package Collection.day11;

import java.util.ArrayList;
import java.util.List;



//1월 14일 저녁 9시까지 제출해주세요.
    public class CustomerManageApp {
    //JavaWordAppV2 형식으로 하세요. -구글 공유 드라이브
    private List<Customer> custom = new ArrayList<>();
    private void start() {
        initialize();
        //메뉴 선택 : 등록,검색(이름/그룹), 삭제, 수정, 전체출력
        System.out.println(" 고객정보 프로그램을 실행합니다. ".repeat(1));
        while(true){
        System.out.println(" -- 메뉴를 선택하세요. --");
        System.out.println("\t 1. 고객 등록 ");
        System.out.println("\t 2. 고객 목록 출력 ");
        System.out.println("\t 3. 고객 검색 ");
        System.out.println("\t 4. 고객 삭제 ");
        System.out.println("\t 5. 고객 정보 수정 ");
        System.out.println("\t 6. 프로그램 종료 ");
        System.out.println(" 선택 >>> ");
        int select = Integer.parseInt(System.console().readLine());

        switch (select) {
            case 1:
                    addInfo();              //단어등록 메소드 실행
                    break;
            case 2:
                    listInfo();             //단어 목록 조회 메소드 실행
                    break;
            case 3:
                    searchInfo();           //단어 목록 조회 메소드 실행
                    break;
            case 4:
                    removeInfo();           //단어 목록 조회 메소드 실행
                    break;
            case 5:
                    modifyInfo();       
                    break;
            case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);     //main 실행을 종료
                    break;
            default:
                    break;
        } //switch end
    }
}

    private void initialize() {
        custom.add(new Customer("momo","3842 8462" , 2));
        custom.add(new Customer("dahy","5648 0474" , 1));
        custom.add(new Customer("sana","1876 8452" , 3));
        custom.add(new Customer("mimi","8756 1542" , 3));
        custom.add(new Customer("nana","7865 1657" , 2));
}



    private void removeInfo() {
      
        
        System.out.println("\t::고객님의 정보를 삭제합니다.::");
        System.out.println("삭제할 고객님의 존함을 입력해주세요. _");
        String find = System.console().readLine();
        boolean re = false;        
        for (int i = 0; i < custom.size(); i++) {
            if(custom.get(i).getName().equals(find)){
                re = true;
                System.out.println("인덱스 "+ i +"에서 고객님의 정보를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요.");
                if(System.console().readLine().equals("n"))
                        continue;
                else {
                custom.remove(i); System.out.println("고객님의 정보가 삭제되었습니다."); }
                } //if end
                
        } //for end
            
        if(!re)         //re==false
        System.out.println("삭제할 단어는 단어장에 없습니다.");
            
        
    }
    private List<Customer> searchInfo(String name){
        List<Customer> list = new ArrayList<>();
        for(Customer info : custom){
            if(info.getName().equals(name)){
                list.add(info);         //일치하는 단어를 만날때마다 저장
            }
        }
        return list;
    }

    private List<Customer> searchInfo(int group) {
        List<Customer> list = new ArrayList<>();
       for (Customer info : custom) {
            if(info.getGroup()==group) {
                list.add(info);         //일치하는 단어를 만날 때 마다 저장
            }
        
       }
            return list;       
    }

    private void searchInfo() {
        System.out.println("\t::고객님의 정보를 검색합니다.(성함으로 조회는 1 , 등급 조회는 2 )::");
        String find = null;
        List<Customer> list = null;                 //조회되는 결과를 리턴받아 참조할 변수입니다.
        switch (System.console().readLine()){           //키보드 입력을 변수에 저장하지 않고 직접 swicth에 작성.
            case "1" :
                System.out.println("찾으실 고객님의 성함을 영문으로 입력하세요. _");
                find = System.console().readLine();
                list = searchInfo(find);
                break;
            case "2" :
                System.out.println("찾으실 고객님의 등급을 입력하세요. _");
                find = System.console().readLine();
                int group = Integer.parseInt(find);
                list = searchInfo(group);
                break;
            default :
                System.out.println("1,2만 입력하세요.");
                return;
        }
        System.out.println("\t:: 검색 결과 입니다. ::");
        if(list.size()==0) System.out.println("찾으시는 고객님이 없습니다.");
        else printList(list);
    }

    private void printList(List<Customer> list){
        for (Customer custom : list) {
            System.out.println(String.format("%20s %20s %20s", 
            custom.getName(),custom.getPhone(),custom.getGroup()));
    }
}

    private void listInfo() {
        System.out.println(String.format("%20s %20s %20s", "NAME","PHONE","GROUP"));
        printList(custom);
       
    }

    private void addInfo() {
      
        System.out.println("\t::고객정보 등록합니다.::");
        System.out.print("고객님의 이름을 입력해주세요. _ ");
        String name = System.console().readLine();
        System.out.print("전화번호를 입력해주세요. _");
        String phone = System.console().readLine();
        System.out.println("고객님의 등급을 입력해주세요. (1:일반 2:vip 3:기타) _");
        int group = Integer.parseInt(System.console().readLine());

        custom.add(new Customer(name, phone, group));
        
    }

    
    //엔터치면 수정안되고 기존걸로 다시 입력되고 입력을하면 수정이 되도록,,,,,,
    private void modifyInfo(){
        System.out.println("\t 고객정보 변경합니다.");
        System.out.println("변경하실 고객님의 성함을 입력해주세요. _");
        String name = System.console().readLine();
        System.out.println("변경하실 고객님의 번호를 입력해주세요. _");
        String phone = System.console().readLine();
        System.out.println("변경하실 고객님의 등급을 입력해주세요. (1:일반 2:vip 3:기타) _");
        int group = Integer.parseInt(System.console().readLine());
       
        for( Customer modify : custom ){
        if(System.console().readLine().equals(name))
                        continue;
                else {
                custom.modify(group, phone); 
                System.out.println("고객님의 정보가 변경되었습니다."); }
        
            }
        }
        

            
        
        
    
        
    









    public static void main(String[] args) {
        CustomerManageApp app = new CustomerManageApp();
        app.start();
    }

    
    
    
}
