package HomeWork.RemodelingOfFifthModule;
import java.util.*;

public class TripAdvisorAPI implements API {
    public List<Room>rooms;

    public TripAdvisorAPI() {
        Date date = new Date();
        rooms= new ArrayList<>();
        rooms.add(new Room(126, 150, 2, date, "Hilton", "New York"));
        rooms.add(new Room(963852741, 150, 1, date, "The Cosmopolitan", "Лас-Вегас"));
        rooms.add(new Room(100241, 200, 1, date, "Drury Plaza ", "Сан-Антонио"));
        rooms.add(new Room(22543, 150, 2, date, "Universal's Cabana Bay Beach Resort", "Орландо"));
        rooms.add(new Room(365552, 250, 2, date, "Burj Al Arab", "Дубай"));

    }

    @Override
    public List<Room> findRooms(int price, int persons, String city, String hotel) {
        List<Room> trip = new ArrayList<Room>();
        Date date=new Date();
        Room compareRoom= new Room(236544,price,persons,date,hotel,city);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).equals(compareRoom)){
                trip.add(rooms.get(i));
            }
        }
        return trip;
    }

    @Override
    public List<Room> getAll() {
        return this.rooms;
    }
}
