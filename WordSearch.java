import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WordSearch extends JFrame implements ActionListener{
    static JLabel mainMessage = new JLabel("");

    public WordSearch(){
        setTitle("Word Search");
        setSize(500, 500);

        GridLayout wordGrid = new GridLayout();
        wordGrid.setColumns(6);
        wordGrid.setRows(6);

        JPanel wordPanel = new JPanel();
        // wordPanel.setSize(100, 100);
        wordPanel.setBounds(0, 0, 100, 100);
        wordPanel.setLayout(wordGrid);

        for(int i = 0; i < 36; i++){
            wordPanel.add(new JLabel("a"));
        }

        Container contentPane = getContentPane();
        contentPane.add(wordPanel);

        //configure settings
        setVisible(true);
        setResizable(false);
        
    }

    public static void main(String[] args){
        WordSearch word = new WordSearch();

    }
    
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

    }
}