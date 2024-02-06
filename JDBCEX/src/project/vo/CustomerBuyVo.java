package project.vo;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
//BUY_IDX , tb.PCODE , PNAME, PRICE, QUANTITY , BUY_DATE
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerBuyVo {
    private int Buy_idx;
    private String Pcode;
    private String Pname;
    private int Price;
    private int QUANTITY;
    private Timestamp buy_date;
    
    @Override
    public String toString() {
        return "CustomerBuyVo [" + Buy_idx + "," + Pcode + "," + Pname + "," + Price + "," + QUANTITY + 
                 "," + buy_date + "]\n";
    }


    
}
