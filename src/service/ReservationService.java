package service;
import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {
    private static final ArrayList<IRoom> rooms = new ArrayList<>();
    private static final ArrayList<Reservation> reservations = new ArrayList<>();

    public void addRoom(IRoom room) {
        rooms.add(room);
    }

    public IRoom getARoom(String roomId) {
        for (IRoom room : rooms) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public List<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> availableRooms = new ArrayList<>();
        try {
            List<IRoom> reservedRooms = getReservedRooms(checkInDate, checkOutDate);
            for (IRoom room : rooms) {
                if(!reservedRooms.contains(room)){
                    availableRooms.add(room);
                }
            }
        } catch (Exception e){
            if (availableRooms.isEmpty()) return null;
        }
        return availableRooms;
    }

    public List<IRoom> getReservedRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> reservedRooms = new ArrayList<>();
        try {
            for (Reservation reservation : reservations) {
                if (reservation.getCheckInDate().getTime() <= checkInDate.getTime() &&
                        reservation.getCheckOutDate().getTime() >= checkOutDate.getTime()) {
                    reservedRooms.add(reservation.getRoom());
                }
            }
        } catch (Exception e){
            if (reservedRooms.isEmpty()) return null;
        }
        return reservedRooms;
    }

    public List<Reservation> getCustomerReservation(Customer customer) {
        List<Reservation> reservationsAccordingToCustomer = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                reservationsAccordingToCustomer.add(reservation);
            }
        }
        return reservationsAccordingToCustomer;
    }

    public void printAllReservations() {
        System.out.println(reservations);
    }

    public List<Reservation> getCustomerReservations(String customerEmail) {
        List<Reservation> reservationsAccordingToCustomerEmail = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getEmail().equals(customerEmail)) {
                reservationsAccordingToCustomerEmail.add(reservation);
            }
        }
        return reservationsAccordingToCustomerEmail;
    }

    public List<IRoom> getAllRooms() {
        return rooms;
    }
}
