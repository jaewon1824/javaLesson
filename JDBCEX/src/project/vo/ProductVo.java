package project.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class ProductVo {
    
    private String Pcode;
    private String Category;
    private String Pname;
    private int Price;
    
    @Override
    public String toString() {
        return String.format("%6s %15s %40s\t %,8d", Category,Pcode,Pname,Price);
    }

    
}
