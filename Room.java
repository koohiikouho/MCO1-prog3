import java.math.BigDecimal;

public class Room {
    private Integer roomNumber;
    private BigDecimal basePrice;
    private Boolean isReserved;

    public Room(Character letter, Integer number){
        this.roomNumber = number;
        this.isReserved = false;
        basePrice = BigDecimal.valueOf(1299.00);
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
