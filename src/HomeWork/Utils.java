package HomeWork;

import java.util.*;

public class Utils {
    private Utils() {
    }
    public static Map<Currency,List<Order>> splitByCurrency(List<Order>list){
        Map<Currency,List<Order>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Currency curr = list.get(i).getCurrency();
            if (!map.containsKey(curr)){
                map.put(curr,new ArrayList<Order>(Arrays.asList(list.get(i))));
                continue;
            }
            if (map.containsKey(curr)){
                List<Order>tmp = map.get(curr);
                tmp.add(list.get(i));
                map.put(curr,tmp);
            }
        }
        return map;
    }

    public static Map<String,List<Order>> splitByCity(List<Order>list){
        Map<String,List<Order>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).getUser().getCity();
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<Order>(Arrays.asList(list.get(i))));
                continue;
            }
            if (map.containsKey(s)) {
                List<Order>tmp = map.get(s);
                tmp.add(list.get(i));
                map.put(s, tmp);
            }


        }
        return map;
    }

    public static List<Order> removeDuplicates(List<Order> list) {
        Set<Order> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static List<Order> removeLess(List<Order> list, int price) {
        for (int i = 0; i < list.size(); i++) {
            int pr = list.get(i).getPrice();
            if (pr < price) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public static List<Order> createOrders() {
        Currency curUAH = Currency.UAH;
        Currency curUSD = Currency.USD;

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

        List<Order> orders = new ArrayList<>();
        Order or1 = new Order(1001, 120, curUAH, "Сухарики FINN CRISP", "Розетка", us10);
        Order or2 = new Order(1002, 5000, curUSD, "Audi A8", "AudiUA", us3);
        Order or3 = new Order(1003, 200, curUSD, "Beats Audio 10Pro100", "Dr.Dree", us1);
        Order or4 = new Order(1004, 250, curUAH, "Самые дешевые наушники", "Розетка", us2);
        Order or5 = new Order(1005, 120, curUSD, "Aquarium Shark+", "AquaLIVE", us4);
        Order or6 = new Order(1006, 67, curUAH, "Хлеб Кулиничи", "Онлайн Супермаркет", us5);
        Order or7 = new Order(1007, 3500, curUAH, "Electrolux 5000", "Розетка", us9);
        Order or8 = new Order(1008, 150, curUAH, "Средства личной гигиены", "WoomanHealth", us8);
        Order or9 = new Order(1009, 300, curUAH, "Huggies Elite Soft", "ДеткиЮА", us6);
        Order or10 = new Order(1010, 30, curUAH, "Лоток яиц", "Онлайн Супермаркет", us7);


        Collections.addAll(orders, or1, or2, or3, or4, or5, or6, or7, or8, or9, or10);
        return orders;
    }

    public static void timeMeasureInteger1000() {
        List<Integer> list = new ArrayList<>();

        Date startList = new Date();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Date finishList = new Date();
        long addResultArray = finishList.getTime() - startList.getTime();


        Date start1Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 120);
        }
        Date finish1Array = new Date();
        long setResultArray = finish1Array.getTime() - start1Array.getTime();


        Date star2Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i);
        }
        Date finish2Array = new Date();
        long getResultArray = finish2Array.getTime() - star2Array.getTime();


        Date star3Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        Date finish3Array = new Date();
        long removeResultArray = finish3Array.getTime() - star3Array.getTime();

        System.out.println("Заполнение ArrayList заняло: " + addResultArray + " " + "Set ArrayList заняло: " + setResultArray + " " + "Get ArrayList заняло: " + getResultArray + " " + "Remove ArrayList заняло: " + removeResultArray);
//       ================================================================================================================================
        List<Integer> link = new LinkedList<>();

        Date startLink = new Date();
        for (int i = 0; i < 1000; i++) {
            link.add(i);
        }
        Date finishLink = new Date();
        long addResultLink = finishLink.getTime() - startLink.getTime();


        Date start1Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.set(i, 120);
        }
        Date finish1Link = new Date();
        long setResultLink = finish1Link.getTime() - start1Link.getTime();


        Date star2Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            int s = link.get(i);
        }
        Date finish2Link = new Date();
        long getResultLink = finish2Link.getTime() - star2Link.getTime();


        Date star3Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.remove(i);
        }
        Date finish3Link = new Date();
        long removeResultLink = finish3Link.getTime() - star3Link.getTime();
        System.out.println("Заполнение LinkedList заняло: " + addResultLink + " " + "Set LinkedList заняло: " + setResultLink + " " + "Get LinkedList заняло: " + getResultLink + " " + "Remove LinkedList заняло: " + removeResultLink);


    }

    public static void timeMeasureInteger10000() {
        List<Integer> list = new ArrayList<>();

        Date startList = new Date();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        Date finishList = new Date();
        long addResultArray = finishList.getTime() - startList.getTime();


        Date start1Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 120);
        }
        Date finish1Array = new Date();
        long setResultArray = finish1Array.getTime() - start1Array.getTime();


        Date star2Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i);
        }
        Date finish2Array = new Date();
        long getResultArray = finish2Array.getTime() - star2Array.getTime();


        Date star3Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        Date finish3Array = new Date();
        long removeResultArray = finish3Array.getTime() - star3Array.getTime();

        System.out.println("Заполнение ArrayList заняло: " + addResultArray + " " + "Set ArrayList заняло: " + setResultArray + " " + "Get ArrayList заняло: " + getResultArray + " " + "Remove ArrayList заняло: " + removeResultArray);
