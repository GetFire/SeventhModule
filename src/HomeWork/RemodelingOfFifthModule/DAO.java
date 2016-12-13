package HomeWork.RemodelingOfFifthModule;

import java.util.*;

public interface DAO {
    void save(Room room);
    boolean delete(Room room);
    void update(Room room);
    Room findById(long id);
    List<Room> getAll();
}