package hotelgui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * the SimulateBooking Class is a method class that contains methods to simulate
 * a booking that might be expounded on for MCO2
 */
public class SimulateBooking {

	/**
	 * SimBooking is a method that simulates the booking by asking for a person's
	 * name, the check in date, check out date, and displays how much the entire
	 * booking is
	 * 
	 * @param scan   import scanner from main
	 * @param hotels hotels to store selection in
	 */
    
    public void simBooking(Scanner scan, ArrayList<Hotel> hotels) {

		// variable declarations
		int i, hotelNum = 0, roomNum = 0, reserveInd = -1, day = 0, month = 0, year = 0, hour = 0, min = 0, loop = 0, pass = 0;
		
		String fName, lName, description, discount, tempDescript;
		// hotel selector
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
			// room number selection
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
				// Order Confirmation
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
				
				Date checkOutTemp2 = new Date(checkOutDate.getYear(), checkOutDate.getMonth(), checkOutDate.getDate());
				Date checkInTemp2 = new Date(checkInDate.getYear(), checkInDate.getMonth(), checkInDate.getDate());
				long o;
				long nights = (checkOutTemp.getTime() - checkInTemp.getTime()) / 86400000;
				int a = checkInTemp.getDate();
				
				description = "";
				
				for(o = 0; o < nights; ++o)
				{
					BigDecimal multiply = new BigDecimal(hotels.get(hotelNum).getDPM()[a - 1] / 100.000);
					BigDecimal amount = hotels.get(hotelNum).rooms.get(roomNum).getBasePrice();
					amount = amount.multiply(multiply);
					System.out.println(amount);
					hotels.get(hotelNum).getReservations().getLast().getTransaction().add(new Transaction(amount, description));
					a++;
				}
				
				loop = 0;
				do {
					System.out.println("Input discount code? (y/n)");
					discount = scan.nextLine();
					switch (discount) 
					{
		                case "y":
		                case "yes":
		                case "YES":
		                case "Y":
		                	System.out.println("Please input the code now");
							discount = scan.nextLine();
		                	if(discount.compareTo("I_WORK_HERE") == 0)
		    				{
		                		if(hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().getDescription().contains("discount1") == false)
		                		{
		                			BigDecimal multi = new BigDecimal(0.90);
			                		for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
			                		{
			                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setAmount(hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getAmount().multiply(multi));
			                			tempDescript = hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getDescription();
			                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setDescription(tempDescript.concat("discount1 "));
			                		}
		                		}
		                		else
			    				{
			    					System.out.println("Discount already applied");
			    				}
		    				}
		    				else if(discount.compareTo("STAY4_GET1") == 0)
		    				{
		    					if(hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().getDescription().contains("discount2") == false)
		                		{
			    					if(hotels.get(hotelNum).getReservations().getLast().getTransaction().size() >= 5)
			    					{
			    						BigDecimal multi = new BigDecimal(0);
			    						hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().setAmount(multi);
			    						for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
				                		{
				                			tempDescript = hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getDescription();
				                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setDescription(tempDescript.concat("discount2 "));
				                		}
			    					}
			    					else
				    				{
				    					System.out.println("Sorry you are not eligible for this discount");
				    				}
		                		}
		    					else
			    				{
			    					System.out.println("Discount already applied");
			    				}
		    				}
		    				else if(discount.compareTo("PAYDAY") == 0)
		    				{
		    					if(hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().getDescription().contains("discount3") == false)
		                		{
			    					Date in15 = new Date(checkInTemp.getYear(), checkInTemp.getMonth(), 15);
			    					Date in30 = new Date(checkInTemp.getYear(), checkInTemp.getMonth(), 30);
			    					Date out15 = new Date(checkOutTemp.getYear(), checkOutTemp.getMonth(), 15);
			    					Date out30 = new Date(checkOutTemp.getYear(), checkOutTemp.getMonth(), 30);
			    					
			    					if(checkInTemp2.getTime() < in15.getTime())
			    					{
			    						if(checkOutTemp2.getTime() >= in15.getTime())
			    							pass = 1;
			    					}
			    					else if (checkInTemp2.getTime() == in15.getTime() || checkInTemp2.getTime() == in30.getTime() || checkInTemp2.getTime() == out15.getTime() || checkInTemp2.getTime() == out30.getTime())
			    					{
			    						pass = 1;
			    					}
			    					else if (checkOutTemp2.getTime() == out15.getTime() || checkOutTemp2.getTime() == out30.getTime() || checkOutTemp2.getTime() == in15.getTime() || checkOutTemp2.getTime() == in30.getTime())
			    					{
			    						pass = 1;
			    					}
			    					else if(checkInTemp2.getTime() < in30.getTime())
			    					{
			    						if(checkOutTemp2.getTime() >= in30.getTime())
			    							pass = 1;
			    					}
			    					
			    					if(pass == 1)
			    					{
			    						BigDecimal multi = new BigDecimal(0.93);
				                		for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
				                		{
				                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setAmount(hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getAmount().multiply(multi));
				                			tempDescript = hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getDescription();
				                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setDescription(tempDescript.concat("discount3 "));
				                		}
			    					}
			    					else
				    				{
				    					System.out.println("Sorry you are not eligible for this discount");
				    				}
		                		}
		    					else
			    				{
			    					System.out.println("Discount already applied");
			    				}
		    				}
		                	loop = 1;
		                    break;
		                case "no":
		                case "N":
		                case "NO":
		                case "n":
		                	loop = 0;
		                    break;
		                default:
		                    System.out.println("error");
		                    loop = 1;
		                    break;
					}
				} while(loop == 1);
				
				BigDecimal amount = new BigDecimal(0.00);
				for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
        		{
        			amount = amount.add(hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getAmount());
        		}
				
				System.out.println("Amount to be paid by customer: " + amount);
				System.out.println(description);
			}
		}
	}
        
	public void simBookingRet(Integer hotelNum, Integer roomNum, Integer day, Integer month, Integer year, Integer hour, Integer min, ArrayList<Hotel> hotels,
        String fName, String lName,Integer cday, Integer cmonth, Integer cyear, Integer chour, Integer cmin) {

		// variable declarations
		int i, loop = 0, pass = 0;
		
		String description, discount, tempDescript;
		// hotel selector
		if (hotels.size() != 0) {
			

				for (i = 0; i < hotels.size(); ++i) {
					System.out.println("[" + (i + 1) + "] " + hotels.get(i).getName() + "\n");
				}

				System.out.println("Select the hotel number: ");
				hotelNum -=1;

				if (hotelNum > hotels.size() || hotelNum < 0)
					System.out.println("Please choose from the folowing hotels, try again");

			
			// room number selection
			

				for (i = 0; i < hotels.get(hotelNum).rooms.size(); ++i) {
					System.out.println("[" + (i + 1) + "] " + hotels.get(hotelNum).rooms.get(i).getRoomFloor() + "-"
							+ hotels.get(hotelNum).rooms.get(i).getRoomNumber());
				}

				System.out.println("Select your room number:");
				roomNum -= 1;

				if (roomNum > hotels.get(hotelNum).rooms.size() || roomNum < 0)
					System.out.println("Please choose from the folowing rooms, try again");

			

			Integer reserveInd = findReservation(hotels.get(hotelNum).rooms.get(roomNum), hotels, hotelNum);

			if (reserveInd != -1) {
				System.out.println("Sorry this room is reserved until "
						+ hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getDay() + "-"
						+ hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getMonth() + "-"
						+ hotels.get(hotelNum).getReservations().get(reserveInd).getCheckOutDate().getYear());
			} else {
				// CheckIn
				System.out.println("Ok no reservations yet");

				System.out.println("Customer's first name?");
				

				System.out.println("Customer's last name?");
				

				Name name = new Name(fName, lName);

				do {
					System.out.println("What month is the Check in?");

					if (month <= 0 || month > 12)
						System.out.println("Please select an existing month, try again");

				} while (month <= 0 || month > 12);

				do {
					System.out.println("What Day is the Check in?");

					if (day <= 0 || day > 31)
						System.out.println("Please select an appropriate day, try again");

				} while (day <= 0 || day > 31);

				do {
					System.out.println("What Year is the Check in?");

					if (year < 2024)
						System.out.println(
								"We can't go back in time friend, try again a bit bigger the next time please");

					if (year > 2050)
						System.out.println("I think thats a bit too far into the future, try again this time smaller");

				} while (year < 2024 || year > 2050);

				do {
					System.out.println("At what Hour are we expecting the guest?");

					if (hour < 0 || hour > 23)
						System.out.println("We follow military time, please pick an hour from 0 to 23");

				} while (hour < 0 || hour > 23);

				do {
					System.out.println("To be more accurate, at what minute are we expecting the guest?");

					if (min < 0 || min > 59)
						System.out.println("Please pick an hour from 0 to 59");

				} while (min < 0 || min > 59);

				Date checkInDate = new Date(year, month - 1, day, hour, min);

				// CheckOut------------------------------------------------------------------------------------------------------------------

				do {
					System.out.println("What month is the Check Out?");
					

					if (month <= 0 || month > 12)
						System.out.println("Please select an existing month, try again");

				} while (month <= 0 || month > 12);

				do {
					System.out.println("What Day is the Check Out?");
					

					if (day <= 0 || day > 31)
						System.out.println("Please select an appropriate day, try again");

				} while (day <= 0 || day > 31);

				do {
					System.out.println("What Year is the Check Out?");
					

					if (year < 2024)
						System.out.println(
								"We can't go back in time friend, try again a bit bigger the next time please");

					if (year > 2050)
						System.out.println("I think thats a bit too far into the future, try again this time smaller");

				} while (year < 2024 || year > 2050);

				do {
					System.out.println("At what Hour are we expecting the guest to leave?");
					

					if (hour < 0 || hour > 23)
						System.out.println("We follow military time, please pick an hour from 0 to 23");

				} while (hour < 0 || hour > 23);

				do {
					System.out.println(
							"To be more accurate, at what minute are we expecting the guest to be out of the hotel?");
					

					if (min < 0 || min > 59)
						System.out.println("Please pick an hour from 0 to 59");

				} while (min < 0 || min > 59);

				Date checkOutDate = new Date(cyear, cmonth - 1, cday, chour, cmin);
				// Order Confirmation
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
				
				Date checkOutTemp2 = new Date(checkOutDate.getYear(), checkOutDate.getMonth(), checkOutDate.getDate());
				Date checkInTemp2 = new Date(checkInDate.getYear(), checkInDate.getMonth(), checkInDate.getDate());
				long o;
				long nights = (checkOutTemp.getTime() - checkInTemp.getTime()) / 86400000;
				int a = checkInTemp.getDate();
				
				description = "";
				
				for(o = 0; o < nights; ++o)
				{
					BigDecimal multiply = new BigDecimal(hotels.get(hotelNum).getDPM()[a - 1] / 100.000);
					BigDecimal amount = hotels.get(hotelNum).rooms.get(roomNum).getBasePrice();
					amount = amount.multiply(multiply);
					System.out.println(amount);
					hotels.get(hotelNum).getReservations().getLast().getTransaction().add(new Transaction(amount, description));
					a++;
				}
				
				loop = 0;
				do {
					System.out.println("Input discount code? (y/n)");
					discount = scan.nextLine();
					switch (discount) 
					{
		                case "y":
		                case "yes":
		                case "YES":
		                case "Y":
		                	System.out.println("Please input the code now");
							discount = scan.nextLine();
		                	if(discount.compareTo("I_WORK_HERE") == 0)
		    				{
		                		if(hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().getDescription().contains("discount1") == false)
		                		{
		                			BigDecimal multi = new BigDecimal(0.90);
			                		for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
			                		{
			                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setAmount(hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getAmount().multiply(multi));
			                			tempDescript = hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getDescription();
			                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setDescription(tempDescript.concat("discount1 "));
			                		}
		                		}
		                		else
			    				{
			    					System.out.println("Discount already applied");
			    				}
		    				}
		    				else if(discount.compareTo("STAY4_GET1") == 0)
		    				{
		    					if(hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().getDescription().contains("discount2") == false)
		                		{
			    					if(hotels.get(hotelNum).getReservations().getLast().getTransaction().size() >= 5)
			    					{
			    						BigDecimal multi = new BigDecimal(0);
			    						hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().setAmount(multi);
			    						for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
				                		{
				                			tempDescript = hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getDescription();
				                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setDescription(tempDescript.concat("discount2 "));
				                		}
			    					}
			    					else
				    				{
				    					System.out.println("Sorry you are not eligible for this discount");
				    				}
		                		}
		    					else
			    				{
			    					System.out.println("Discount already applied");
			    				}
		    				}
		    				else if(discount.compareTo("PAYDAY") == 0)
		    				{
		    					if(hotels.get(hotelNum).getReservations().getLast().getTransaction().getFirst().getDescription().contains("discount3") == false)
		                		{
			    					Date in15 = new Date(checkInTemp.getYear(), checkInTemp.getMonth(), 15);
			    					Date in30 = new Date(checkInTemp.getYear(), checkInTemp.getMonth(), 30);
			    					Date out15 = new Date(checkOutTemp.getYear(), checkOutTemp.getMonth(), 15);
			    					Date out30 = new Date(checkOutTemp.getYear(), checkOutTemp.getMonth(), 30);
			    					
			    					if(checkInTemp2.getTime() < in15.getTime())
			    					{
			    						if(checkOutTemp2.getTime() >= in15.getTime())
			    							pass = 1;
			    					}
			    					else if (checkInTemp2.getTime() == in15.getTime() || checkInTemp2.getTime() == in30.getTime() || checkInTemp2.getTime() == out15.getTime() || checkInTemp2.getTime() == out30.getTime())
			    					{
			    						pass = 1;
			    					}
			    					else if (checkOutTemp2.getTime() == out15.getTime() || checkOutTemp2.getTime() == out30.getTime() || checkOutTemp2.getTime() == in15.getTime() || checkOutTemp2.getTime() == in30.getTime())
			    					{
			    						pass = 1;
			    					}
			    					else if(checkInTemp2.getTime() < in30.getTime())
			    					{
			    						if(checkOutTemp2.getTime() >= in30.getTime())
			    							pass = 1;
			    					}
			    					
			    					if(pass == 1)
			    					{
			    						BigDecimal multi = new BigDecimal(0.93);
				                		for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
				                		{
				                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setAmount(hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getAmount().multiply(multi));
				                			tempDescript = hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getDescription();
				                			hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).setDescription(tempDescript.concat("discount3 "));
				                		}
			    					}
			    					else
				    				{
				    					System.out.println("Sorry you are not eligible for this discount");
				    				}
		                		}
		    					else
			    				{
			    					System.out.println("Discount already applied");
			    				}
		    				}
		                	loop = 1;
		                    break;
		                case "no":
		                case "N":
		                case "NO":
		                case "n":
		                	loop = 0;
		                    break;
		                default:
		                    System.out.println("error");
		                    loop = 1;
		                    break;
					}
				} while(loop == 1);
				
				BigDecimal amount = new BigDecimal(0.00);
				for(i = 0; i < hotels.get(hotelNum).getReservations().getLast().getTransaction().size(); ++i)
        		{
        			amount = amount.add(hotels.get(hotelNum).getReservations().getLast().getTransaction().get(i).getAmount());
        		}
				
				System.out.println("Amount to be paid by customer: " + amount);
				System.out.println(description);
			}
		}
	}

	/**
	 * findReservation is a method that finds reservations for a room in a hotel
	 * 
	 * @param room     room to search for
	 * @param hotels   hotels for hotelNum
	 * @param hotelNum hotel to search in, index for hotel
	 * @return returns the index of the room
	 */
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
