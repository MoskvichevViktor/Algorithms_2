package lesson_2;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class Notebook implements Comparable<Notebook> {
    BigDecimal price;
    int memory;
    BrandName brandName;

    public  enum BrandName {
        Lenuvo, Asos, MacNote, Eser, Xamiou
    }

    @Override
    public  int compareTo(Notebook n){
        int result = price.compareTo((n.getPrice()));
        if (result == 0) {
            result = Integer.compare(memory, n.getMemory());
            if (result == 0) {
                return brandName.compareTo(n.getBrandName());
            }
            return result;
        }
        return result;
    }

}
