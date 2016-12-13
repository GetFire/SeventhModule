package HomeWork;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Order> list = Utils.createOrders();
        List<Order> list2 = Utils.createOrders();
        List<Order> list3 = Utils.createOrders();

        System.out.println("List without any sort " + list);

        System.out.println("==============================================================");

        list.sort(Order.PRICE_COMPARE_DECREASE);
        System.out.println("Sort list by Price " + list);
        System.out.println();

        list.sort(Order.PRICE_COMPARE_INCREASE.thenComparing(Order.CITY_COPARE));
        System.out.println("Sort list3 by PriceANDCity " + list);
        System.out.println();

        list.sort(Order.ITEM_NAME_COMPARE.thenComparing(Order.SHOP_INDETIFICATOR_COMPARE).thenComparing(Order.CITY_COPARE));
        System.out.println("Sort by ItemANDShopANDCity " + list);


        System.out.println();
        System.out.println("============================== Удаляем дубликаты ==========================================================================");
        System.out.println();


        Utils.removeDuplicates(list);
        System.out.println("List without duplicates" + list);


        System.out.println();
        System.out.println("============================== Less 1500 ==========================================================================");
        System.out.println();

        Utils.removeLess(list, 1500);
        System.out.println(list);

        System.out.println();
        System.out.println("============================ Разделяем на списки =====================================================================");
        System.out.println();


        Map<Currency, List<Order>> curr = Utils.splitByCurrency(list2);
        for (Map.Entry<Currency, List<Order>> currencyListEntry : curr.entrySet()) {
            System.out.println(currencyListEntry);
        }

        System.out.println("-----------------------------------------------");
        Map<String, List<Order>> cityMap = Utils.splitByCity(list3);
        for (Map.Entry<String, List<Order>> stringListEntry : cityMap.entrySet()) {
            System.out.println(stringListEntry);
        }
        System.out.println();
        System.out.println("============================== Работаем с TreeSet =========================================================");
        System.out.println();


        List<Order> listWithDP = Utils.createOrdersWithDuplicates();
        NavigableSet<Order>set = new TreeSet<>();

        set.addAll(listWithDP);
        for (Order order : set) {
            System.out.println(order);
        }
        System.out.println();

        System.out.println(Utils.checkContains(set,"Petrov"));
        System.out.println();

        System.out.println("The Order with largest price is: "+set.last());
        set = Utils.deleteUSD(set);
        for (Order order : set) {
            System.out.println(order);
        }
        System.out.println();


        System.out.println();
        System.out.println("============================== Измеряем время =========================================================");
        System.out.println();


        System.out.println("Integer");
        Utils.timeMeasureInteger1000();
        Utils.timeMeasureInteger10000();

        System.out.println();
        System.out.println("String");
        Utils.timeMeasureString1000();
        Utils.timeMeasureString10000();


    }

}

