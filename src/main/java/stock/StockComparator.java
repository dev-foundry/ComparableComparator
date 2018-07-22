package stock;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

public class StockComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock o1, Stock o2) {
        return new CompareToBuilder()
                .append(o1.getPrice(), o2.getPrice())
                .append(o1.getName(), o2.getName())
                .append(o1.getSymbol(), o2.getSymbol())
                .build();
    }

}
