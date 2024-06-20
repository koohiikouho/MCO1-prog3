import java.math.BigDecimal;
import java.util.Scanner;

public class Room {
    private Integer roomFloor;
    private Integer roomNumber;
    private BigDecimal basePrice;
    private Boolean isReserved;

    public Room(){
        Scanner scan = new Scanner(System.in);

        // System.out.println("Do you want to enter rooms manually?");
        // System.out.print("Enter room floor: ");
        // this.roomFloor = Integer.parseInt(scan.nextLine());
        // System.out.print("Enter room number: ");
        // this.roomNumber = Integer.parseInt(scan.nextLine());

        scan.close();

        basePrice = BigDecimal.valueOf(1299.00);
        this.isReserved = false;
    }

    public Room(Integer floor, Integer number){
        this.roomFloor = number;
        this.roomNumber = number;
        this.isReserved = false;
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

    public Boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(Boolean isReserved) {
        this.isReserved = isReserved;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }



}
