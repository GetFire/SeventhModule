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
    public Room save(Room room) {

        for (int i = 0; i < dataBase.size(); i++) {

            if (dataBase.get(i) == null) {
                dataBase.add(i,room);
                break;

            }

        }
        System.out.println(room.getHotelName() + " был сохранен в Базе Данных");
        return null;
    }

    @Override
    public boolean delete(Room room) {
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).equals(room)) {
                dataBase.remove(i);
                System.out.println(room.getHotelName() + " был удален из Базы Данных");
                break;
            }

        }

        return false;
    }

    @Override
    public Room update(Room room) {

        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i) == null) {
                continue;
            } else if (dataBase.get(i).getId() == room.getId()) {
                dataBase.add(i,room);
                System.out.println(room.getHotelName() + " обновлено");
                break;
            }

        }
        return null;
    }

    @Override
    public Room findById(long id) {

        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i)== null) {
                continue;
            } else if (dataBase.get(i).getId() == id) {
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
