
import java.awt.*;
import javax.swing.*;

public class HotelGUI extends JFrame{
    
    public HotelGUI(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());

        setSize(1024, 768);
        init();

        setVisible(true);
    }

    private void init() {
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#CE2211"));

        this.add(panelSouth, BorderLayout.SOUTH);
    }
}