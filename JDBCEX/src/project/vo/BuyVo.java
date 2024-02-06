package project.vo;

import java.sql.Date;

public class BuyVo {
    
    private int Buy_idx;
    private String customId;
    private String Pcode;
    private int quantity;
    private Date buy_date;
    
    public BuyVo(int buy_idx, String customId, String pcode, int quantity, Date buy_date) {
        Buy_idx = buy_idx;
        this.customId = customId;
        Pcode = pcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }
    public int getBuy_idx() {
        return Buy_idx;
    }
    public String getCustomId() {
        return customId;
    }
    public String getPcode() {
        return Pcode;
    }
    public int getQuantity() {
        return quantity;
    }
    public Date getBuy_date() {
        return buy_date;
    }
    @Override
    public String toString() {
        return "BuyVo [Buy_idx=" + Buy_idx + ", customId=" + customId + ", Pcode=" + Pcode + ", quantity=" + quantity
                + ", buy_date=" + buy_date + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Buy_idx;
        result = prime * result + ((customId == null) ? 0 : customId.hashCode());
        result = prime * result + ((Pcode == null) ? 0 : Pcode.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
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
        BuyVo other = (BuyVo) obj;
        if (Buy_idx != other.Buy_idx)
            return false;
        if (customId == null) {
            if (other.customId != null)
                return false;
        } else if (!customId.equals(other.customId))
            return false;
        if (Pcode == null) {
            if (other.Pcode != null)
                return false;
        } else if (!Pcode.equals(other.Pcode))
            return false;
        if (quantity != other.quantity)
            return false;
        if (buy_date == null) {
            if (other.buy_date != null)
                return false;
        } else if (!buy_date.equals(other.buy_date))
            return false;
        return true;
    }

    
    
}
