import javax.swing.*;
import java.awt.*;

public class L9GUI extends JFrame{

    static JButton okButton = new JButton("OK");
    static JTextField nameField = new JTextField("Bill Gates");
    static JLabel nameLabel = new JLabel("Name:", JLabel.RIGHT);

    public L9GUI(){
        setTitle("Hello World");
        setSize(320, 240);
        okButton.setBounds(50, 100, 1 ,2);
        add(okButton);
        add(nameField);
        add(nameLabel);
        setVisible(true);

    }

    public static void main(String[]args){
        L9GUI frame1 = new L9GUI();
        frame1.add(okButton);

    }
    
}
