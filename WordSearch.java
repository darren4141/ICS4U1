import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WordSearch extends JFrame implements ActionListener{
    static final int ROWS = 6;
    static final int COLS = 6;
    static final int SCREENWIDTH = 500;
    static final int SCREENHEIGHT = 500;
    static JLabel mainMessage = new JLabel("");
    static JLabel guessPrompt = new JLabel();
    static TextField guessTextField = new TextField();


    public WordSearch(){
        setTitle("Word Search");
        setSize(SCREENWIDTH, SCREENHEIGHT);

        JPanel container = new JPanel();
        BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(containerLayout);
        container.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel verticalFrame1 = new JPanel();
        FlowLayout frame1Layout = new FlowLayout();
        
        frame1Layout.setAlignment(FlowLayout.LEFT);
        
        verticalFrame1.setLayout(frame1Layout);
        verticalFrame1.setMaximumSize(new Dimension(SCREENWIDTH, 210));
        verticalFrame1.setBorder(BorderFactory.createLineBorder(Color.red));
        
        GridLayout wordGridLayout = new GridLayout();
        wordGridLayout.setColumns(COLS);
        wordGridLayout.setRows(ROWS);

        JPanel wordGridPanel = new JPanel();
        wordGridPanel.setPreferredSize(new Dimension(200, 200));
        wordGridPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        wordGridPanel.setLayout(wordGridLayout);

        char[][] wordGrid = fillTwoDArray(ROWS, COLS);

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                JLabel character = new JLabel(Character.toString(wordGrid[i][j]), SwingConstants.CENTER);
                character.setFont(new Font("Sans Serif", Font.BOLD, 34));
                wordGridPanel.add(character);
            }
        }

        verticalFrame1.add(wordGridPanel);

        JPanel verticalFrame2 = new JPanel();
        FlowLayout frame2Layout = new FlowLayout();
        frame2Layout.setAlignment(FlowLayout.LEFT);
        verticalFrame2.setLayout(frame2Layout);
        verticalFrame2.setBorder(BorderFactory.createLineBorder(Color.blue));
        verticalFrame2.setMaximumSize(new Dimension(SCREENWIDTH, 40));
        guessTextField.setColumns(9);
        JButton guessButton = new JButton("Guess!");
        guessButton.addActionListener(this);

        verticalFrame2.add(guessTextField);
        verticalFrame2.add(guessButton);

        JPanel verticalFrame3 = new JPanel();
        FlowLayout frame3Layout = new FlowLayout();
        frame3Layout.setAlignment(FlowLayout.LEFT);
        verticalFrame3.setLayout(frame3Layout);
        verticalFrame3.setBorder(BorderFactory.createLineBorder(Color.green));
        verticalFrame3.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        guessPrompt.setText("Make a guess!");
        verticalFrame3.add(guessPrompt);


        Container contentPane = getContentPane();
        container.add(verticalFrame1);
        container.add(verticalFrame2);
        container.add(verticalFrame3);
        contentPane.add(container);

        //configure settings
        setVisible(true);
        setResizable(true);
        
    }

    public static void main(String[] args){
        WordSearch wordSearch = new WordSearch();
    }
    
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        if(command.equals("Guess!")){
            String guess = guessTextField.getText();
            if(guess.length() < Math.max(ROWS, COLS)){
                
            }else{
                guessPrompt.setText("This word cannot fit in the grid!");
            }
        }

    }

    public static char[][] fillTwoDArray(int rows, int cols){
        char[][] grid = new char[rows][cols];
        int[] letterFrequencies = {43, 11, 23, 17, 57, 9, 13, 15, 38, 1, 6, 28, 15, 34, 37, 16, 1, 39, 29, 35, 19, 5, 7, 1, 9, 1};
        int sumFrequencies = 0;
        for(int f : letterFrequencies){
            sumFrequencies += f;
        }
        char[] letters = new char[sumFrequencies];
        
        int mark = 0;

        for(int i = 0; i < letterFrequencies.length; i++){
            for(int j = 0; j < letterFrequencies[i]; j++){
                letters[mark + j] = (char)(65+i);
            }
            mark += letterFrequencies[i];
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = letters[(int)(Math.random() * sumFrequencies)];
            }
        }
        return grid;
    }
}