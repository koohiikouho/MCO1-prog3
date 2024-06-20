import java.util.ArrayList;

public class HRSYS{
    
    private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    public static void main(String args[]){
        HRSYS hotelsys = new HRSYS();

        hotelsys.createHotel();

        

        System.out.println(  hotelsys.hotels.get(0).getName() );
        
    }

    public void createHotel(){
        hotels.add(new Hotel());
    }

}