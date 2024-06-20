import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class Hotel {
    private String name;
    ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private BigDecimal earningsEstimate;

    /**
     * constructor for the Hotel class, includes automated or manual room number adding
     */
    public Hotel(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter hotel name: ");
        this.name = scan.nextLine();


        System.out.print("\nHow many floors?: ");
        Integer floors = Integer.parseInt(scan.nextLine());
        System.out.print("\nHow many rooms per floor?: ");
        Integer roomPFloor = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < floors; ++i){
            for(int j = 0; j < roomPFloor; ++j)
                rooms.add( new Room(i + 1, j + 1) );
        }

        

        scan.close();
    }
    /**
     * gets hotel name
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
     * @return returns room arraylist
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    /**
     * Sets a room in array list format
     * @param rooms sets a room
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    /**
     * Gets all the resevations
     * @return returns reservations in array list format
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets reservations
     * @param reservations reservation setter in array list format
     */
    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    /**
     * gets the earnings estimate
     * @return returns earnings estimate in BigDecimal format
     */
    public BigDecimal getEarningsEstimate() {
        return earningsEstimate;
    }
    /**
     * sets the earnings estimate
     * @param earningsEstimate ths is in BigDecimal format
     */
    public void setEarningsEstimate(BigDecimal earningsEstimate) {
        this.earningsEstimate = earningsEstimate;
    }

    
}
