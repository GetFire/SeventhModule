package HomeWork.RemodelingOfFifthModule;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        System.out.println("----------------Запрашиваем комнаты по параметрам-----------------");
        List<Room> param = controller.requstRooms(150, 1, "Лас-Вегас", "The Cosmopolitan");
        System.out.println(param);
        System.out.println();

        List<Room> param1 = controller.requstRooms(150, 2, "New York", "Hilton");
        System.out.println(param1);
        System.out.println();

        List<Room> param3 = controller.requstRooms(200, 1, "Дубай", "Atlantis The Palm");
        System.out.println(Arrays.asList(param3));
        System.out.println();


        System.out.println("------------СравнениеAPI--------------------");
        List<Room> sad = controller.check(new BookingComAPI(), new GoogleAPI());
        List<Room>sad1 = controller.check(new BookingComAPI(), new TripAdvisorAPI());
        List<Room> sad2 = controller.check(new TripAdvisorAPI(), new GoogleAPI());

        System.out.println(Arrays.asList(sad));
        System.out.println();

        System.out.println(Arrays.asList(sad1));
        System.out.println();

        System.out.println(Arrays.asList(sad2));
        System.out.println();
        System.out.println("---------------Работаем с ДАО-----------------------------------");

        List<Room> DB = controller.getDao().getDataBase();
        Date date = new Date();
        Room room = new Room(13321, 456, 4, date, "Киев", "Киев");
        Room room1 = new Room(13361, 455, 5, date, "Москва", "Киев");
        controller.getDao().save(room);
        controller.getDao().save(room1);
        System.out.println(Arrays.asList(DB));

        controller.getDao().delete(room);

        System.out.println(Arrays.asList(DB));

        controller.getDao().update(room1);
        controller.getDao().findById(13361);


//

    }
}

