//====================================================================================================================================================================================================================================================================
//
//"Word Search" Program
//Darren Liu
//March 28th, 2024
//Java 8
//
//====================================================================================================================================================================================================================================================================
//	  
//Problem definition:	Create a 6x6 grid of characters and scan if it contains a word entered by the user, check if the word exists in a dictionary of words
//	  
//Input:            	Guess (text box)
//	                	Button presses:
//	                  	Refresh button
//                      Guess button
//                      Cheat button
//	                      
//Processing:       	Generate or refresh grid of random characters using letter frequency analysis, enforcing a min and max amount of vowels
//                      when a guess is made, check if it exists on the grid
//                      if the guess exists on the grid, check if it exists in the dictionary
//                      find all possible answers on the grid
//	                  
//Output:           	Word grid which updates based on what the user guesses (words will highlight in red or green)
//                      messages that update based on user input (in dicitonary, too short, etc)
//                      list of correct guesses and list of answers
//
//	====================================================================================================================================================================================================================================================================
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
    //the following variables are static as they need to be referred to outside of the constructor method
    static final int ROWS = 6; //declare the number of rows and columns in the word grid
    static final int COLS = 6;

    static final int SCREENWIDTH = 800; //declare the width and height of the screen in pixels
    static final int SCREENHEIGHT = 750;

    static JLabel guessPrompt = new JLabel(); //a JLabel that displays the status of the guess (in the grid, in the list, repeat word, too short, etc)
    static TextField guessTextField = new TextField(); //text field for recieving a guess
    static char[][] wordGrid; //the 2D array of chars to hold the grid of letters
    static String[] words; //a String array of all of the words in the text file
    static final int FILELINES = 109582; //constant int representing the amount of words in the text file

    //all of the static JPanel/JLabel variables are static as they need to be changed outside of the constructor method
    static JPanel wordGridPanel;
    static JPanel horizontalFrame12;
    static JPanel horizontalFrame22;
    static JPanel horizontalFrame23;
    static JPanel horizontalFrame252;
    static JLabel scorePrompt;

    static int totalScore = 0; //int representing total score, starting at 0
    static boolean cheatsOn = false; //boolean representing if cheats are turned on or off

    //two int arrays to store the coordinates of the start and end of the current guess
    static int[] trackedWordStart = new int[2];
    static int[] trackedWordEnd = new int[2];

    static ArrayList<String> foundWords = new ArrayList<String>(); //String arrayList to store the words currently found
    static ArrayList<String> answers = new ArrayList<String>(); //String arrayList to store the auto generated answers

    //Possible directions you can move around a grid spot, represented with x translation and y translation
    static int [][] possibleDirections = {
        {-1, -1}, //top left
        {-1, 0}, //up
        {-1, 1}, //top right
        {0, -1}, //left
        {0, 1}, //right
        {1, -1}, //bottom left
        {1, 0}, //bottom
        {1, 1} //bottom right
    };

    //an array that represents the frequency of the letters relative to one another, based on 10,000 words, ex) for every 43 a's there is 1 z
    //is adjusted more later to cater for a word search
    static int[] letterFrequencies = {43, 11, 23, 17, 57, 9, 13, 15, 38, 1, 6, 28, 15, 34, 37, 16, 1, 39, 29, 35, 19, 5, 7, 1, 9, 1};

    /*
     * Method WordSearch:
     * the following method is a constructor method that is called in the main method
     * 
     * @param: none
     * @return: none
     */
    public WordSearch(){
        setTitle("Word Search"); //title of the window
        setSize(SCREENWIDTH, SCREENHEIGHT); //set the size of the window using the constants

        /*
         * PANEL STRUCTURE:
         * 
         * main panel (size of the entire window) --> container
         * 
         * the main panel holds: 
         * - verticalFrame1
         * - verticalFrame2
         * - verticalFrame25 (2.5)
         * - verticalFrame3
         * 
         * verticalFrame1 holds:
         * - horizontalFrame(0-4), which hold various text fields, letter grids, buttons, labels
         * 
         * verticalFrame2 holds:
         * - labels --> main label (Your Guesses:) and list of guesses
         * 
         * verticalFrame25 holds:
         * - labels --> main label (Score: (score)) and list of scores
         * 
         * verticalFrame3 holds:
         * - labels --> main label (ANSWERS:) and list of answers
         */

        JPanel container = new JPanel(); //main panel
        BoxLayout containerFrame = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(containerFrame);
        // container.setBorder(BorderFactory.createLineBorder(Color.black)); //for debugging

        JPanel verticalFrame1 = new JPanel();
        BoxLayout verticalFrame1Layout = new BoxLayout(verticalFrame1, BoxLayout.Y_AXIS);
        verticalFrame1.setMaximumSize(new Dimension(260, SCREENHEIGHT)); //set the maximum size
        verticalFrame1.setLayout(verticalFrame1Layout);
        // verticalFrame1.setBorder(BorderFactory.createLineBorder(Color.orange)); //for debugging

        JPanel verticalFrame2 = new JPanel();
        BoxLayout verticalFrame2Layout = new BoxLayout(verticalFrame2, BoxLayout.Y_AXIS);
        verticalFrame2.setMaximumSize(new Dimension(150, SCREENHEIGHT)); //set the maximum size
        verticalFrame2.setLayout(verticalFrame2Layout);
        // verticalFrame2.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging

        JPanel verticalFrame25 = new JPanel();
        BoxLayout verticalFrame25Layout = new BoxLayout(verticalFrame25, BoxLayout.Y_AXIS);
        verticalFrame25.setMaximumSize(new Dimension(150, SCREENHEIGHT)); //set the maximum size
        verticalFrame25.setLayout(verticalFrame25Layout);
        // verticalFrame25.setBorder(BorderFactory.createLineBorder(Color.blue)); //for debugging

        JPanel horizontalFrame0 = new JPanel();
        FlowLayout frame0Layout = new FlowLayout();
        frame0Layout.setAlignment(FlowLayout.LEFT); //align elements to the left
        horizontalFrame0.setLayout(frame0Layout);
        horizontalFrame0.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        JLabel mainMessage = new JLabel("Search for Words! "); //set the main message at the top
        mainMessage.setFont(new Font("Sans Serif", Font.BOLD, 18)); //set the preferred font elements
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this); //allow the button to do things on press by adding an action listener
        horizontalFrame0.add(mainMessage);
        horizontalFrame0.add(refreshButton);
        
        JPanel horizontalFrame1 = new JPanel();
        FlowLayout frame1Layout = new FlowLayout();
        
        frame1Layout.setAlignment(FlowLayout.LEFT); //align elements to the left
        
        horizontalFrame1.setLayout(frame1Layout);
        horizontalFrame1.setMaximumSize(new Dimension(SCREENWIDTH, 260));
        // horizontalFrame1.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        
        GridLayout wordGridLayout = new GridLayout(ROWS, COLS); //set the number of rows and columns for the grid layout

        wordGridPanel = new JPanel();
        wordGridPanel.setPreferredSize(new Dimension(250, 250));
        wordGridPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2)); //set the border thickness of the word grid
        wordGridPanel.setBackground(new Color(200, 200, 200)); //set the background colour of the word grid
        
        wordGridPanel.setLayout(wordGridLayout);

        wordGrid = fillTwoDArray(ROWS, COLS); //fill the word grid char array using the fillTwoDArray method

        printWordGrid(false); //print the grid on the GUI

        horizontalFrame1.add(wordGridPanel);

        JPanel horizontalFrame2 = new JPanel();
        FlowLayout frame2Layout = new FlowLayout();
        frame2Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame2.setLayout(frame2Layout);
        // horizontalFrame2.setBorder(BorderFactory.createLineBorder(Color.blue)); //for debugging
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
        // horizontalFrame3.setBorder(BorderFactory.createLineBorder(Color.green));
        horizontalFrame3.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        guessPrompt.setText("Make a guess!");
        guessPrompt.setFont(new Font("Sans Serif", Font.BOLD, 18));
        horizontalFrame3.add(guessPrompt);

        JPanel horizontalFrame4 = new JPanel();
        FlowLayout frame4Layout = new FlowLayout();
        frame4Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame4.setLayout(frame4Layout);
        horizontalFrame3.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        JButton cheatButton = new JButton("Cheat!");
        cheatButton.addActionListener(this);
        horizontalFrame4.add(cheatButton);

        JPanel horizontalFrame11 = new JPanel();
        FlowLayout frame11Layout = new FlowLayout();
        frame11Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame11.setLayout(frame11Layout);
        horizontalFrame11.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        JLabel answersPrompt = new JLabel("Your Guesses:");
        answersPrompt.setFont(new Font("Sans Serif", Font.BOLD, 18));
        horizontalFrame11.add(answersPrompt);

        JPanel horizontalFrame251 = new JPanel();
        FlowLayout frame251Layout = new FlowLayout();
        frame251Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame251.setLayout(frame251Layout);
        horizontalFrame251.setMaximumSize(new Dimension(SCREENWIDTH, 30));
        scorePrompt = new JLabel("Score: " + totalScore);
        scorePrompt.setFont(new Font("Sans Serif", Font.BOLD, 20));
        answersPrompt.setFont(new Font("Sans Serif", Font.BOLD, 20));
        horizontalFrame251.add(scorePrompt);

        horizontalFrame12 = new JPanel();
        GridLayout horizontalFrame12Layout = new GridLayout(10000, 1); //use a grid layout with 10000 rows and 1 column to imitate a Y-AXIS box layout amd allow for left alignment
        horizontalFrame12.setLayout(horizontalFrame12Layout);

        horizontalFrame252 = new JPanel();
        GridLayout horizontalFrame252Layout = new GridLayout(10000, 1);
        horizontalFrame252.setLayout(horizontalFrame252Layout);

        JPanel verticalFrame3 = new JPanel();
        GridLayout verticalFrame3Layout = new GridLayout(1, 1);
        verticalFrame3.setMaximumSize(new Dimension(260, SCREENHEIGHT));
        verticalFrame3.setLayout(verticalFrame3Layout);
        // verticalFrame3.setBorder(BorderFactory.createLineBorder(Color.green)); //for debugging

        horizontalFrame22 = new JPanel();
        BoxLayout horizontalFrame22Layout = new BoxLayout(horizontalFrame22, BoxLayout.Y_AXIS);
        horizontalFrame22.setMaximumSize(new Dimension(130, SCREENHEIGHT));
        horizontalFrame22.setLayout(horizontalFrame22Layout);
        // horizontalFrame22.setBorder(BorderFactory.createLineBorder(Color.black)); //for debugging

        horizontalFrame23 = new JPanel();
        BoxLayout horizontalFrame23Layout = new BoxLayout(horizontalFrame23, BoxLayout.Y_AXIS);
        horizontalFrame23.setMaximumSize(new Dimension(130, SCREENHEIGHT));
        horizontalFrame23.setLayout(horizontalFrame23Layout);
        // horizontalFrame23.setBorder(BorderFactory.createLineBorder(Color.black)); //for debugging

        answers = findAnswers(wordGrid); //populate the arraylist answers using the find answers method

        //an option pane that will pop up before the program runs explaining the rules and how the game works
        JOptionPane.showMessageDialog(this, 
        "Welcome to the Word Search program! Here are some rules:" + 
        "\n1. Words must be at least 2 characters" +
        "\n2. Words can be found horizontally, vertically, diagonally, backwards and forwards (8 directions in total)" +
        "\n3. Repeats will not count" +
        "\n3. Scoring is based on both the length of the word, and how rare the letters are (z is more points!)" + 
        "\n4. Answer key can be used as a last resort or if you hate fun!" + 
        "\n5. HAVE FUN"); 

        Container contentPane = getContentPane(); //main container

        //configure layout
        verticalFrame1.add(horizontalFrame0);
        verticalFrame1.add(horizontalFrame1);
        verticalFrame1.add(horizontalFrame2);
        verticalFrame1.add(horizontalFrame3);
        verticalFrame1.add(horizontalFrame4);
        verticalFrame2.add(horizontalFrame11);
        verticalFrame2.add(horizontalFrame12);
        verticalFrame25.add(horizontalFrame251);
        verticalFrame25.add(horizontalFrame252);
        verticalFrame3.add(horizontalFrame22);
        verticalFrame3.add(horizontalFrame23);
        container.add(verticalFrame1);
        container.add(verticalFrame2);
        container.add(verticalFrame25);
        container.add(verticalFrame3);
        contentPane.add(container);

        //setDefaultButton makes the guessButton the default button, meaning it will press when enter is pressed
        container.getRootPane().setDefaultButton(guessButton);
        
        //configure settings
        setVisible(true);
        setResizable(true);
        
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        File wordList = new File("Assignments/WordSearch/wordlist.txt"); //declare a new file of the wordlist
        Scanner fileReader = new Scanner(wordList); //create a Scanner that reads from the file
        words = new String[FILELINES]; //assign the String array words to have a size of the number of words in the file

        //iterate through the file and populate the array with the words in the text file
        for(int i = 0; i < FILELINES && fileReader.hasNext(); i++){
            words[i] = fileReader.next();
        }

        fileReader.close();

        //modify the letterFrequencies array to make the differences less drastic
        for(int i = 0; i < letterFrequencies.length; i++){
            letterFrequencies[i] -= ((letterFrequencies[i]-1) * (letterFrequencies[i]-1)) * 0.005; //subtract the value of letterFrequencies squared so that larger values have more subtracted from them
            letterFrequencies[i] *= 0.3; //multiply by 0.3 across the board
            letterFrequencies[i]++; //increment once so there are no 0's
        }

        WordSearch wordSearch = new WordSearch(); //call the constructor method
    }
    
    /*
     * actionPerforemed method that will run whenever a button is pressed
     * 
     * @param: ActionEvent event --> an ActionEvent type object that represents the action that took place
     */
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand(); //extract the String value of the ActionEvent object
        Boolean fileContainsWord = false; //boolean to represent if the file contains selected word

        if(command.equals("Guess!")){ //if the "Guess!" button is pressed
            String guess = guessTextField.getText().toUpperCase(); //assign the text in the textfield to a String, making it all uppercase
            guessTextField.setText(""); //empty the text field after reading the value
            fileContainsWord = searchFile(guess, words, 0, FILELINES-1); //boolean fileContainsWord is assigned to return of the method searching the file
            if(guess.length() == 0){ //if guess is null
                guessPrompt.setText("Enter a word!"); //update guess prompt
                guessPrompt.setForeground(Color.black);
                //empty tracked word
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
            }else if(guess.length() == 1){ //if guess is too short
                guessPrompt.setText("Too short!");//update guess prompt
                guessPrompt.setForeground(Color.red);
                //empty tracked word
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
            }else if(guess.length() > Math.max(ROWS, COLS)){//if guess is too long
                guessPrompt.setText("Too long!");//update guess prompt
                guessPrompt.setForeground(Color.red);
                //empty tracked word
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
            }else if(searchForWord(wordGrid, guess, ROWS, COLS)){//is the word on the grid?
                // System.out.println(guess.toLowerCase()); //for debugging
                if(fileContainsWord){//if the word is in the file
                    guessPrompt.setText("You already entered this!"); //update prompt
                    guessPrompt.setForeground(Color.red);
                    if(!foundWords.contains(guess)){ //if the word has not already been guessed
                        //clear frames
                        horizontalFrame12.removeAll();
                        horizontalFrame252.removeAll();
                        foundWords.add(guess); //add new word to arraylist
                        sortArrayList(foundWords); //sort the arraylist based on length first, then alphabetically
                        guessPrompt.setText("YES GRID, YES DICTIONARY"); //update prompt
                        guessPrompt.setForeground(new Color(33, 168, 7)); //update prompt color

                        int score = 0; //declare int score as 0

                        /*
                         * the scoring system is based on two things:
                         * - the length of the character --> "score *= guess.length();"
                         * - the "rarity" of the letters --> for loop
                         */
                        for(int j = 0; j < guess.length(); j++){//iterate through the letters in the word
                            score += (30 - letterFrequencies[(int)guess.charAt(j)-65]) * 1.5; //assign a numerical value based on how infrequent the letter is
                        }

                        score *= guess.length(); //multiply the score by the length 

                        totalScore += score; //sum the total score

                        //iterate through the found words
                        for(int i = 0; i < foundWords.size(); i++){

                            //recalculate the score
                            int thisScore = 0;
                            for(int j = 0; j < foundWords.get(i).length(); j++){
                                thisScore += (30 - letterFrequencies[(int)foundWords.get(i).charAt(j)-65]) * 1.5;
                            }
                            thisScore *= foundWords.get(i).length();

                            //declare labels for score and word
                            JLabel scoreLabel = new JLabel(Integer.toString(thisScore));
                            JLabel word = new JLabel(foundWords.get(i));
                            word.setFont(new Font("Sans-Serif", Font.BOLD ,15));
                            scoreLabel.setFont(new Font("Sans-Serif", Font.BOLD ,15));
                            scoreLabel.setHorizontalAlignment(SwingConstants.LEFT); //align score and word to the left
                            word.setHorizontalAlignment(SwingConstants.LEFT);

                            //add elements to their respective panels
                            horizontalFrame12.add(word);
                            horizontalFrame252.add(scoreLabel);
                        }
                    }
                    scorePrompt.setText("Score: " + totalScore); //update text for total score
                }else{
                    guessPrompt.setText("YES GRID, NO DICTIONARY"); //if word is on the grid
                    guessPrompt.setForeground(Color.red);
                }
            }else{

                if(fileContainsWord){
                    guessPrompt.setText("NO GRID, YES DICTIONARY");
                }else{
                    guessPrompt.setText("NO GRID, NO DICTIONARY");
                }

                //reset tracked word
                trackedWordStart[0] = 0;
                trackedWordStart[1] = 0;
                trackedWordEnd[0] = 0;
                trackedWordEnd[1] = 0;
                guessPrompt.setForeground(Color.red);
            }

            //reprint the word grid
            printWordGrid(fileContainsWord);
        }

        if(command.equals("Refresh")){ //if the refresh button is hit
            guessPrompt.setText("Enter a word!"); //update text
            guessPrompt.setForeground(Color.black);

            wordGrid = fillTwoDArray(ROWS, COLS); //populate the char array with new letters
            foundWords.clear(); //clear found words
            horizontalFrame12.removeAll(); //clear displays
            horizontalFrame252.removeAll();
            trackedWordStart[0] = 0; //reset tracked word
            trackedWordStart[1] = 0;
            trackedWordEnd[0] = 0;
            trackedWordEnd[1] = 0;
            totalScore = 0; //reset score
            scorePrompt.setText("Score: " + totalScore);
            answers.clear(); //empty answers arraylist
            answers = findAnswers(wordGrid); //repopulate answers
            horizontalFrame22.removeAll(); //clear displays
            horizontalFrame23.removeAll();
            if(cheatsOn){ //if cheats are on, show the answers
                displayAnswer();
            }

            //revalidate and repaint all affected panels
            wordGridPanel.revalidate();
            wordGridPanel.repaint(); 
            horizontalFrame12.revalidate();
            horizontalFrame12.repaint();
            horizontalFrame252.revalidate();
            horizontalFrame252.repaint();
            horizontalFrame22.revalidate();
            horizontalFrame22.repaint();
            horizontalFrame23.revalidate();
            horizontalFrame23.repaint();
            printWordGrid(fileContainsWord); //reprint word grid
        }

        if(command.equals("Cheat!")){ //if cheat button is pressed
            if(cheatsOn){
                hideAnswer(); //display the answer tab
            }else{
                displayAnswer(); //hide the answer tab
            }
            cheatsOn = !cheatsOn; //toggle the boolean
        }

        //revalidate and repaint all affected panels
        wordGridPanel.revalidate();
        wordGridPanel.repaint(); 
        horizontalFrame12.revalidate();
        horizontalFrame12.repaint();
        horizontalFrame252.revalidate();
        horizontalFrame252.repaint();
    }

    /*
     * Method fillTwoDArray: the purpose of this method is to fill a 2D array with char type variables using letter frequency analysis as well as a min/max cap on vowels
     * 
     * @param --> int rows, cols: the number of rows and columns in the 2D array
     * @return --> char[][] --> the filled 2D array
     */
    public static char[][] fillTwoDArray(int rows, int cols){

        //declare a counter for the number of vowels and consonants, start at 0
        int vowelCount = 0;
        int consonantCount = 0;

        //declare a new char array representing the grid
        char[][] grid = new char[rows][cols];

        /*
         * HOW DOES THE FREQUENCY ANALYSIS WORK?
         * 
         * 1. make an array letterFrequencies with size 26 which has the relative frequencies of each letter
         * 2. fill a new array letters with the size of all of the sums of the frequencies, fill the array with n amount of letter x: ex 26 a's, 12 b's, ... 2 z's
         * 3. fill the word grid with a random element from array letters
         */
        int sumFrequencies = 0;
        for(int f : letterFrequencies){ //iterate through letterFrequencies
            sumFrequencies += f; //sum the contents of letterFrequencies
        }
        char[] letters = new char[sumFrequencies]; //declare a new char array with the size of sumFrequencies
        
        //variable to tell where we are in the process of filling the letters array
        int mark = 0;

        //iterate through each element in letterFrequencies
        for(int i = 0; i < letterFrequencies.length; i++){
            for(int j = 0; j < letterFrequencies[i]; j++){//add letter[j], letterfrequencies[i] times
                letters[mark + j] = (char)(65+i);
            }
            mark += letterFrequencies[i]; //increment mark so that on the next pass we add onto higher indicies
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){//loop through array
                boolean isVowel = false; //assume character is a vowel
                boolean inBounds = false; //assume character is within the bounds of the array (indicies 0-5)
                int randCharIndex = (int)(Math.random() * sumFrequencies); //find a random index

                //if the letter is vowel
                if(letters[randCharIndex] == 'A' || letters[randCharIndex] == 'E' || letters[randCharIndex] == 'I' || letters[randCharIndex] == 'O' || letters[randCharIndex] == 'U'){
                    vowelCount++;
                    isVowel = true;
                }else{
                    consonantCount++;
                }

                //while loop to rerun if we need to regenerate letters
                while(!inBounds){
                    if(isVowel){       
                        if(vowelCount < 12){
                            grid[i][j] = letters[randCharIndex]; //assign value
                            inBounds = true;
                        }else{ //if we have too many vowels, generate a new character
                            vowelCount--;
                            randCharIndex = (int)(Math.random() * sumFrequencies);
                        }      
                    }else if(!isVowel){
                        if(consonantCount < 27){
                            grid[i][j] = letters[randCharIndex]; //assign value
                            inBounds = true;
                        }else{ //if we have too many consonants, generate a new character
                            consonantCount--;
                            randCharIndex = (int)(Math.random() * sumFrequencies);
                        }
                    }
                }
            }
        }

        //SCRAMBLE THE GRID SINCE WITH THESE LIMITATIONS, THERE MAY BE MORE VOWELS AT THE TOP THAN BOTTOM
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int randX = (int)Math.random() * rows; //generate random index
                int randY = (int)Math.random() * cols;

                //swap with random index
                char temp = grid[i][j];
                grid[i][j] = grid[randX][randY];
                grid[randX][randY] = temp;
            }
        }
        return grid;
    }

    /*
     * Method searchForWord is a method that searches for a given word within the char grid
     * 
     * @param:
     * - char[][]grid: the grid that holds the characters
     * - String word: the word to search for
     * - int rows, cols: the dimensions of the grid
     * 
     * @return: boolean searchForWord --> if the word is in the grid or not
     */
    public static boolean searchForWord (char[][] grid, String word, int rows, int cols){

        //if the word exceeds maximum length
        if(word.length() > Math.max(rows, cols)){
            return false;
        }

        //iterate through the grid elements
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == word.charAt(0)){ //if the element in the grid matches the first letter in the word
                    for(int[]direction : possibleDirections){ //check every possible direction around the first letter
                        if(
                            i + direction[0] >= 0 
                            && i + direction[0] < rows 
                            && j + direction[1] >= 0
                            && j + direction[1] < cols
                            && grid[i+direction[0]][j+direction[1]] == word.charAt(1)
                        ){//if the direction is in bounds (not a corner or edge) and the second character is equal to the second character in the word
                            if(sequence(grid, word, rows, cols, direction[0], direction[1], i, j)){ //run the method sequence which will keep searching in the same direction and return true or false
                                return true; //return true if the word is in the grid (decided by sequence)
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /*
     * method sequence is meant to be a continuation of the searchForWord method and serves the same purpose
     * 
     * @param:
     * - char[][]grid: the grid that holds the characters
     * - String word: the word to search for
     * - int rows, cols: the dimensions of the grid
     * - int xDirection, yDirection: the direction of the search, decided in the searchForWord method before this method is called
     * - int x, y: the starting position in the grid
     */
    public static boolean sequence(char[][] grid, String word, int rows, int cols, int xDirection, int yDirection, int x, int y){
        boolean wordIsEqual = true; //word is equal to begin with --> first two characters
        int charactersScanned = 2; //we already checked 2 characters
        while (wordIsEqual) {
            if(charactersScanned == word.length()){ //if our current word is good and the length matches, we are done
                //log the tracked word values
                trackedWordStart[0] = x;
                trackedWordStart[1] = y;
                trackedWordEnd[0] = x + xDirection * charactersScanned;
                trackedWordEnd[1] = y + yDirection * charactersScanned;
                return true;
            }else if(//if we need to keep searching
            //check that we don't go out of bounds
                x + xDirection * charactersScanned >= 0
                && x + xDirection * charactersScanned < rows
                && y + yDirection * charactersScanned >= 0
                && y + yDirection * charactersScanned < cols
                && grid[x + xDirection * charactersScanned][y + yDirection * charactersScanned] == word.charAt(charactersScanned) //check if the current character is equal to the nth element in the array
                ){
                charactersScanned++; //increment charactersScanned
            }else{
                wordIsEqual = false; 
            }
        }
        return wordIsEqual;
    }

    /*
     * method searchFile searches the text file for the given input word using recursive binary search
     * 
     * @param:
     * - String word: the word we are searching for
     * - String[] list: the list of words in the text file
     * - int min, max: the min and max to be used in binary search
     * 
     * @return:
     * - boolean --> if the word is in the file or not
     */
    public static boolean searchFile(String word, String[] list, int min, int max){

        word = word.toLowerCase();
        if(max >= min){//if this isn't true, we can return false
            int middle = min + (max - min)/2;//find the middle element
            if(list[middle].equals(word)){//base case
                return true;
            }

            if(list[middle].compareTo(word) < 0){ //if word is greater than middle, repeat search on top half
                return searchFile(word, list, middle + 1, max);
            }

            if(list[middle].compareTo(word) > 0){ //if word is less than middle, repeat search on bottom half
                return searchFile(word, list, min, middle-1);
            }
        }
        return false;
    }

    /*
     * method printWordGrid is meant to reprint the grid of characters and include any special highlighting rules
     * 
     * @param: boolean wordIsGood --> if the word is in the list or not
     * @return: void
     */
    public void printWordGrid(boolean wordIsGood){
        wordGridPanel.removeAll();

        //calculate the x and y length of the word
        int dy = trackedWordEnd[1] - trackedWordStart[1];
        int dx = trackedWordEnd[0] - trackedWordStart[0];

        int yDirection;
        int xDirection;

        //find the x and y directions based on dy and dx
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

        //iterate through the grid
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                JLabel character = new JLabel(Character.toString(wordGrid[i][j]), SwingConstants.CENTER);
                character.setFont(new Font("Sans Serif", Font.BOLD, 32));
                character.setBorder(new LineBorder(Color.black, 1));

                //iterate through the characters we should highlight
                for(int c = 0; c < Math.max(Math.abs(dy), Math.abs(dx)); c++){
                    //if the character is one of the ones we should highlight
                    if(i == trackedWordStart[0] + c * xDirection && j == trackedWordStart[1] + c * yDirection){
                        //set background colour depending on if the word is in the list or not
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
    
    /*
     * Method displayAnswer: this method is made to display the answer key
     * @return: void
     */
    public static void displayAnswer(){
        JLabel answerTitle = new JLabel("ANSWERS:");
        answerTitle.setFont(new Font("Sans-Serif", Font.BOLD ,15));
        JLabel fillerTitle = new JLabel(" ");
        fillerTitle.setFont(new Font("Sans-Serif", Font.BOLD ,15));
        horizontalFrame22.add(answerTitle);
        horizontalFrame23.add(fillerTitle);
        System.out.println(answers);
        //iterate through the answers, printing them two at a time
        for(int i = 0; i < answers.size(); i+=2){
            horizontalFrame22.add(new JLabel(answers.get(i), SwingConstants.LEFT));
            if(i+1 < answers.size()){//if the second one exceeds the length, don't print it
                horizontalFrame23.add(new JLabel(answers.get(i+1), SwingConstants.LEFT));
            }
        }
    }

    /*
     * Method hideAnswer: method meant to hide the answer key
     * @return: none
     */
    public static void hideAnswer(){
        //remove all elements from panels
        horizontalFrame22.removeAll();
        horizontalFrame23.removeAll();
    }

    /*
     * Method sortArrayList: sort an arraylist of strings based on length first, then alphabetically
     * 
     * @param: ArrayList<String> list --> the arraylist to be sorted
     */
    public static void sortArrayList(ArrayList<String> list){
        //sort alphabetiacally first
        list.sort(Comparator.naturalOrder());

        //run bubble sort, which we can use since we are only using this on the arraylist of answers which will realistacally never exceed 1000 on a 6x6 grid
        //bubble sort works since it is a stable sorting method and maintians the relative order of elements with the same length

        //bubble sort code
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

    /*
     * Method findAnswers: this method is meant to find all the possible answers to the word search
     * 
     * @param: char[][]grid --> the grid to be searched for answers
     * @return: ArrayList<String> --> an arrayList with all of the answers
     */
    public static ArrayList<String> findAnswers(char[][] grid){
        ArrayList<String> answers = new ArrayList<String>();

        //iterate through each element
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                for(int[] direction : possibleDirections){//iterate through directions
                    String word = ""; //start with an empty word
                    int counter = 0;
                    while(                            
                        i + direction[0] * counter >= 0 
                        && i + direction[0] * counter < ROWS 
                        && j + direction[1] * counter >= 0
                        && j + direction[1] * counter < COLS
                        ){//while we are not leaving the bounds of the array
                        // System.out.println(word); //for debugging
                        word += String.valueOf(grid[i + direction[0] * counter][j + direction[1] * counter]); //concatenate the word with the current letter
                        if(searchFile(word.toLowerCase(), words, 0, FILELINES)){ //check if the concatenated word is in the file
                            if(!answers.contains(word) && word.length() > 1){// if it is and it's unique and it is not a single character,
                                answers.add(word); //add the word
                            }
                        }
                        counter++; //increment counter
                    }
                }
            }
        }
        sortArrayList(answers); //sort the arrayList of answers
        return answers;
    }
}//end of class