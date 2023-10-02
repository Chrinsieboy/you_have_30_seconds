package nl.chris;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    // Import components
    public WordList wordList = new WordList();
    public GameScore gameScore = new GameScore();
    public GameTimer gameTimer = new GameTimer();
    public GameRound gameRound = new GameRound();

    /**
     * Constructor for GameScreen
     */
    public GameScreen() {
        // Set title
        super("You have 30 seconds!");
        try {
            // Add components
            add(wordList);
            add(gameScore);
            add(gameTimer);
            add(gameRound);
            wordList.gameScore = gameScore;
            gameRound.wordList = wordList;
            gameRound.gameTimer = gameTimer;

            // Set last settings
            setSize(500, 300);

            // set layout
            setLayout(new GridLayout(2, 2));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------");
            System.out.println("Error initializing GameScreen");
        }
    }
}
