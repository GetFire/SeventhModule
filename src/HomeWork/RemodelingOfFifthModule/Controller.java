package HomeWork.RemodelingOfFifthModule;


import java.util.*;

public class Controller  {
    private API[] apis = {new BookingComAPI(), new TripAdvisorAPI(), new GoogleAPI()};
    private DAOImpl dao = new DAOImpl();




    public List<Room> requstRooms(int price, int persons, String city, String hotel) {
        List<Room> DB = new ArrayList<>();

        DB.addAll(apis[0].findRooms(price, persons, city, hotel));
        DB.addAll(apis[1].findRooms(price, persons, city, hotel));
        DB.addAll(apis[2].findRooms(price, persons, city, hotel));
        return DB;
    }

    public List<Room> check(API api1, API api2) {
        int count = 0;
        List<Room> dataBase = new ArrayList<>();
        List<Room> same1 = api1.getAll();
        List<Room> same2 = api2.getAll();
        for (int i = 0; i < same1.size(); i++) {
            for (int j = 0; j < same2.size(); j++) {
                if (same1.get(i).equals(same2.get(j))) {
                    dataBase.add(i,same1.get(i));
                }
            }
        }
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i) == null)
                count++;

        }

        if (count >= 5) {
            System.out.println("Нет одинаковых комнат");
            List<Room> zeroRooms = new ArrayList<>();
            return zeroRooms;
        } else
            return dataBase;

    }

    public DAOImpl getDao() {
        return this.dao;
    }

    public void setDao(DAOImpl dao) {
        this.dao = dao;
    }

    public API[] getApis() {
        return this.apis;
    }
}
