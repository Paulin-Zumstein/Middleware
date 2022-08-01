package cz.cvut.fel.omo.cv10;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class TradeHistory {

    public List<Transaction> transactions;

    public TradeHistory(List<Transaction> transctions) {
        this.transactions = transctions;
    }

    public List<Transaction> findAllTransactionsIn2011AndSortByValueAsc(){
        List<Transaction> newList = transactions.stream()
                .filter(x->x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        return newList;
    }

    public List<String> getUniqueCitiesSortedAsc(){
        List<String> list = new ArrayList<String>();

        for (Transaction transaction : transactions){
            if (list.contains(transaction.getTrader().getCity()) == false)
                list.add(transaction.getTrader().getCity());
        }
        Collections.sort(list);

        return list;
    }

    /*
    * String shall start with "Traders:" and use space as separator. E.g.: "Traders: Bob George"
    *
     */
    public String getSingleStringFromUniqueTradersNamesSortByNameAsc(){
        List<String> list = new ArrayList<>();

        for(Transaction transaction : transactions){
            if (list.contains(transaction.getTrader().getName()) == false)
                list.add(transaction.getTrader().getName());
        }
        Collections.sort(list);

        return list.stream().reduce("Traders:", (string, element) -> string + " " + element);
    }

    public boolean isSomeTraderFromCity(String cityName){
        return transactions.stream().anyMatch(t -> t.getTrader().getCity().equals(cityName));
    }

    public Optional<Transaction> findSmallestTransactionUsingReduce(){
        Optional<Transaction> smallestTransaction = null;
        //Implement body here
        return smallestTransaction;
    }

    public Map<String, List<Trader>> getTradersByTown(){
        Map<String, List<Trader>> tradersByTown = new HashMap<String, List<Trader>>();
        //Implement body here
        return tradersByTown;
    }

    public Map<String, Long> getTradersCountsByTown(){
        Map<String, Long> tradersByTown = new HashMap<String, Long>();
        //Implement body here
        return tradersByTown;
    }

    public Map<Boolean, List<Transaction>> partitionTransactionsByTraderIsVegetarian(){
        Map<Boolean, List<Transaction>> transactionsBy = new HashMap<Boolean, List<Transaction>>();
        return transactionsBy;
    }
}
