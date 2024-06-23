import java.util.ArrayList;
import java.util.Scanner;

public class SimulateBooking {

	public void SimulateBooking(ArrayList<Hotel> hotels) 
	{
		Scanner scan = new Scanner(System.in);
		
		int i, hotelNum, roomNum;
				
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
	        
	        
//	        System.out.println("When is the check-in time?");
	        
		}
		
		scan.close();
	}
}
