import java.util.*;

/**
 * ViewHotel is a method class to view a Hotel's information in addition to the
 * rooms included in the hotel
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
            selInfo(scan, hotels.get(hotelNumber));

        } catch (Exception e) { // if hotel does not exit
            System.err.println("Hotel number does not exist, try again");
            viewHotel(scan, hotels);
        }

    }

    /**
     * selInfo lets the user choose what information they want to know about a hotel
     * 
     * @param scan   imports scanner
     * @param hotels hotel to get information from
     */
    private void selInfo(Scanner scan, Hotel hotels) {
        // variable declaration
        Integer highLow = 0;
        // asks if you want to view high or low level information
        try {
            System.out.println("Do you want to view " + hotels.getName() + "'s");
            System.out.println("[1] High level Information or;\n[2] Low level Information");
            highLow = Integer.parseInt(scan.nextLine());

            if (highLow == 1) {
                System.out.println("Hotel name: " + hotels.getName());
                System.out.println(("No. of rooms in hotel:  " + hotels.rooms.size()));
                System.out.println("Estimated earnings: " + hotels.getEarningsEstimate());
            } else {
                lowInfo(scan, hotels);
            }
        } catch (Exception e) { // if input is outside 1 or 2
            System.err.println("Input out of bounds!");
            selInfo(scan, hotels);
        }
    }

    /**
     * method lowInfo is a method that lets you select the low level information you
     * want to know about a hotel
     * 
     * @param scan   imports scanner
     * @param hotels hotel to get information from
     */
    private void lowInfo(Scanner scan, Hotel hotels) {
        // variable declaration
        Integer optLow = 0;
        // menu for options
        try {
            System.out.println("Select " + hotels.getName() + "'s");
            System.out.println(
                    "[1] Avaiable Rooms (Specify Date)\n[2] Room Information\n[3] Reservation Information");
            optLow = Integer.parseInt(scan.nextLine());
            switch (optLow) {
                case 1:
                    roomFree(scan, hotels);
                    break;
                case 2:
                    roomInfo(scan, hotels);
                    break;
                case 3:
                    reservationInfo(scan, hotels.getReservations());
                    break;
            }
        } catch (Exception e) { // if input is outside 1-3
            System.err.println("Input out of bounds!");
            lowInfo(scan, hotels);
        }
    }

    /**
     * roomFree is a method that checks how many rooms are free during the day
     * 
     * @param scan   scanner import
     * @param hotels hotel to get information from
     */
    private void roomFree(Scanner scan, Hotel hotels) {
        try {
            // variable declarations
            Integer i, year, month, day;

            // change this to something simpler later
            System.out.println("Enter year: ");
            year = Integer.parseInt(scan.nextLine());
            System.out.println("Enter month:");
            month = Integer.parseInt(scan.nextLine());
            System.out.println("Enter day: ");
            day = Integer.parseInt(scan.nextLine());

            // variable declarations again
            int reserved = 0, free = 0;
            Date inputDate = new Date(year.intValue(), month.intValue(), day.intValue());
            String dateString = year + "/" + month + "/" + day;

            if (hotels.getReservations().size() != 1) {
                for (i = 0; i < hotels.getReservations().size(); ++i) {

                    if (hotels.getReservations().get(i).getCheckInDate().before(inputDate) &&
                            hotels.getReservations().get(i).getCheckOutDate().after(inputDate)) {
                        reserved++;
                    }
                }
            }

            free = hotels.rooms.size() - reserved;

            System.out.println("Reserved rooms during " + dateString + ": " + reserved);
            System.out.println("Free rooms during " + dateString + ": " + free);

        } catch (Exception e) {
            System.err.println("Error occured!");
        }
    }

    /**
     * roomInfo is a method that gets the following information from a room:
     * name
     * price
     * availability in a month
     * 
     * @param scan   scanner variable
     * @param hotels hotel to get room from
     */

    private void roomInfo(Scanner scan, Hotel hotels) {
        Integer floor = 0, number = 0;
        int c1 = 0, c2 = 0;
        // for loop shows all rooms in a hotel
        System.out.println("Showing all rooms in " + hotels.getName() + "...");
        for (int i = 0; i < hotels.getRooms().size(); ++i) {
            System.out.println("[" + (i + 1) + "]" +
                    hotels.getRooms().get(i).getRoomFloor() + "-"
                    + hotels.getRooms().get(i).getRoomNumber());
        }

        // do while loops protect from misinputs
        do {
            if (c1 != 0) {
                System.err.println("Enter Room value in range");
            }

            System.out.println("Enter room floor: ");
            floor = Integer.parseInt(scan.nextLine());
            c1++;
        } while (floor > hotels.getRooms().getLast().getRoomFloor());
        do {
            if (c2 != 0) {
                System.err.println("Enter Room value in range");
            }

            System.out.println("Enter room number on floor " + floor + " : ");
            number = Integer.parseInt(scan.nextLine());
            c2++;
        } while (number > hotels.getRooms().getLast().getRoomNumber());

        // part 2 of roomInfo
        Integer roomIndex = hotels.returnIndex(floor, number);
        System.out.println("Room price: "
                + hotels.getRooms().get(roomIndex).getBasePrice());

        Integer year,
                month;

        System.out.println("Enter year: ");
        year = Integer.parseInt(scan.nextLine());
        System.out.println("Enter month:");
        month = Integer.parseInt(scan.nextLine());

        // instantiate date classes as search keys
        Date afterDate = new Date(year.intValue(), month.intValue(), 1);
        Date beforeDate = new Date(year.intValue(), month.intValue(), 31);
        String dateString = year + "/"
                + month;

        System.out.println("Room " + floor + "-" + number + "'s info " + "during " + dateString + ": ");
        System.out.println("Unavailable during: ");
        // shows the reservations that are inside the month
        if (hotels.getReservations().size() == 0) {
            System.out.println("No reservations for hotel");
        } else {
            for (int i = 0; i < hotels.getReservations().size(); ++i) {
                if (hotels.getReservations().get(i).getRoom().getRoomFloor() == floor
                        && hotels.getReservations().get(i).getRoom().getRoomNumber() == number) {
                    if (afterDate.before(hotels.getReservations().get(i).getCheckInDate())
                            && beforeDate.after(hotels.getReservations().get(i).getCheckInDate())) {
                        System.out.println(toDateString(hotels.getReservations().get(i), true) + " until "
                                + toDateString(hotels.getReservations().get(i), false));
                    }
                }
            }
        }
    }

    /**
     * reservationInfo is a method that allows a user to view all of the
     * reservations in a hotel using the , and . keys
     * 
     * @param scan   scanner object
     * @param hotels hotel to pull reservations from
     */
    private void reservationInfo(Scanner scan, ArrayList<Reservation> reservations) {
        Character input = ' ';
        Integer i = 0;
        try {
            do {
                System.out.println(
                        "Guest Name: " +
                                reservations.get(i).getGuestName().getFirstName()
                                + " " +
                                reservations.get(i).getGuestName().getLastName());
                System.out.println("Room: " +
                        reservations.get(i).getRoom().getRoomFloor()
                        + '-' +
                        reservations.get(i).getRoom().getRoomNumber());
                System.out.println("Check In Date: " + toDateString(reservations.get(i),
                        true));
                System.out.println("Check Out Date: " + toDateString(reservations.get(i),
                        false));
                for (int j = 0; j < reservations.size(); j++) {
                    System.out.println(reservations.get(i).getTransaction().get(j).getDescription() + " P"
                            + reservations.get(i).getTransaction().get(j).getAmount());
                }
                System.out.println("----------------------------------------------------");
                System.out.println("Total " + reservations.get(i).getTransactionTotal());

                System.out.println("Enter '.' for next, ',' for back: , 'x' to exit");
                input = Character.toUpperCase(scan.nextLine().charAt(0));
                if (input == '.')
                    i++;
                else if (input == ',') {
                    i--;
                }
            } while (input != 'X');
        } catch (Exception e) {
            System.err.println("No reservation info available!");
        }

    }

    /**
     * toDateString is a method to turn a Date class into a string, this date will
     * come from the reservation
     * 
     * @param reservation reservation to grab date from
     * @return returns a string in yy/mm/dd format
     */
    private String toDateString(Reservation reservation, Boolean checkIn) {

        if (checkIn == true) {
            String dateInString = Integer
                    .toString(reservation.getCheckInDate().getYear())
                    + "/"
                    + Integer.toString(reservation.getCheckInDate().getMonth())
                    + "/" +
                    Integer.toString(reservation.getCheckInDate().getDay());

            return dateInString;
        } else {
            String dateInString = Integer
                    .toString(reservation.getCheckOutDate().getYear())
                    + "/"
                    + Integer
                            .toString(reservation.getCheckOutDate().getMonth())
                    + "/" +
                    Integer.toString(reservation.getCheckOutDate().getDay());
            return dateInString;
        }

    }
}
