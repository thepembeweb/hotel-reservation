package api;
import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;
import java.util.List;

public class AdminResource {
    private static final CustomerService customerService = new CustomerService();
    private static final ReservationService reservationService = new ReservationService();

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
