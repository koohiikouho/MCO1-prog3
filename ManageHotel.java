import java.math.BigDecimal;
import java.util.*;

/**
 * ManageHotel is a method class to manage the Hotel thorough different options
 */
public class ManageHotel {

	/**
	 * optionSel acts as the main method, it contains methods
	 * to manage the hotel
	 * 
	 * @param hotels imports hotel arrayList
	 */
	public void optionSel(ArrayList<Hotel> hotels) {
		int option = 0;
		Scanner sc1 = new Scanner(System.in);
		try {
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
		} catch (Exception e) {
			System.out.println("Invalid input!!");
		}
	}

	/**
	 * viewHotelList allows the user to view how many hotels there are in the
	 * arraylist
	 * 
	 * @param scan   imports scanner
	 * @param hotels imports hotel arrayList
	 * @return hotelNum which is the index of the hotel the User picked, if there
	 *         are none it returns a negative value
	 */
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

	/**
	 * changeHotelName allows the user to change the name of the hotel chosen
	 * 
	 * @param scan     imports scanner
	 * @param hotels   imports hotel arrayList
	 * @param hotelNum imports the index of the user's chosen hotel
	 */
	public void changeHotelName(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum >= 0) {
			System.out.println("What do you want to set it to?");
			hotels.get(hotelNum).setName(scan.nextLine());
			System.out.println("Name set to " + hotels.get(hotelNum).getName());
		}
	}

	/**
	 * addRooms allows the user to add rooms in the hotel chosen
	 * 
	 * @param scan     imports scanner
	 * @param hotels   imports hotel arrayList
	 * @param hotelNum imports the index of the user's chosen hotel
	 */
	public void addRooms(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		Integer numFloor, numRoom, blocker, i;

		if (hotelNum >= 0) {
			if (hotels.get(hotelNum).rooms.size() < 50) {
				do {
					System.out.println("Enter FloorNumber");
					numFloor = Integer.parseInt(scan.nextLine());

					if (numFloor >= hotels.get(hotelNum).rooms.getLast().getRoomFloor() && numFloor <= 0) {
						System.out.println("We can't just construct a new floor");
						System.out.println("Please pick an existing floor");
					}

				} while (numFloor >= hotels.get(hotelNum).rooms.getLast().getRoomFloor() && numFloor <= 0);

				do {
					blocker = 0;

					System.out.println("Enter New Room Number");
					numRoom = Integer.parseInt(scan.nextLine());

					for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
						if (numRoom == hotels.get(hotelNum).rooms.get(i).getRoomNumber()
								&& numFloor == hotels.get(hotelNum).rooms.get(i).getRoomFloor()) {
							System.out.println("Sorry this room already exists");
							System.out.println("Cannot create a duplicate of this room please try again");
							blocker = 1;
						}
					}

				} while (blocker == 1);

				hotels.get(hotelNum).rooms.add(new Room(numFloor, numRoom));
			} else
				System.out.println("Sorry the limit for rooms in this establishment is only 50");
		}
	}

	/**
	 * removeRooms allows the user to remove rooms in the hotel chosen
	 * 
	 * @param scan     imports scanner
	 * @param hotels   imports hotel arrayList
	 * @param hotelNum imports the index of the user's chosen hotel
	 */
	public void removeRooms(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum >= 0) {
			int i, room, blocker = 0;

			for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
				System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-"
						+ hotels.get(hotelNum).rooms.get(i).getRoomNumber());
			}

			do {
				System.out.println("Please select a room to be removed");
				room = Integer.parseInt(scan.nextLine()) - 1;

				if (room >= hotels.get(hotelNum).rooms.size() || room <= 0)
					System.out.println("Please select from the choices above");

			} while (room >= hotels.get(hotelNum).rooms.size() || room <= 0);

			for (i = 0; i < hotels.get(hotelNum).getReservations().size(); ++i) {
				if (hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomFloor() == hotels.get(hotelNum).rooms
						.get(room).getRoomFloor()
						&& hotels.get(hotelNum).getReservations().get(i).getRoom()
								.getRoomNumber() == hotels.get(hotelNum).rooms.get(room).getRoomNumber()) {
					System.out.println("Room is booked cannot remove the room at the moment");
					blocker = 1;
				}
			}

			if (blocker == 0)
				hotels.get(hotelNum).rooms.remove(room);
		}
	}

	/**
	 * updateRoomPrice allows the user to set the new room base price
	 * 
	 * @param scan     imports scanner
	 * @param hotels   imports hotel arrayList
	 * @param hotelNum imports the index of the user's chosen hotel
	 */
	public void updateRoomPrice(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
        if (hotelNum >= 0) {
            int i;
            String money;
            
            do {
                System.out.println("What is the new base price?");
                money = scan.nextLine();
                
                if(Integer.parseInt(money) >= 100) 
                {
                    BigDecimal price = new BigDecimal(money.toString());
                    
                    if (hotels.get(hotelNum).getReservations().size() > 0)
                        System.out.println("Cannont change the price while there are reservations still in place");
                    else
                        for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i)
                            hotels.get(hotelNum).rooms.get(0).setBasePrice(price);

                }
                else
                    System.out.println("Cannot set room price lower than 100");
                    
            } while(Integer.parseInt(money) < 100);
            
        }
    }

	/**
	 * removeReservation allows the user to remove reservations from the reservation
	 * arrayList
	 * 
	 * @param scan     imports scanner
	 * @param hotels   imports hotel arrayList
	 * @param hotelNum imports the index of the user's chosen hotel
	 */
	public void removeReservation(Scanner scan, ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum >= 0) {
			int i, room;
			for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
				System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-"
						+ hotels.get(hotelNum).rooms.get(i).getRoomNumber());
			}
			System.out.println("Please select a room");
			room = Integer.parseInt(scan.nextLine()) - 1;

			for (i = 0; i < hotels.get(hotelNum).getReservations().size(); ++i) {
				if (hotels.get(hotelNum).getReservations().get(i).getRoom().getRoomFloor() == hotels.get(hotelNum).rooms
						.get(room).getRoomFloor()
						&& hotels.get(hotelNum).getReservations().get(i).getRoom()
								.getRoomNumber() == hotels.get(hotelNum).rooms.get(room).getRoomNumber())
					hotels.get(hotelNum).getReservations().remove(i);
			}
		}
	}

	/**
	 * removeHotel allows the user to remove a hotel from the hotel arrayList
	 * 
	 * @param hotels   imports hotel arrayList
	 * @param hotelNum imports the index of the user's chosen hotel
	 */
	public void removeHotel(ArrayList<Hotel> hotels, int hotelNum) {
		if (hotelNum >= 0)
			hotels.remove(hotelNum);
	}

}
