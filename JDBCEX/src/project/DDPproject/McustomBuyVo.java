package project.DDPproject;

import java.sql.Timestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter

public class McustomBuyVo {

    private int buy_idx;
    private String menuid;
    private String mname;
    private int mprice;
    private int mQuantity;
    private Timestamp buy_date;

    public McustomBuyVo(int buy_idx, String menuid, String mname, int mprice, int mQuantity, Timestamp buy_date) {
        this.buy_idx = buy_idx;
        this.menuid = menuid;
        this.mname = mname;
        this.mprice = mprice;
        this.mQuantity = mQuantity;
        this.buy_date = buy_date;
    }

    @Override
    public String toString() {
        return "[상품번호 : " + buy_idx + "\t상품코드 : " + menuid + "\t상품명 : " + mname + "\t가격 : " + mprice
                + "\t구매한 개수 : " + mQuantity + "\t구매한 날짜 : " + buy_date + "]";
    }

}
