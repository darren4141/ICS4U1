package Lessons;
/*
 * "Log in" GUI Performance Task
 * Darren Liu
 * March 22nd, 2024
 * Java 8
 * 
 * Problem Definition: Make a login page that resembles the example given
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class L9GUIPerformanceTask extends JFrame implements ActionListener{


    //Declare buttons, messages, text fields, labels
    static JLabel mainMessage = new JLabel("Welcome!");

    static JLabel usernameLabel = new JLabel("Username:", JLabel.LEFT);
    static JLabel passwordLabel = new JLabel("Password:", JLabel.LEFT);
    
    static JTextField usernameField = new JTextField();
    static JTextField passwordField = new JTextField();

    static JButton okButton = new JButton("Login");

    static JLabel loginMessage = new JLabel("Enter your username and password");

    //declare a hashmap that will store usernames and their respective passwords
    static HashMap <String, String> logins = new HashMap<String, String>();

    public L9GUIPerformanceTask(){
        setTitle("Login Authentification");
        setSize(300, 200);

        //set the size of the text fields
        usernameField.setColumns(10);
        passwordField.setColumns(10);

        //allow us to recieve the state of the button
        okButton.addActionListener(this);

        //create a main panel with vertical box layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //create 5 panels, each with flow layout
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
        
        //add elements to each specific panel
        pan1.add(mainMessage);
        pan2.add(usernameLabel);
        pan2.add(usernameField);

        pan3.add(passwordLabel);
        pan3.add(passwordField);

        pan4.add(okButton);

        pan5.add(loginMessage);
        
        //add each panel to the main panel (box format)
        mainPanel.add(pan1);
        mainPanel.add(pan2);
        mainPanel.add(pan3);
        mainPanel.add(pan4);
        mainPanel.add(pan5);

        //declare a container and add the main panel
        Container contentPane = getContentPane();
        contentPane.add(mainPanel);
        
        //configure settings
        setVisible(true);
        setResizable(false);

    }

    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        //if the login button is pressed
        if(command.equals("Login")){
            //check if the given username and password match. If the username is not in the hashmap, null will be returned through logins.get() and the if statement would be false
            if(passwordField.getText().equals(logins.get(usernameField.getText()))){
                //send correct message including the given username
                loginMessage.setText(usernameField.getText() + ", you are logged in!");
            }else{
                //message for invalid login
                loginMessage.setText("Please enter a valid username/password");
            }
        }
        
    }

    public static void main(String[]args){
        //declare some logins with the format logins.put(username, password)
        logins.put("Darren", "Password");
        logins.put("user1", "password1");
        logins.put("jeyAnandarajan", "StrongPassw0rd");

        //call the constructor method to create the frame
        L9GUIPerformanceTask frame1 = new L9GUIPerformanceTask();

    }
    
}
