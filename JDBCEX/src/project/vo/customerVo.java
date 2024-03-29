package project.vo;

import java.sql.Date;
//Value Object : 데이터 형식으로서 정의되는 클래스
//              ㄴ private 필드, 값 초기화 커스텀 생성자, getter, hashcode, equals 재정의
//              ㄴ 객체 생성시 값을 초기화 한 후 변경할 수 없으며, 필드값이 같으면 같은 값으로 처리되는 객체
public class customerVo {                    //tbl_custom 테이블의 컬럼과1:1 대응되는 변수로 정의.
    private String customeId;
    private String name;
    private String email;
    private int age;
    private Date reg_date;
    
    public customerVo(String customeId, String name, String email, int age, Date reg_date) {
        this.customeId = customeId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.reg_date = reg_date;
    }

    public String getCustomeId() {
        return customeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Date getReg_date() {
        return reg_date;
    }

    @Override
    public String toString() {
        return "customerVo ["+customeId +"," + name + "," + email + "," + age + ","
                + reg_date + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customeId == null) ? 0 : customeId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + age;
        result = prime * result + ((reg_date == null) ? 0 : reg_date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        customerVo other = (customerVo) obj;
        if (customeId == null) {
            if (other.customeId != null)
                return false;
        } else if (!customeId.equals(other.customeId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (age != other.age)
            return false;
        if (reg_date == null) {
            if (other.reg_date != null)
                return false;
        } else if (!reg_date.equals(other.reg_date))
            return false;
        return true;
    }


    //참고 : 아래 2개의 메소드가 재정의 되어야 진짜 VO입니다.
    //          ㄴ 필드값이 같으면 값이 같은 객체로 처리됩니다.
    
    

    
}
