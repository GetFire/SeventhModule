package HomeWork.RemodelingOfFifthModule;
import java.util.*;
import java.util.Date;

public class BookingComAPI implements API {
    public List<Room> rooms;


    public BookingComAPI() {
        Date date = new Date();
        rooms = new ArrayList<Room>();
        rooms.add(new Room(963852741, 150, 1, date, "The Cosmopolitan", "Лас-Вегас"));
        rooms.add(new Room(365552, 250, 2, date, "Burj Al Arab", "Дубай"));
        rooms.add(new Room(36012, 150, 2, date, "KharkivPalace", "Kharkiv"));
        rooms.add(new Room(126, 150, 2, date, "Hilton", "New York"));
        rooms.add(new Room(22543, 150, 2, date, "Universal's Cabana Bay Beach Resort", "Орландо"));

    }

    @Override
    public List<Room> findRooms(int price, int persons, String city, String hotel) {
        List<Room> booking = new ArrayList<Room>();
        Date date=new Date();
        Room compareRoom= new Room(236544,price,persons,date,hotel,city);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).equals(compareRoom)){
                booking.add(rooms.get(i));
            }
        }
        return booking;
    }

    @Override
    public List<Room> getAll() {
        return this.rooms;
    }
}
