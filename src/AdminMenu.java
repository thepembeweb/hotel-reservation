import api.AdminResource;
import model.Room;
import model.RoomType;
import java.util.Scanner;

public class AdminMenu {
    public static Scanner scanner;
    private static AdminResource adminResource;

    public static void startAdmin() {
        scanner = new Scanner(System.in);
        try {
            boolean exit = false;
            while (!exit) {
                String option = showAdminMenu();
                switch (option) {
                    case "1":
                        System.out.println(adminResource.getAllCustomers());
                        break;
                    case "2":
                        System.out.println(adminResource.getAllRooms());
                        break;
                    case "3":
                        adminResource.displayAllReservations();
                        break;
                    case "4":
                        addRoom();
                        break;
                    case "5":
                        exit = true;
                        break;
                    default:
                        showAdminMenu();
                        break;
                }
            }
            String[] arguments = new String[] {""};
            MainMenu.main(arguments);
        } catch(Exception ex){
            ex.getLocalizedMessage();
        } finally{
            scanner.close();
        }
    }

    private static void addRoom() {
        Room room = new Room();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number");
        room.roomNumber = scanner.nextLine().trim();
        System.out.println("Enter price per night");
        room.price = scanner.nextDouble();
        System.out.println("Enter room type: 1 for single,  2 for double bed");
        int type = scanner.nextInt();
        if (type == 1) {
            room.roomType = RoomType.SINGLE;
        } else {
            room.roomType = RoomType.DOUBLE;
        }
        adminResource.addRoom(room);
    }

    private static String showAdminMenu() {
        System.out.println("__________________________________________________");
        System.out.println("   ADMIN MENU");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("__________________________________________________");
        System.out.println("Enter menu:");
        return scanner.nextLine();
    }

    public static void setAdminResource(AdminResource adminResource) {
        AdminMenu.adminResource = adminResource;
    }
}
