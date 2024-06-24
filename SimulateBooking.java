import java.util.ArrayList;
import java.util.Scanner;

public class SimulateBooking {

	public void SimBooking(ArrayList<Hotel> hotels) 
	{
		try (Scanner scan = new Scanner(System.in)) {
			int i, hotelNum, roomNum, day, month, year, hour, min;
			String meridiem;
					
			if(hotels.size() != 0)
			{
			    for (i = 0; i < hotels.size(); ++i)
			    {
			        System.out.println("[" + (i + 1) + "] " + hotels.get(i).getName() + "\n");
			    }
			    System.out.println("Select the hotel number: ");
			    hotelNum = Integer.parseInt(scan.nextLine()) - 1;
			    
			    for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i)
				{
					System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-" + hotels.get(hotelNum).rooms.get(i).getRoomNumber());
				}
			    System.out.println("Select your room number:");
			    roomNum = Integer.parseInt(scan.nextLine()) - 1;
			    
			    if(hotels.get(hotelNum).rooms.get(roomNum).getIsReserved() == true)
			    {
			    	System.out.println("Sorry this room is reserved until " + hotels.get(hotelNum).rooms.get(roomNum).getCheckOutDate().getDay() + "-" + Integer.parseInt(scan.nextLine()) + "-" + hotels.get(hotelNum).rooms.get(roomNum).getCheckOutTime().getHour() + ":" + hotels.get(hotelNum).rooms.get(roomNum).getCheckOutTime().getMinute() + " " + hotels.get(hotelNum).rooms.get(roomNum).getCheckOutTime().getMeridiem());
			    }
			    else
			    {
//	        	CheckIn
			    	System.out.println("What month is the Check in?");
			    	month = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Day is the Check in?");
			    	day = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Year is the Check in?");
			    	year = Integer.parseInt(scan.nextLine());
			    	
			    	hotels.get(hotelNum).rooms.get(roomNum).setCheckInDate(new Date(day, month, year));
			    	
			    	System.out.println("Hour?");
			    	hour = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("Minute?");
			    	min = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("AM or PM?");
			    	meridiem = scan.nextLine();
			    	
			    	hotels.get(hotelNum).rooms.get(roomNum).setCheckInTime(new Time(hour, min, meridiem));
			    	
//	        	CheckOut
			    	System.out.println("What month is the Check Out?");
			    	month = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Day is the Check Out?");
			    	day = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("What Year is the Check Out?");
			    	year = Integer.parseInt(scan.nextLine());
			    	
			    	hotels.get(hotelNum).rooms.get(roomNum).setCheckOutDate(new Date(day, month, year));
			    	
			    	System.out.println("Hour?");
			    	hour = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("Minute?");
			    	min = Integer.parseInt(scan.nextLine());
			    	
			    	System.out.println("AM or PM?");
			    	meridiem = scan.nextLine();
			    	
			    	hotels.get(hotelNum).rooms.get(roomNum).setCheckOutTime(new Time(hour, min, meridiem));
			    }
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
