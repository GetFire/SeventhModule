package HomeWork.RemodelingOfFifthModule;

import java.util.*;

public class GoogleAPI implements API {
    public List<Room> rooms;


    public GoogleAPI() {
        Date date = new Date();
        rooms = new ArrayList<>();
        rooms.add(new Room(2263647, 200, 1, date, "Atlantis The Palm", "Дубай"));
        rooms.add(new Room(365552, 250, 2, date, "Burj Al Arab", "Дубай"));
        rooms.add(new Room(963852741, 150, 1, date, "The Cosmopolitan", "Лас-Вегас"));
        rooms.add(new Room(22543, 150, 2, date, "Universal's Cabana Bay Beach Resort", "Орландо"));
        rooms.add(new Room(11110121, 150, 3, date, "Resorts World", "Сентоза, Сингапур"));

    }

    @Override
    public List<Room> findRooms(int price, int persons, String city, String hotel) {
        List<Room> google = new ArrayList<Room>();
        Date data1 = new Date();
        Room sravnenueKomnat = new Room(236544, price, persons, data1, hotel, city);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).equals(sravnenueKomnat)) {
                google.add(rooms.get(i));
            }
        }
        return google;
    }

    @Override
    public List<Room> getAll() {
        return this.rooms;
    }

}
