import java.util.*;

/**
 * ViewHotel is a method class to view a Hotel's information
 */
public class ViewHotel {

    /**
     * view Hotel is the only public and kinda the main method of view hotel, it
     * contains methods to view the high and low level information of a hotel
     * 
     * @param scan   imports scanner
     * @param hotels imports hotel arraylist
     */
    public void viewHotel(Scanner scan, ArrayList<Hotel> hotels) {

        Integer hotelNumber = 0;

        int i = 0;
        try {
            System.out.println("Pick hotel to view: ");
            for (i = 0; i < hotels.size(); ++i) {
                System.out.println("[" + (i + 1) + "] " + hotels.get(i).getName() + "\n");
            }
            System.out.println("Enter hotel number here: ");
            hotelNumber = Integer.parseInt(scan.nextLine()) - 1;
            selInfo(scan, hotels, hotelNumber);
        } catch (Exception e) {
            System.err.println("Hotel number does not exist, try again");
            viewHotel(scan, hotels);
        }

    }

    /**
     * selInfo lets the user choose what information they want to know about a hotel
     * 
     * @param scan        imports scanner
     * @param hotels      imports hotel arraylist to get info from
     * @param hotelNumber hotel's index
     */
    private void selInfo(Scanner scan, ArrayList<Hotel> hotels, Integer hotelNumber) {
        Integer highLow = 0;
        try {
            System.out.println("Do you want to view " + hotels.get(hotelNumber).getName() + "'s");
            System.out.println("[1] High level Information or;\n[2] Low level Information");
            highLow = Integer.parseInt(scan.nextLine());

            if (highLow == 1) {
                System.out.println("Hotel name: " + hotels.get(hotelNumber).getName());
                System.out.println(("No. of rooms in hotel:  " + hotels.get(hotelNumber).rooms.size()));
                System.out.println("Estimated earnings: " + hotels.get(hotelNumber).getEarningsEstimate());
            } else {
                lowInfo(scan, hotels, hotelNumber);
            }
        } catch (Exception e) {
            System.err.println("Input out of bounds!");
            selInfo(scan, hotels, hotelNumber);
        }
    }

    /**
     * method lowInfo is a method that lets you select the low level information you
     * want to know about a hotel
     * 
     * @param scan        imports scanner
     * @param hotels      hotel array list to get info from
     * @param hotelNumber hotel index for array list
     */
    private void lowInfo(Scanner scan, ArrayList<Hotel> hotels, Integer hotelNumber) {
        Integer optLow = 0;

        try {
            System.out.println("Select " + hotels.get(hotelNumber).getName() + "'s");
            System.out.println(
                    "[1] Avaiable Rooms (Specify Date)\n[2] Room Information\n[3] Reservation Information");
            optLow = Integer.parseInt(scan.nextLine());
            switch (optLow) {
                case 1:
                    roomFree(scan, hotels, hotelNumber);
                    break;
                case 2:
                    roomInfo(scan, hotels, hotelNumber);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Input out of bounds!");
            lowInfo(scan, hotels, hotelNumber);
        }
    }

    private void roomFree(Scanner scan, ArrayList<Hotel> hotels, Integer hotelNumber) {
        try {
            Integer i, year, month, day, hour;

            // change this to something simpler later
            System.out.println("Enter year: ");
            year = Integer.parseInt(scan.nextLine());
            System.out.println("Enter month:");
            month = Integer.parseInt(scan.nextLine());
            System.out.println("Enter day: ");
            day = Integer.parseInt(scan.nextLine());

            int reserved = 0, free = 0;
            @SuppressWarnings("deprecation")
            Date inputDate = new Date(year.intValue(), month.intValue(), day.intValue());
            String dateString = year + "/" + month + "/" + day;
            if (hotels.get(hotelNumber).getReservations().size() != 1) {
                for (i = 0; i < hotels.get(hotelNumber).getReservations().size(); ++i) {
                    if (hotels.get(hotelNumber).getReservations().get(i).getCheckInDate().after(inputDate) &&
                            hotels.get(hotelNumber).getReservations().get(i).getCheckOutDate().before(inputDate)) {
                        reserved++;
                    }
                }
            }
            free = hotels.get(hotelNumber).rooms.size() - reserved;

            System.out.println("Reserved rooms during " + dateString + ": " + reserved);
            System.out.println("Free rooms during " + dateString + ": " + free);

        } catch (Exception e) {
            System.err.println("Error occured!");
        }
    }

    private void roomInfo(Scanner scan, ArrayList<Hotel> hotels, Integer hotelNumber) {
        Integer floor = 0, number = 0;
        int c1 = 0, c2 = 0;
        System.out.println("Showing all rooms in " + hotels.get(hotelNumber).getName() + "...");
        for (int i = 0; i < hotels.get(hotelNumber).getRooms().size(); ++i) {
            System.out.println("[" + (i + 1) + "]" +
                    hotels.get(hotelNumber).getRooms().get(i).getRoomFloor() + "-"
                    + hotels.get(hotelNumber).getRooms().get(i).getRoomNumber());
        }

        do {
            if (c1 != 0) {
                System.err.println("Enter Room value in range");
            }

            System.out.println("Enter room floor: ");
            floor = Integer.parseInt(scan.nextLine());
            c1++;
        } while (floor > hotels.get(hotelNumber).getRooms().getLast().getRoomFloor());
        do {
            if (c2 != 0) {
                System.err.println("Enter Room value in range");
            }

            System.out.println("Enter room number on floor " + floor + " : ");
            number = Integer.parseInt(scan.nextLine());
            c2++;
        } while (number > hotels.get(hotelNumber).getRooms().getLast().getRoomNumber());

        Integer year,
                month;
        System.out.println("Enter year: ");
        year = Integer.parseInt(scan.nextLine());
        System.out.println("Enter month:");
        month = Integer.parseInt(scan.nextLine());

        @SuppressWarnings("deprecation")
        Date beforeDate = new Date(year.intValue(), month.intValue(), 1);
        @SuppressWarnings("deprecation")
        Date afterDate = new Date(year.intValue(), month.intValue(), 31);
        String dateString = year + "/"
                + month;
        System.out.println("Room " + floor + "-" + number + "'s info: " + "during " + dateString + ": ");

    }
}
