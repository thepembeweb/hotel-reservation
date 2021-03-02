package model;

public class Room implements IRoom{
    public String roomNumber ;
    public Double price;
    public RoomType roomType;

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Room\nroomNumber=%s\nprice=%s\nroomType=%s\n", roomNumber, price, roomType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Room))
            return false;

        Room otherRoom = (Room)o;

        boolean roomNumberEquals = (this.roomNumber == null && otherRoom.roomNumber == null)
                || (this.roomNumber != null && this.roomNumber.equals(otherRoom.roomNumber));
        boolean priceEquals = (this.price == null && otherRoom.price == null)
                || (this.price != null && this.price.equals(otherRoom.price));
        boolean roomTypeEquals = (this.roomType == null && otherRoom.roomType == null)
                || (this.roomType != null && this.roomType.equals(otherRoom.roomType));

        return roomNumberEquals && priceEquals && roomTypeEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (roomNumber != null) {
            result = 31 * result + roomNumber.hashCode();
        }
        if (price != null) {
            result = 31 * result + price.hashCode();
        }
        if (roomType != null) {
            result = 31 * result + roomType.hashCode();
        }
        return result;
    }

}
