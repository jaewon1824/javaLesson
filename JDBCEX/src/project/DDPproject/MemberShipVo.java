package project.DDPproject;

import java.sql.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode

public class MemberShipVo {
    private String name;
    private String customerid;
    private String email;
    private String phone;
    private int age;
    private int menuQuantity;
    private String MemberShip;
    private Date buy_date;

    public MemberShipVo(String name, String customerid, String email, String phone, int age, int menuQuantity,
            String memberShip) {
        this.name = name;
        this.customerid = customerid;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.menuQuantity = menuQuantity;
        this.MemberShip = memberShip;
    }

    @Override
    public String toString() {
        return "\n성함] : " + name + "\n [아이디] : " + customerid + "\n [이메일] : " + email + "\n [전화번호] : " + phone
                + "\n [나이] : " + age + "\n [총 구매 개수] : " + menuQuantity + "\n [멤버쉽] : " + MemberShip + "[등급";
    }

}
