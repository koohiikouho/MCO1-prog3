import java.util.*;

public class HRSYS {

    private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    public static void main(String args[]) {
        HRSYS hotelsys = new HRSYS();
        ViewHotel hotelView = new ViewHotel();
        ManageHotel manHotel = new ManageHotel();
        SimulateBooking daSims = new SimulateBooking();

        Integer choice = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter option:");
            System.out.println("[1] Create Hotel\n[2] View Hotel\n[3] Manage Hotel\n[4] Simulate Booking\n[5] Exit");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    hotelsys.createHotel(scan);
                    break;
                case 2:
                    if (hotelsys.hotels.size() == 0)
                        System.err.println("No hotels initialized!");
                    else {
                        hotelView.viewHotel(scan, hotelsys.hotels);
                    }
                    break;
                case 3:
                    manHotel.optionSel(hotelsys.hotels);
                    break;
                case 4:
                    daSims.simBooking(scan, hotelsys.hotels);
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Input out of bounds");
                    break;
            }
        } while (choice != 5);
        // System.out.println( hotelsys.hotels.get(0).rooms.get(0).getRoomFloor() + "-"
        // + hotelsys.hotels.get(0).rooms.get(0).getRoomNumber());

    }

    /*
     * This method creates and adds a hotel to the hotels array list
     * 
     */
    public void createHotel(Scanner scan) { // calls the hotel constructor to add a hotel to the array list
        hotels.add(new Hotel(scan));
    }

}