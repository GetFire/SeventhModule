package HomeWork.RemodelingOfFifthModule;

import java.util.*;

public interface DAO {
    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);
    List<Room> getAll();
}