//       ================================================================================================================================
        List<Integer> link = new LinkedList<>();

        Date startLink = new Date();
        for (int i = 0; i < 10000; i++) {
            link.add(i);
        }
        Date finishLink = new Date();
        long addResultLink = finishLink.getTime() - startLink.getTime();


        Date start1Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.set(i, 120);
        }
        Date finish1Link = new Date();
        long setResultLink = finish1Link.getTime() - start1Link.getTime();


        Date star2Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            int s = link.get(i);
        }
        Date finish2Link = new Date();
        long getResultLink = finish2Link.getTime() - star2Link.getTime();


        Date star3Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.remove(i);
        }
        Date finish3Link = new Date();
        long removeResultLink = finish3Link.getTime() - star3Link.getTime();
        System.out.println("Заполнение LinkedList заняло: " + addResultLink + " " + "Set LinkedList заняло: " + setResultLink + " " + "Get LinkedList заняло: " + getResultLink + " " + "Remove LinkedList заняло: " + removeResultLink);


    }

    public static void timeMeasureString10000() {
        List<String> list = new ArrayList<>();

        Date startList = new Date();
        for (int i = 0; i < 10000; i++) {
            list.add("Test" + i);
        }
        Date finishList = new Date();
        long addResultArray = finishList.getTime() - startList.getTime();


        Date start1Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, "120");
        }
        Date finish1Array = new Date();
        long setResultArray = finish1Array.getTime() - start1Array.getTime();


        Date star2Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
        }
        Date finish2Array = new Date();
        long getResultArray = finish2Array.getTime() - star2Array.getTime();


        Date star3Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        Date finish3Array = new Date();
        long removeResultArray = finish3Array.getTime() - star3Array.getTime();

        System.out.println("Заполнение ArrayList заняло: " + addResultArray + " " + "Set ArrayList заняло: " + setResultArray + " " + "Get ArrayList заняло: " + getResultArray + " " + "Remove ArrayList заняло: " + removeResultArray);
//       ================================================================================================================================
        List<String> link = new LinkedList<>();

        Date startLink = new Date();
        for (int i = 0; i < 10000; i++) {
            link.add("Test" + i);
        }
        Date finishLink = new Date();
        long addResultLink = finishLink.getTime() - startLink.getTime();


        Date start1Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.set(i, "120");
        }
        Date finish1Link = new Date();
        long setResultLink = finish1Link.getTime() - start1Link.getTime();


        Date star2Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            String s = link.get(i);
        }
        Date finish2Link = new Date();
        long getResultLink = finish2Link.getTime() - star2Link.getTime();


        Date star3Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.remove(i);
        }
        Date finish3Link = new Date();
        long removeResultLink = finish3Link.getTime() - star3Link.getTime();
        System.out.println("Заполнение LinkedList заняло: " + addResultLink + " " + "Set LinkedList заняло: " + setResultLink + " " + "Get LinkedList заняло: " + getResultLink + " " + "Remove LinkedList заняло: " + removeResultLink);


    }

    public static void timeMeasureString1000() {
        List<String> list = new ArrayList<>();

        Date startList = new Date();
        for (int i = 0; i < 1000; i++) {
            list.add("Test" + i);
        }
        Date finishList = new Date();
        long addResultArray = finishList.getTime() - startList.getTime();


        Date start1Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, "120");
        }
        Date finish1Array = new Date();
        long setResultArray = finish1Array.getTime() - start1Array.getTime();


        Date star2Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
        }
        Date finish2Array = new Date();
        long getResultArray = finish2Array.getTime() - star2Array.getTime();


        Date star3Array = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        Date finish3Array = new Date();
        long removeResultArray = finish3Array.getTime() - star3Array.getTime();

        System.out.println("Заполнение ArrayList заняло: " + addResultArray + " " + "Set ArrayList заняло: " + setResultArray + " " + "Get ArrayList заняло: " + getResultArray + " " + "Remove ArrayList заняло: " + removeResultArray);
//       ================================================================================================================================
        List<String> link = new LinkedList<>();

        Date startLink = new Date();
        for (int i = 0; i < 1000; i++) {
            link.add("Test" + i);
        }
        Date finishLink = new Date();
        long addResultLink = finishLink.getTime() - startLink.getTime();


        Date start1Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.set(i, "120");
        }
        Date finish1Link = new Date();
        long setResultLink = finish1Link.getTime() - start1Link.getTime();


        Date star2Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            String s = link.get(i);
        }
        Date finish2Link = new Date();
        long getResultLink = finish2Link.getTime() - star2Link.getTime();


        Date star3Link = new Date();
        for (int i = 0; i < link.size(); i++) {
            link.remove(i);
        }
        Date finish3Link = new Date();
        long removeResultLink = finish3Link.getTime() - star3Link.getTime();
        System.out.println("Заполнение LinkedList заняло: " + addResultLink + " " + "Set LinkedList заняло: " + setResultLink + " " + "Get LinkedList заняло: " + getResultLink + " " + "Remove LinkedList заняло: " + removeResultLink);


    }


}
