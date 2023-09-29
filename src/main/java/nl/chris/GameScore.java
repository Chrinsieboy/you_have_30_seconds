package nl.chris;

import javax.swing.*;

public class GameScore extends JPanel {
    // set variables
    public int score = 0;
    public JLabel scoreLabel = new JLabel("Score: " + score, SwingConstants.RIGHT);

    /**
     * Constructor
     */
    public GameScore() {
        setSize(50, 20);
        add(scoreLabel);
        System.out.println("GameScore initialized");
    }

    /**
     * Add score point
     */
    public void addScorePoint() {
        score++;
        scoreLabel.setText("Score: " + score);
    }

    /**
     * Remove score point
     */
    public void removeScorePoint() {
        score--;
        scoreLabel.setText("Score: " + score);
    }

    /**
     * Reset score
     */
    public void resetScore() {
        score = 0;
        scoreLabel.setText("Score: " + score);
    }

}
