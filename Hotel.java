import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * the Hotel class contains the name of the hotel, all of the rooms inside it,
 * reservations that are related to the hotel and an earningEstimate in
 * BigDecimal that contains how much the hotel earns from all the reservations
 */
public class Hotel {
    private String name;
    ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private BigDecimal earningsEstimate;

    /**
     * constructor for the Hotel class, includes automated or manual room number
     * adding
     * 
     * @param scan scanner variable
     */
    public Hotel(Scanner scan) {

        // variable declarations
        Integer roomPFloor = 0;
        Integer floors = 0;
        Integer count = 0;

        System.out.print("Enter hotel name: ");
        this.name = scan.nextLine();
        // do while loop will run until number of rooms are below 50
        do {
            // if(select != y || select != n){
            if (count != 0) {
                System.out.println("Only 50 rooms are allowed in the system!");
            }
            System.out.print("\nHow many floors?: ");
            do {
                floors = Integer.parseInt(scan.nextLine());
            } while (floors <= -1);
            do {
                System.out.print("\nHow many rooms per floor?: ");
                roomPFloor = Integer.parseInt(scan.nextLine());
            } while (roomPFloor <= -1);
            count++;
        } while (roomPFloor * floors > 50);

        for (int i = 0; i < floors.intValue(); ++i) {
            for (int j = 0; j < roomPFloor.intValue(); ++j) {
                rooms.add(new Room((i + 1), (j + 1)));
            }
        }

    }

    /**
     * returnIndex is a method that returns the index of a room and a floor in an
     * array list, used for transaction to room referencing
     * 
     * @param roomFloor  roomFloor key
     * @param roomNumber roomNumber key
     * @return returns index of the room and floor
     */
    public Integer returnIndex(Integer roomFloor, Integer roomNumber) {
        Integer i, index = 0;
        try {
            for (i = 0; i < getRooms().size(); ++i) {
                if (getRooms().get(i).getRoomFloor() == roomFloor && getRooms().get(i).getRoomNumber() == roomNumber)
                    index = i;
            }

        } catch (Exception e) {
            System.err.println("Error, index not found!");
            index = -1;
        }
        return index;
    }

    /**
     * generateEarnings generates the earnings of a hotel by looking through every
     * transaction the hotel has made
     */
    private void generateEarnings() {
        this.earningsEstimate = BigDecimal.valueOf(0);
        for (int i = 0; i < reservations.size(); ++i) {
            for (int j = 0; j < reservations.get(i).getTransaction().size(); ++j)
                earningsEstimate = earningsEstimate.add(reservations.get(i).getTransaction().get(j).getAmount());
        }

    }

    /**
     * gets hotel name
     * 
     * @return returns the name of the hotel
     */
    public String getName() {
        return name;
    }

    /**
     * sets hotel name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns all the rooms in arraylist format
     * 
     * @return returns room arraylist
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets a room in array list format
     * 
     * @param rooms sets a room
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Gets all the resevations
     * 
     * @return returns reservations in array list format
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets reservations
     * 
     * @param reservations reservation setter in array list format
     */
    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * gets the earnings estimate
     * 
     * @return returns earnings estimate in BigDecimal format
     */
    public BigDecimal getEarningsEstimate() {
        generateEarnings();
        return earningsEstimate;
    }

    /**
     * sets the earnings estimate
     * 
     * @param earningsEstimate ths is in BigDecimal format
     */
    public void setEarningsEstimate(BigDecimal earningsEstimate) {
        this.earningsEstimate = earningsEstimate;
    }

    /**
     * printRoom is a function that gets an index and prints the roomfloor and room
     * number of that room in this format
     * [index- 1] roomfloor-roomnumber
     * 
     * @param index index of the room to print
     */
    public void printRoom(int index) {
        try {
            System.out.println("[" + (index + 1) + "]" + rooms.get(index).getRoomFloor() + "-"
                    + rooms.get(index).getRoomNumber());

        } catch (Exception e) {
            System.out.println("Invalid index!!");
        }

    }
}
