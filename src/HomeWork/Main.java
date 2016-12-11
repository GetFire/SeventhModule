package HomeWork;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Currency curUAH = Currency.UAH;
        Currency curUSD = Currency.USD;
        Currency curEUR = Currency.EUR;

        User us1 = new User(111, "Мария", "Польщенко", "Харьков", 1500);
        User us2 = new User(222, "Андрей", "Морозов", "Дублин", 2000);
        User us3 = new User(333, "Александр", "Азацкий", "Киев", 15000);
        User us4 = new User(444, "Аня", "Онищенко", "Москва", 1000);
        User us5 = new User(555, "Ярослав", "Мащенко", "Днипро", 500);
        User us6 = new User(666, "Алина", "Жилина", "Одесса", 2250);
        User us7 = new User(777, "Кирилл", "Подзегун", "Харьков", 250);
        User us8 = new User(888, "Алёна", "Шляхова", "Франкфурт", 3200);
        User us9 = new User(999, "Татьяна", "Беседовская", "Львов", 4000);
        User us10 = new User(1010, "Лера", "Серветник", "Богодухов", 120);

        Order or1 = new Order(1001, 120, curUAH, "Сухарики FINN CRISP", "Розетка", us10);
        Order or2 = new Order(1002, 5000, curEUR, "Audi A8", "AudiUA", us3);
        Order or3 = new Order(1003, 200, curUSD, "Beats Audio 10Pro100", "Dr.Dree", us1);
        Order or4 = new Order(1004, 250, curUAH, "Самые дешевые наушники", "Розетка", us2);
        Order or5 = new Order(1005, 120, curUSD, "Aquarium Shark+", "AquaLIVE", us4);
        Order or6 = new Order(1006, 67, curUAH, "Хлеб Кулиничи", "Онлайн Супермаркет", us5);
        Order or7 = new Order(1007, 3500, curUAH, "Electrolux 5000", "Розетка", us9);
        Order or8 = new Order(1008, 150, curUAH, "Средства личной гигиены", "WoomanHealth", us8);
        Order or9 = new Order(1009, 300, curUAH, "Huggies Elite Soft", "ДеткиЮА", us6);
        Order or10 = new Order(1010, 30, curUAH, "Лоток яиц", "Онлайн Супермаркет", us7);

        List<Order> list = new ArrayList<Order>();
        List<Order> list2 = new ArrayList<Order>();
        List<Order> list3 = new ArrayList<Order>();

        Collections.addAll(list, or1, or2, or3, or4, or5, or6, or7, or8, or9, or10);
        Collections.addAll(list2, or1, or2, or3, or4, or5, or6, or7, or8, or9, or10);
        Collections.addAll(list3, or1, or2, or3, or4, or5, or6, or7, or8, or9, or10);

        System.out.println("Printing list without any sort " + list);

        System.out.println("==============================================================");

        list.sort(Order.PRICE_COMPARE);
        System.out.println("Sort list by Price " + list);
        System.out.println();

        list.sort(Order.CITY_COPARE.thenComparing(Order.PRICE_COMPARE));
        System.out.println("Sort list by CityANDPrice " + list);
        System.out.println();

        list.sort(Order.PRICE_COMPARE.thenComparing(Order.CITY_COPARE));
        System.out.println("Sort list3 by PriceANDCity " + list);
        System.out.println();

        list.sort(Order.ITEM_NAME_COMPARE.thenComparing(Order.SHOP_INDETIFICATOR_COMPARE).thenComparing(Order.CITY_COPARE));
        System.out.println("Sort by ItemANDShopANDCity " + list);
        System.out.println();

//        ==============================Удаляем дубликаты==========================================================================
        Set<Order> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        System.out.println("Set without duplicates" + list);

        System.out.println("==============================Less 1500==========================================================================");
        for (int i = 0; i < list.size(); i++) {
            int price = list.get(i).getPrice();
            if (price < 1500) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);


        System.out.println("==============================UAH/USD=========================================================================");
        List<Order> listUA = new ArrayList<>();
        List<Order> listUS = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getCurrency().equals(curUAH)) {
                listUA.add(list2.get(i));
                list2.remove(i);
                i = 0;
            }
            if (list2.get(i).getCurrency().equals(curUSD)) {
                listUS.add(list2.get(i));
                list2.remove(i);
                i = 0;
            }
        }
        System.out.println("UA " + listUA);
        System.out.println("US " + listUS);
        System.out.println(list2);


        System.out.println("============================Разделяем на списки=====================================================================");
        Map<String, Order> cityMap = new HashMap<>();
        for (int i = 0; i < list3.size(); i++) {
            String s = list3.get(i).getUser().getCity();
            for (int j = 0; j < list3.size(); j++) {
                if (!s.equals(list3.get(j).getUser().getCity())) {

                    cityMap.put(s, list3.get(i));
                }
            }
        }
        Iterator<Map.Entry<String, Order>> iterator = cityMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Order> pair = iterator.next();
            String key = pair.getKey();
            Order val = pair.getValue();
            System.out.println(key+" : "+val);
        }


    }


}
