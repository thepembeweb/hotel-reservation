package api;
import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResource = null;

    private AdminResource() {
    }

    public static AdminResource getInstance() {
        if (null == adminResource) {
            adminResource = new AdminResource();
        }
        return adminResource;
    }

    CustomerService customerService = CustomerService.getInstance();;
    ReservationService reservationService = ReservationService.getInstance();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(Room rooms) {
        reservationService.addRoom(rooms);
    }

    public List<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        reservationService.printAllReservations();
    }

}
