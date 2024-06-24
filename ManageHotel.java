import java.math.BigDecimal;
import java.util.*;

public class ManageHotel {

	public void optionSel(ArrayList<Hotel> hotels) {
		int option = 0;
		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println("Enter option:");
			System.out.println(
					"[1] Change Hotel Name\n[2] Add Rooms\n[3] Remove Rooms\n[4] Update Room Base Price\n[5] Remove Reservation\n[6] Remove Hotel\n[7] Exit\n");

			switch (option = Integer.parseInt(sc1.nextLine())) {
				case 1:
					changeHotelName(sc1, hotels, viewHotelList(sc1, hotels));
					break;
				case 2:
					addRooms(sc1, hotels, viewHotelList(sc1, hotels));
					break;
				case 3:
					removeRooms(sc1, hotels, viewHotelList(sc1, hotels));
					break;
				case 4:
					updateRoomPrice(sc1, hotels, viewHotelList(sc1, hotels));
					break;
				case 5:
					removeReservation(sc1, hotels, viewHotelList(sc1, hotels));
					break;
				case 6:
					removeHotel(hotels, viewHotelList(sc1, hotels));
					break;
				case 7:
					System.out.println("Exiting");
					break;
				default:
					System.err.println("Input out of bounds");
					break;
			}
		} while (option != 7);
	}

	public int viewHotelList(Scanner scan, ArrayList<Hotel> hotels) {
		int i, hotelNum;

		if (hotels.size() != 0) {
			System.out.println("Pick hotel to view: ");

			for (i = 0; i < hotels.size(); ++i) {
				System.out.println("[" + (i + 1) + "] " + hotels.get(i).getName() + "\n");
			}
			System.out.println("Enter hotel number here: ");
			hotelNum = Integer.parseInt(scan.nextLine()) - 1;
			return hotelNum;
		} else {
			System.out.println("No hotels initialized!");
			return -1;
		}
	}

	public void changeHotelName(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum >= 0) {
			System.out.println("What do you want to set it to?");
			hotels.get(hotelNum).setName(scan.nextLine());
		}
	}

	public void addRooms(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		int numFloor, numRoom;

		if (hotelNum >= 0) {
			System.out.println("Enter FloorNumber");
			numFloor = scan.nextInt();

			System.out.println("Enter New Room Number");
			numRoom = scan.nextInt();

			hotels.get(hotelNum).rooms.add(new Room(numFloor, numRoom));
		}
	}

	public void removeRooms(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum > 0) {
			int i, room;
			for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
				System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-"
						+ hotels.get(hotelNum).rooms.get(i).getRoomNumber());
			}
			System.out.println("Please select a room to be removed");
			room = Integer.parseInt(scan.nextLine());
			
			for(i = 0; i < hotels.get(hotelNum).getReservations().size(); ++i)
			{
				if (hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomFloor() == hotels.get(hotelNum).rooms.get(room).getRoomFloor() && hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomNumber() == hotels.get(hotelNum).rooms.get(room).getRoomNumber())
					System.out.println("Room is booked cannot remove room");
				else 
					hotels.get(hotelNum).rooms.remove(room);
			}
		}
	}

	public void updateRoomPrice(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum > 0) {
			int i, j;
			boolean check = true;
			BigDecimal price;
			System.out.println("What is the new base price?");
			price = scan.nextBigDecimal();

			for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
				if (hotels.get(hotelNum).getReservations().size() != 0)
					check = false;
			}

			if (check == true)
				for (j = 0; j < hotels.get(hotelNum).rooms.size(); ++i)
					hotels.get(hotelNum).rooms.get(0).setBasePrice(price);
		}
	}

	public void removeReservation(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum > 0) {
			int i, room;
			for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
				System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-"
						+ hotels.get(hotelNum).rooms.get(i).getRoomNumber());
			}
			System.out.println("Please select a room");
			room = Integer.parseInt(scan.nextLine());
			
			for(i = 0; i < hotels.get(hotelNum).getReservations().size(); ++i)
			{
				if (hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomFloor() == hotels.get(hotelNum).rooms.get(room - 1).getRoomFloor() && hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomNumber() == hotels.get(hotelNum).rooms.get(room - 1).getRoomNumber())
					hotels.get(hotelNum).getReservations().remove(i);
			}
		}
	}

	public void removeHotel(ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum >= 0)
			hotels.remove(hotelNum);
	}

	 public int findReservation(Room room, ArrayList<Hotel> hotels, int hotelNum) {
	    	int i, roomNum = -1;
	    	
	    	for(i = 0; i < hotels.get(hotelNum).getReservations().size(); ++i)
			{
				if (hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomFloor() == room.getRoomFloor() && hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomNumber() == room.getRoomNumber())
					roomNum = i;
			}
	    	
	    	return roomNum;
	 }
	
}
