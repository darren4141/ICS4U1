import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class L9GUIPerformanceTask extends JFrame implements ActionListener{

    static JLabel mainMessage = new JLabel("Welcome!");

    static JLabel usernameLabel = new JLabel("Username:", JLabel.LEFT);
    static JLabel passwordLabel = new JLabel("Password:", JLabel.LEFT);
    
    static JTextField usernameField = new JTextField("user");
    static JTextField passwordField = new JTextField("pass");

    static JButton okButton = new JButton("Login");

    static JLabel loginMessage = new JLabel("Enter your username and password");


    public L9GUIPerformanceTask(){
        setTitle("Login Authentification");
        setSize(500, 250);

        okButton.addActionListener(this);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        FlowLayout layout1 = new FlowLayout();
        FlowLayout layout2 = new FlowLayout();
        FlowLayout layout3 = new FlowLayout();
        FlowLayout layout4 = new FlowLayout();
        FlowLayout layout5 = new FlowLayout();

        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel();
        JPanel pan4 = new JPanel();
        JPanel pan5 = new JPanel();

        pan1.setLayout(layout1);
        pan2.setLayout(layout2);
        pan3.setLayout(layout3);
        pan4.setLayout(layout4);
        pan5.setLayout(layout5);
        
        
        pan1.add(mainMessage);
        pan2.add(usernameLabel);
        pan2.add(usernameField);

        pan3.add(passwordLabel);
        pan3.add(passwordField);

        pan4.add(okButton);

        pan5.add(loginMessage);

        
        mainPanel.add(pan1);
        mainPanel.add(pan2);
        mainPanel.add(pan3);
        mainPanel.add(pan4);
        mainPanel.add(pan5);

        
        Container contentPane = getContentPane();
        contentPane.add(mainPanel);
        
        setVisible(true);
        setResizable(false);

    }

    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        if(command.equals("Login")){
            loginMessage.setText("You are logged in!");
        }
        
    }

    public static void main(String[]args){
        L9GUIPerformanceTask frame1 = new L9GUIPerformanceTask();

    }
    
}
