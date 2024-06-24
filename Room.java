import java.math.BigDecimal;
import java.util.Scanner;
import java.util.*;

public class Room {
    private Integer roomFloor;
    private Integer roomNumber;
    private BigDecimal basePrice;
    // private Boolean isReserved;
    private Date checkInDate;
    private Date checkOutDate;

    /**
     * Room constructor used for manually inputting a room
     */
    public Room() {
        Scanner scan = new Scanner(System.in);

        // System.out.println("Do you want to enter rooms manually?");
        // System.out.print("Enter room floor: ");
        // this.roomFloor = Integer.parseInt(scan.nextLine());
        // System.out.print("Enter room number: ");
        // this.roomNumber = Integer.parseInt(scan.nextLine());

        scan.close();

        basePrice = BigDecimal.valueOf(1299.00);
        // this.isReserved = false;
    }

    /**
     * Room constructor with floor and number, used for automated room creation
     * 
     * @param floor  floor of a room
     * @param number number of a room within a floor
     */
    public Room(Integer floor, Integer number) {
        this.roomFloor = floor;
        this.roomNumber = number;
        // this.isReserved = false;
        basePrice = BigDecimal.valueOf(1299.00);
    }

    public Integer getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Integer roomFloor) {
        this.roomFloor = roomFloor;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    // public Boolean getIsReserved() {
    // return isReserved;
    // }

    // public void setIsReserved(Boolean isReserved) {
    // this.isReserved = isReserved;
    // }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

}
