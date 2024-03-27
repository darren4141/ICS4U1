package Assignments.WordSearch;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class WordSearch extends JFrame implements ActionListener{
    static final int ROWS = 6;
    static final int COLS = 6;
    static final int SCREENWIDTH = 500;
    static final int SCREENHEIGHT = 500;
    static JLabel mainMessage = new JLabel("");
    static JLabel guessPrompt = new JLabel();
    static TextField guessTextField = new TextField();
    static char[][] wordGrid;
    static String[] words;
    static final int FILELINES = 109582;
    static JPanel wordGridPanel;
    static JPanel verticalFrame2;
    static int[] trackedWordStart = new int[2];
    static int[] trackedWordEnd = new int[2];
    static ArrayList<String> foundWords = new ArrayList<String>();

    public WordSearch(){
        setTitle("Word Search");
        setSize(SCREENWIDTH, SCREENHEIGHT);

        JPanel container = new JPanel();
        BoxLayout containerFrame = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(containerFrame);
        container.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel verticalFrame1 = new JPanel();
        BoxLayout verticalFrame1Layout = new BoxLayout(verticalFrame1, BoxLayout.Y_AXIS);
        verticalFrame1.setMaximumSize(new Dimension(260, SCREENHEIGHT));
        verticalFrame1.setLayout(verticalFrame1Layout);
        verticalFrame1.setBorder(BorderFactory.createLineBorder(Color.orange));

        verticalFrame2 = new JPanel();
        BoxLayout verticalFrame2Layout = new BoxLayout(verticalFrame2, BoxLayout.Y_AXIS);
        verticalFrame2.setMaximumSize(new Dimension(SCREENWIDTH/2, SCREENHEIGHT));
        verticalFrame2.setLayout(verticalFrame2Layout);
        verticalFrame2.setBorder(BorderFactory.createLineBorder(Color.red));
        
        JPanel horizontalFrame1 = new JPanel();
        FlowLayout frame1Layout = new FlowLayout();
        
        frame1Layout.setAlignment(FlowLayout.LEFT);
        
        horizontalFrame1.setLayout(frame1Layout);
        horizontalFrame1.setMaximumSize(new Dimension(SCREENWIDTH, 260));
        horizontalFrame1.setBorder(BorderFactory.createLineBorder(Color.red));
        
        GridLayout wordGridLayout = new GridLayout();
        wordGridLayout.setColumns(COLS);
        wordGridLayout.setRows(ROWS);

        wordGridPanel = new JPanel();
        wordGridPanel.setPreferredSize(new Dimension(250, 250));
        wordGridPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        wordGridPanel.setBackground(new Color(200, 200, 200));
        
        wordGridPanel.setLayout(wordGridLayout);

        wordGrid = fillTwoDArray(ROWS, COLS);

        printWordGrid(false);

        horizontalFrame1.add(wordGridPanel);

        JPanel horizontalFrame2 = new JPanel();
        FlowLayout frame2Layout = new FlowLayout();
        frame2Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame2.setLayout(frame2Layout);
        horizontalFrame2.setBorder(BorderFactory.createLineBorder(Color.blue));
        horizontalFrame2.setMaximumSize(new Dimension(SCREENWIDTH, 40));
        guessTextField.setColumns(9);
        JButton guessButton = new JButton("Guess!");
        guessButton.addActionListener(this);

        horizontalFrame2.add(guessTextField);
        horizontalFrame2.add(guessButton);

        JPanel horizontalFrame3 = new JPanel();
        FlowLayout frame3Layout = new FlowLayout();
        frame3Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame3.setLayout(frame3Layout);
        horizontalFrame3.setBorder(BorderFactory.createLineBorder(Color.green));
        horizontalFrame3.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        guessPrompt.setText("Make a guess!");
        horizontalFrame3.add(guessPrompt);

        
        Container contentPane = getContentPane();
        verticalFrame1.add(horizontalFrame1);
        verticalFrame1.add(horizontalFrame2);
        verticalFrame1.add(horizontalFrame3);
        container.add(verticalFrame1);
        container.add(verticalFrame2);
        contentPane.add(container);
        container.getRootPane().setDefaultButton(guessButton);
        
        //configure settings
        setVisible(true);
        setResizable(true);
        
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        File wordList = new File("Assignments/WordSearch/wordlist.txt");
        Scanner fileReader = new Scanner(wordList);
        words = new String[FILELINES];

        for(int i = 0; i < FILELINES && fileReader.hasNext(); i++){
            words[i] = fileReader.next();
        }

        fileReader.close();

        WordSearch wordSearch = new WordSearch();
    }
    
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        Boolean fileContainsWord = false;

        if(command.equals("Guess!")){
            String guess = guessTextField.getText().toUpperCase();
            guessTextField.setText("");
            fileContainsWord = searchFile(guess, words, 0, FILELINES-1);
            if(guess.length() == 0){
                guessPrompt.setText("Enter a word!");
                guessPrompt.setForeground(Color.black);
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
            }else if(guess.length() == 1){
                guessPrompt.setText("Too short!");
                guessPrompt.setForeground(Color.red);
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
            }else if(guess.length() > Math.max(ROWS, COLS)){
                guessPrompt.setText("Too long!");
                guessPrompt.setForeground(Color.red);
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
            }else if(searchForWord(wordGrid, guess, ROWS, COLS)){
                System.out.println(guess.toLowerCase());
                if(fileContainsWord){
                    guessPrompt.setText("You already entered this!");
                    guessPrompt.setForeground(Color.red);
                    verticalFrame2.removeAll();
                    if(!foundWords.contains(guess)){
                        foundWords.add(guess);
                        guessPrompt.setText("YES, AND IN DICTIONARY");
                        guessPrompt.setForeground(new Color(33, 168, 7));
                    }
                    sortArrayList(foundWords);
                    for(int i = 0; i < foundWords.size(); i++){
                        JLabel word = new JLabel(foundWords.get(i));
                        verticalFrame2.add(word);
                    }
                }else{
                    guessPrompt.setText("YES, NOT IN DICTIONARY");
                    guessPrompt.setForeground(Color.red);
                }
            }else{
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
                guessPrompt.setText("NOT ON THE GRID");
                guessPrompt.setForeground(Color.red);
            }
        }
        printWordGrid(fileContainsWord);
        wordGridPanel.revalidate();
        wordGridPanel.repaint(); 
        verticalFrame2.revalidate();
        verticalFrame2.repaint();
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

    public static boolean searchForWord (char[][] grid, String word, int rows, int cols){
        int [][] possibleDirections = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };

        if(word.length() > Math.max(rows, cols)){
            return false;
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == word.charAt(0)){
                    for(int[]direction : possibleDirections){
                        if(
                            i + direction[0] >= 0 
                            && i + direction[0] < rows 
                            && j + direction[1] >= 0
                            && j + direction[1] < cols
                            && grid[i+direction[0]][j+direction[1]] == word.charAt(1)
                        ){
                            if(sequence(grid, word, rows, cols, direction[0], direction[1], i, j)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean sequence(char[][] grid, String word, int rows, int cols, int xDirection, int yDirection, int x, int y){
        boolean wordIsEqual = true;
        int charactersScanned = 2;
        while (wordIsEqual) {
            if(charactersScanned == word.length()){
                trackedWordStart[0] = x;
                trackedWordStart[1] = y;
                trackedWordEnd[0] = x + xDirection * charactersScanned;
                trackedWordEnd[1] = y + yDirection * charactersScanned;
                return true;
            }else if(
                x + xDirection * charactersScanned >= 0
                && x + xDirection * charactersScanned < rows
                && y + yDirection * charactersScanned >= 0
                && y + yDirection * charactersScanned < cols
                && grid[x + xDirection * charactersScanned][y + yDirection * charactersScanned] == word.charAt(charactersScanned)
                ){
                charactersScanned++;
            }else{
                wordIsEqual = false;
            }
        }
        return wordIsEqual;
    }

    public static boolean searchFile(String word, String[] list, int min, int max){

        word = word.toLowerCase();
        if(max >= min){
            int middle = min + (max - min)/2;
            System.out.println(list[middle]);
            
            if(list[middle].equals(word)){
                return true;
            }

            if(list[middle].compareTo(word) < 0){
                return searchFile(word, list, middle + 1, max);
            }

            if(list[middle].compareTo(word) > 0){
                return searchFile(word, list, min, middle-1);
            }
        }
        return false;
    }

    public void printWordGrid(boolean wordIsGood){
        wordGridPanel.removeAll();
        int dy = trackedWordEnd[1] - trackedWordStart[1];
        int dx = trackedWordEnd[0] - trackedWordStart[0];

        System.out.println(dy + " " + dx);

        int yDirection;
        int xDirection;

        if(dy == 0){
            yDirection = 0;
        }else if(dy < 0){
            yDirection = -1;
        }else{
            yDirection = 1;
        }

        if(dx == 0){
            xDirection = 0;
        }else if(dx < 0){
            xDirection = -1;
        }else{
            xDirection = 1;
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                JLabel character = new JLabel(Character.toString(wordGrid[i][j]), SwingConstants.CENTER);
                character.setFont(new Font("Sans Serif", Font.BOLD, 34));
                character.setBorder(new LineBorder(Color.black, 1));
                for(int c = 0; c < Math.max(Math.abs(dy), Math.abs(dx)); c++){
                    if(i == trackedWordStart[0] + c * xDirection && j == trackedWordStart[1] + c * yDirection){
                        if(wordIsGood){
                            character.setBackground(Color.green);
                        }else{
                            character.setBackground(Color.red);
                        }
                        character.setOpaque(true);
                    }
                }
                wordGridPanel.add(character);
            }
        }
    }
    
    public void sortArrayList(ArrayList<String> list){
        list.sort(Comparator.naturalOrder());

        boolean swapped = true;
        int i = 0;

        while(swapped) {
            swapped = false;
            i++;
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).length() < list.get(j+1).length()) {
                    String temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
        }
    }
}