package HomeWork;



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

        System.out.println("==============================Удаляем дубликаты==========================================================================");
        Utils.removeDuplicates(list);
        System.out.println("List without duplicates" + list);

        System.out.println("==============================Less 1500==========================================================================");
        Utils.removeLess(list,1500);
        System.out.println(list);


        System.out.println("==============================UAH/USD=========================================================================");
        List<Order> listUA = new ArrayList<>();
        List<Order> listUS = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            Currency uah= Currency.UAH;
            Currency usd= Currency.USD;
            if (list2.get(i).getCurrency().equals(uah)) {
                listUA.add(list2.get(i));
                list2.remove(i);
                i = 0;
            }
            if (list2.get(i).getCurrency().equals(usd)) {
                listUS.add(list2.get(i));
                list2.remove(i);
                i = 0;
            }
        }
        System.out.println("UA " + listUA);
        System.out.println("US " + listUS);
        System.out.println(list2);


        System.out.println("============================Разделяем на списки=====================================================================");
        Map<String, List<Order>> cityMap = new HashMap<>();
        for (int i = 0; i < list3.size(); i++) {
            String s =list3.get(i).getUser().getCity();
            if (!s.equals(cityMap.get(s))){
                cityMap.put(s,new ArrayList<Order>(Arrays.asList(list3.get(i))));
            }
            if (s.equals(cityMap.get(s))){
                cityMap.put(s,new ArrayList<Order>(Arrays.asList(list3.get(i))));
            }


        }

        System.out.println("-----------------------------------------------");
        for (Map.Entry<String, List<Order>> stringListEntry : cityMap.entrySet()) {
            System.out.println(stringListEntry);
        }

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
