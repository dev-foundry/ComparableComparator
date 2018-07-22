package stock;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class Stock implements Comparable<Stock> {

    private String name;
    private String symbol;
    private double price;

    public Stock(String name, String symbol, double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Stock o) {
        return new CompareToBuilder()
                .append(this.getPrice(), o.getPrice())
                .append(this.getName(), o.getName())
                .append(this.getSymbol(), o.getSymbol())
                .build();
    }

}
