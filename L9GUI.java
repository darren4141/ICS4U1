import javax.swing.*;
import java.awt.*;

public class L9GUI extends JFrame{

    static JButton okButton = new JButton("OK");
    static JTextField nameField = new JTextField("Bill Gates");
    static JLabel nameLabel = new JLabel("Name:", JLabel.LEFT);

    public L9GUI(){
        setTitle("Hello World");
        setSize(1000, 1000);
        // BoxLayout box1 = new BoxLayout(L9GUI, MAXIMIZED_BOTH);
        GridLayout grid1 = new GridLayout();
        FlowLayout layout1 = new FlowLayout();
        FlowLayout layout2 = new FlowLayout();

        setLayout(layout1);

        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        pan1.setLayout(layout1);
        pan2.setLayout(layout2);

        pan1.add(nameField);
        pan1.add(nameLabel);

        pan2.add(okButton);

        add(pan1);
        add(pan2);

        setVisible(true);
        setResizable(false);

    }

    public static void main(String[]args){
        L9GUI frame1 = new L9GUI();

    }
    
}
