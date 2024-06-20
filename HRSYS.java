import java.util.ArrayList;

public class HRSYS{
    
    private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    public static void main(String args[]){
        HRSYS hotelsys = new HRSYS();

        hotelsys.createHotel();

        

        System.out.println(  hotelsys.hotels.get(0).rooms.get(0).getRoomFloor() + "-" + hotelsys.hotels.get(0).rooms.get(0).getRoomNumber());
        
    }

    public void createHotel(){
        hotels.add(new Hotel());
    }

}