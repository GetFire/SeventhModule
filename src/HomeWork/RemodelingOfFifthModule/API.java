package HomeWork.RemodelingOfFifthModule;

import java.util.*;

public interface API {
    List<Room>findRooms (int price, int persons, String city, String hotel);
    List<Room> getAll();
}
