import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SimulateBooking {

	public void SimBooking(Scanner scan, ArrayList<Hotel> hotels) {
		int i, hotelNum = 0, roomNum = 0, reserveInd = -1, day = 0, month = 0, year = 0, hour = 0, min = 0;
		String fName, lName, description;

		if (hotels.size() != 0) {
			do {

				for (i = 0; i < hotels.size(); ++i) {
					System.out.println("[" + (i + 1) + "] " + hotels.get(i).getName() + "\n");
				}

				System.out.println("Select the hotel number: ");
				hotelNum = Integer.parseInt(scan.nextLine()) - 1;

				if (hotelNum > hotels.size() || hotelNum < 0)
					System.out.println("Please choose from the folowing hotels, try again");

			} while (hotelNum > hotels.size() || hotelNum < 0);

			do {

				for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
					System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-"
							+ hotels.get(hotelNum).rooms.get(i).getRoomNumber());
				}

				System.out.println("Select your room number:");
				roomNum = Integer.parseInt(scan.nextLine()) - 1;

				if (roomNum > hotels.get(hotelNum).rooms.size() || roomNum < 0)
					System.out.println("Please choose from the folowing rooms, try again");

			} while (roomNum > hotels.get(hotelNum).rooms.size() || roomNum < 0);

			reserveInd = findReservation(hotels.get(hotelNum).rooms.get(roomNum), hotels, hotelNum);

			if (reserveInd != -1) {
				System.out.println("Sorry this room is reserved until "
						+ hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getDay() + "-"
						+ hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getMonth() + "-"
						+ hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getYear());
			} else {
				// CheckIn
				System.out.println("Ok no reservations yet");

				System.out.println("Customer's first name?");
				fName = scan.nextLine();

				System.out.println("Customer's last name?");
				lName = scan.nextLine();

				Name name = new Name(fName, lName);

				do {
					System.out.println("What month is the Check in?");
					month = Integer.parseInt(scan.nextLine());

					if (month <= 0 || month > 12)
						System.out.println("Please select an existing month, try again");

				} while (month <= 0 || month > 12);

				do {
					System.out.println("What Day is the Check in?");
					day = Integer.parseInt(scan.nextLine());

					if (day <= 0 || day > 31)
						System.out.println("Please select an appropriate day, try again");

				} while (day <= 0 || day > 31);

				do {
					System.out.println("What Year is the Check in?");
					year = Integer.parseInt(scan.nextLine());

					if (year < 2024)
						System.out.println(
								"We can't go back in time friend, try again a bit bigger the next time please");

					if (year > 2050)
						System.out.println("I think thats a bit too far into the future, try again this time smaller");

				} while (year < 2024 || year > 2050);

				do {
					System.out.println("At what Hour are we expecting the guest?");
					hour = Integer.parseInt(scan.nextLine());

					if (hour < 0 || hour > 23)
						System.out.println("We follow military time, please pick an hour from 0 to 23");

				} while (hour < 0 || hour > 23);

				do {
					System.out.println("To be more accurate, at what minute are we expecting the guest?");
					min = Integer.parseInt(scan.nextLine());

					if (min < 0 || min > 59)
						System.out.println("Please pick an hour from 0 to 59");

				} while (min < 0 || min > 59);

				Date checkInDate = new Date(year, month - 1, day, hour, min);

				// CheckOut------------------------------------------------------------------------------------------------------------------

				do {
					System.out.println("What month is the Check Out?");
					month = Integer.parseInt(scan.nextLine());

					if (month <= 0 || month > 12)
						System.out.println("Please select an existing month, try again");

				} while (month <= 0 || month > 12);

				do {
					System.out.println("What Day is the Check Out?");
					day = Integer.parseInt(scan.nextLine());

					if (day <= 0 || day > 31)
						System.out.println("Please select an appropriate day, try again");

				} while (day <= 0 || day > 31);

				do {
					System.out.println("What Year is the Check Out?");
					year = Integer.parseInt(scan.nextLine());

					if (year < 2024)
						System.out.println(
								"We can't go back in time friend, try again a bit bigger the next time please");

					if (year > 2050)
						System.out.println("I think thats a bit too far into the future, try again this time smaller");

				} while (year < 2024 || year > 2050);

				do {
					System.out.println("At what Hour are we expecting the guest to leave?");
					hour = Integer.parseInt(scan.nextLine());

					if (hour < 0 || hour > 23)
						System.out.println("We follow military time, please pick an hour from 0 to 23");

				} while (hour < 0 || hour > 23);

				do {
					System.out.println(
							"To be more accurate, at what minute are we expecting the guest to be out of the hotel?");
					min = Integer.parseInt(scan.nextLine());

					if (min < 0 || min > 59)
						System.out.println("Please pick an hour from 0 to 59");

				} while (min < 0 || min > 59);

				Date checkOutDate = new Date(year, month - 1, day, hour, min);

				hotels.get(hotelNum).getReservations()
						.add(new Reservation(name, checkInDate, checkOutDate, hotels.get(hotelNum).rooms.get(roomNum)));
				System.out.println("Check In Date: "
						+ hotels.get(hotelNum).getReservations().getLast().getCheckInDate().getYear() + "/"
						+ (hotels.get(hotelNum).getReservations().getLast().getCheckInDate().getMonth() + 1) + "/"
						+ hotels.get(hotelNum).getReservations().getLast().getCheckInDate().getDate() + " "
						+ hotels.get(hotelNum).getReservations().getLast().getCheckInDate().getHours() + ":"
						+ hotels.get(hotelNum).getReservations().getLast().getCheckInDate().getMinutes());
				System.out.println("Check Out Date: "
						+ hotels.get(hotelNum).getReservations().getLast().getCheckOutDate().getYear() + "/"
						+ (hotels.get(hotelNum).getReservations().getLast().getCheckOutDate().getMonth() + 1) + "/"
						+ hotels.get(hotelNum).getReservations().getLast().getCheckOutDate().getDate() + " "
						+ hotels.get(hotelNum).getReservations().getLast().getCheckOutDate().getHours() + ":"
						+ hotels.get(hotelNum).getReservations().getLast().getCheckOutDate().getMinutes());

				Date checkOutTemp = checkOutDate;
				Date checkInTemp = checkInDate;

				long nights = (checkOutTemp.getTime() - checkInTemp.getTime()) / 86400000;
				BigDecimal nightsBigD = new BigDecimal(nights);

				BigDecimal amount = hotels.get(hotelNum).rooms.get(roomNum).getBasePrice();
				amount = amount.multiply(nightsBigD);

				System.out.println("Amount to be paid by customer: " + amount);
				description = "for " + nights + " nights";
				System.out.println(description);

				hotels.get(hotelNum).getReservations().getLast().getTransaction()
						.add(new Transaction(amount, description));
			}
		}
	}

	public int findReservation(Room room, ArrayList<Hotel> hotels, int hotelNum) {
		int i, roomNum = -1;

		for (i = 0; i < hotels.get(hotelNum).getReservations().size(); ++i) {
			if (hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomFloor() == room.getRoomFloor()
					&& hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomNumber() == room.getRoomNumber())
				roomNum = i;
		}

		return roomNum;
	}
}
