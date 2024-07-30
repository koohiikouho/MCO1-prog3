/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelgui;
import java.util.*;
/**
 *
 * @author EroZero
 */
public class Controller {
    
    static HRSYS mainClass = new HRSYS();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        MenuGUI menu = new MenuGUI(mainClass);
        menu.show();
        
                       
    }
    
}
