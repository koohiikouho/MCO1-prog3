import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SimulateBooking {

	public void SimBooking(ArrayList<Hotel> hotels) 
	{
		try (Scanner scan = new Scanner(System.in)) {
			int i, hotelNum, roomNum, day, month, year, hour, min, reserveInd = -1;
					
			if(hotels.size() != 0)
			{
			    for (i = 0; i < hotels.size(); ++i)
			    {
			        System.out.println("[" + (i + 1) + "] " + hotels.get(i).getName() + "\n");
			    }
			    System.out.println("Select the hotel number: ");
			    hotelNum = Integer.parseInt(scan.nextLine()) - 1;
			    
			    System.out.println("Select your room number:");
			    roomNum = Integer.parseInt(scan.nextLine()) - 1;
			    
			    reserveInd = findReservation(hotels.get(hotelNum).rooms.get(roomNum), hotels, hotelNum);
			    
			    if(reserveInd != -1)
			    {
			    	System.out.println("Sorry this room is reserved until " + hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getDay() + "-" + hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getMonth() + "-" + hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getYear());
			    }
			    else
			    {
//	        	CheckIn
			    	System.out.println("Ok no reservations yet");
			    	System.out.println("What month is the Check in?");
			    	month = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Day is the Check in?");
			    	day = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Year is the Check in?");
			    	year = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("Hour?");
			    	hour = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("Minute?");
			    	min = Integer.parseInt(scan.nextLine());
			    	
			    	hotels.get(hotelNum).rooms.get(roomNum).setCheckInDate(new Date(year, month, day, hour, min));
			    	
//	        	CheckOut
			    	System.out.println("What month is the Check Out?");
			    	month = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Day is the Check Out?");
			    	day = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Year is the Check Out?");
			    	year = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("Hour?");
			    	hour = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("Minute?");
			    	min = Integer.parseInt(scan.nextLine());
			    	
			    	hotels.get(hotelNum).rooms.get(roomNum).setCheckOutDate(new Date(year, month, day, hour, min));
			    }
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
