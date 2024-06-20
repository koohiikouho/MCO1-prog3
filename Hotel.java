import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private BigDecimal earningsEstimate;

    public Hotel(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter hotel name: ");
        this.name = scan.nextLine();
        System.out.print("How many rooms?");
        this.name = scan.nextLine();


        scan.close();
    }

    public String getName() {
        return name;
    }

    
}
