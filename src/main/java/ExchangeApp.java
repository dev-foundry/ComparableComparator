import org.apache.commons.lang3.builder.CompareToBuilder;
import stock.Stock;
import stock.StockComparator;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ExchangeApp {

    public static void main(String[] args) {

        List<Integer> prices = Arrays.asList(1, 5, 32, 76, 3, 21, 7, 333, 43, 221);

        System.out.println("Nieposortowane: " + prices);

        Collections.sort(prices);

        System.out.println("Posortowane rosnąco: " + prices);

        Collections.reverse(prices);

        System.out.println("Posortowane malejąco: " + prices);

        System.out.println("---------------------------------");

        Stock stock1 = new Stock("cd projekt blue", "cdp", 5.23);
        Stock stock2 = new Stock("amazon", "amz", 5.23);
        Stock stock3 = new Stock("amazon", "aat", 5.23);
        Stock stock4 = new Stock("google", "ggl", 7.08);
        Stock stock5 = new Stock("apple", "apl", 7.08);

        List<Stock> stockList = Arrays.asList(stock1, stock2, stock3, stock4, stock5);

        stockList.forEach(System.out::println);

        Collections.sort(stockList);

        System.out.println("COMPARABLE ---------------------------------");

        stockList.forEach(System.out::println);

        System.out.println("COMPARATOR ---------------------------------");

        Collections.sort(stockList, new StockComparator());

        stockList.forEach(System.out::println);

        System.out.println("COMPARATOR LAMBDA ---------------------------------");

        Comparator<Stock> stockComparator = (o1, o2) -> new CompareToBuilder()
                .append(o1.getPrice(), o2.getPrice())
                .append(o1.getName(), o2.getName())
                .append(o1.getSymbol(), o2.getSymbol())
                .build();

        stockList.sort(stockComparator);

        stockList.forEach(System.out::println);

        System.out.println("COMPARATOR STREAM ---------------------------------");

        List<Stock> sortedStocks = stockList.stream()
                .sorted(stockComparator)
                .collect(Collectors.toList());

        sortedStocks.forEach(System.out::println);

        System.out.println("TREESET 1 ---------------------------------");

        TreeSet<Stock> stockTreeSet1 = new TreeSet<>();

        stockTreeSet1.add(stock1);
        stockTreeSet1.add(stock2);
        stockTreeSet1.add(stock3);
        stockTreeSet1.add(stock4);
        stockTreeSet1.add(stock5);

        stockTreeSet1.forEach(System.out::println);

        System.out.println("TREESET 2 ---------------------------------");

        TreeSet<Stock> stockTreeSet2 = new TreeSet<>(stockComparator);

        stockTreeSet2.add(stock1);
        stockTreeSet2.add(stock2);
        stockTreeSet2.add(stock3);
        stockTreeSet2.add(stock4);
        stockTreeSet2.add(stock5);

        stockTreeSet2.forEach(System.out::println);

        System.out.println("TREEMAP ---------------------------------");

        TreeMap<Stock, String> stockStringTreeMap = new TreeMap<>(stockComparator);

        stockStringTreeMap.put(stock1, "stock 1");
        stockStringTreeMap.put(stock2, "stock 2");
        stockStringTreeMap.put(stock3, "stock 3");
        stockStringTreeMap.put(stock4, "stock 4");
        stockStringTreeMap.put(stock5, "stock 5");

        stockStringTreeMap.keySet().forEach(System.out::println);

    }

}
