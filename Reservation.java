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

    /**
     * gets guest name
     * 
     * @return Name
     */
    public Name getGuestName() {
        return guestName;
    }

    /**
     * sets guest name
     * 
     * @param guestName guest name to set to
     */
    public void setGuestName(Name guestName) {
        this.guestName = guestName;
    }

    /**
     * gets check in date
     * 
     * @return returns check in date as Date
     */
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * sets check in date
     * 
     * @param checkInDate date to set check in to
     */
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * gets check out date
     * 
     * @return Date returns check out date
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * sets check out date
     * 
     * @param checkOutDate check out date to set to
     */
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * gets room
     * 
     * @return gets room related to reservation
     */
    public Room getRoom() {
        return room;
    }

    /**
     * sets room
     * 
     * @param room room to set to
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return ArrayList<Transaction>
     */
    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    /**
     * sets transaction array list
     * 
     * @param transaction Transaction class but in an array list
     */
    public void setTransaction(ArrayList<Transaction> transaction) {
        this.transaction = transaction;
    }

}