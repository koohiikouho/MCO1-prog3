
import java.awt.*;
import javax.swing.*;

public class HotelGUI extends JFrame{
    private JButton addBtn;
    private JButton viewBtn;
    private JButton mngBtn;
    private JButton simBtn;
    private JButton exitBtn;

    public HotelGUI(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());
        setSize(1024, 768);
        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    private void init() {
        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#d3d3d3"));

        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#d3d3d3"));
        
        addBtn = new JButton("Add Hotel");
        viewBtn = new JButton("View Hotel");
        mngBtn = new JButton("Manage Hotel");
        simBtn = new JButton("Simulate Booking");
        exitBtn = new JButton("Exit");

        panelSouth.add(addBtn);
        panelSouth.add(viewBtn);
        panelSouth.add(mngBtn);
        panelSouth.add(simBtn);
        panelSouth.add(exitBtn);


        this.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelNorth, BorderLayout.NORTH);
    }
}