package HomeWork.RemodelingOfFifthModule;
import java.util.*;

public class DAOImpl implements DAO {
    private List<Room> dataBase = new ArrayList<>();



    public void setDataBase(Room roomToData) {
        this.save(roomToData);
    }

    public List<Room> getDataBase() {
        return this.dataBase;
    }

    @Override
    public void save(Room room) {
        dataBase.add(room);
        System.out.println(room.getHotelName() + " был сохранен в Базе Данных");

    }

    @Override
    public boolean delete(Room room) {
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).equals(room)) {
                dataBase.remove(i);
                System.out.println(room.getHotelName() + " был удален из Базы Данных");
                return true;
            }

        }

        return false;
    }

    @Override
    public void update(Room room) {

        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).getId() == room.getId()) {
                dataBase.set(i,room);
                System.out.println(room.getHotelName() + " обновлено");
                break;
            }

        }

    }

    @Override
    public Room findById(long id) {

        for (int i = 0; i < dataBase.size(); i++) {
           if (dataBase.get(i).getId() == id) {
                System.out.println("Результат поиска: " + dataBase.get(i).getHotelName());

                return dataBase.get(i);
            }
        }

        System.out.println("Поиск не дал результатов");

        return null;
    }


    @Override
    public List<Room> getAll() {

        return dataBase;
    }
}
