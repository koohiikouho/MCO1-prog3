import java.util.ArrayList;
import java.util.Date;

public class Reservation{
    private Name guestName;
    private Date checkInDate;
    private Date checkOutDate;
    private Room room;
    private ArrayList<Transaction> transaction = new ArrayList<Transaction>();

    public Name getGuestName() {
        return guestName;
    }
    public void setGuestName(Name guestName) {
        this.guestName = guestName;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }
    public void setTransaction(ArrayList<Transaction> transaction) {
        this.transaction = transaction;
    }
    
    
}