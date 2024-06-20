import java.math.BigDecimal;

public class Room {
    final Integer roomNumber;
    private BigDecimal basePrice;

    public Room(Character letter, Integer number){
        this.roomNumber = number;
        basePrice = BigDecimal.valueOf(1299.00);
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
