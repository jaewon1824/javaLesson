package project.vo;

public class MenuVo {
    private String mcode;
    private String mname;
    private int mprice;
    private String category;

    public MenuVo(String mcode, String mname, int mprice, String category) {
        this.mcode = mcode;
        this.mname = mname;
        this.mprice = mprice;
        this.category = category;
    }

    public String getMcode() {
        return mcode;
    }

    public String getMname() {
        return mname;
    }

    public int getMprice() {
        return mprice;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "[상품코드 : " + mcode + " 상품명 : " + mname + "\t 가격 : " + mprice + "\t 카테고리 : " + category + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mcode == null) ? 0 : mcode.hashCode());
        result = prime * result + ((mname == null) ? 0 : mname.hashCode());
        result = prime * result + mprice;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
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
        MenuVo other = (MenuVo) obj;
        if (mcode == null) {
            if (other.mcode != null)
                return false;
        } else if (!mcode.equals(other.mcode))
            return false;
        if (mname == null) {
            if (other.mname != null)
                return false;
        } else if (!mname.equals(other.mname))
            return false;
        if (mprice != other.mprice)
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        return true;
    }

}
