import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WordSearch extends JFrame implements ActionListener{
    static final int ROWS = 6;
    static final int COLS = 6;
    static JLabel mainMessage = new JLabel("");

    public WordSearch(){
        setTitle("Word Search");
        setSize(500, 500);

        FlowLayout containerLayout = new FlowLayout();
        containerLayout.setAlignment(FlowLayout.LEFT);
        GridLayout wordGridLayout = new GridLayout();
        wordGridLayout.setColumns(COLS);
        wordGridLayout.setRows(ROWS);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(containerLayout);

        JPanel wordGridPanel = new JPanel();
        wordGridPanel.setPreferredSize(new Dimension(100, 100));
        wordGridPanel.setLayout(wordGridLayout);

        char[][] wordGrid = fillTwoDArray(ROWS, COLS);

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                wordGridPanel.add(new JLabel(Character.toString(wordGrid[i][j])));
            }
        }

        Container contentPane = getContentPane();
        containerPanel.add(wordGridPanel);
        contentPane.add(containerPanel);

        //configure settings
        setVisible(true);
        setResizable(true);
        
    }

    public static void main(String[] args){
        WordSearch wordSearch = new WordSearch();
    }
    
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

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