package HomeWork;

import java.util.Comparator;
import java.util.Currency;

public class Order {
    long id;
    int price;
    Currency currency;
    String itemName;
    String shopIdentificator;
    User user;
    public static final Comparator<Order> PRICE_COMPARE=new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return o2.getPrice()-o1.getPrice();
        }
    };


//    @Override
//    public int compareTo(Object o) {
//        Order s = (Order) o;
//        return s.price - this.price;
//    }


    public Order(long id, int price, Currency currency, String itemName, String shopIdentificator, User user) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public void setShopIdentificator(String shopIdentificator) {
        this.shopIdentificator = shopIdentificator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return
                "price=" + price
                ;
    }

}

