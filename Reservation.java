import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private Name guestName;
    private Date checkInDate;
    private Date checkOutDate; // these Date classes are for view hotel
    private Room room;
    private ArrayList<Transaction> transaction = new ArrayList<Transaction>();

    public Reservation(Name guestName, Date checkInDate, Date checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }

    /**
     * getTransactionTotal is a method that returns a BigDecimal value with all the
     * transactions
     * 
     * @return returns the total cost of all transactions in a reservation
     */
    public BigDecimal getTransactionTotal() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (int i = 0; i < transaction.size(); ++i)
            total = total.add(transaction.get(i).getAmount());
        return total;
    }

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