package nl.chris;

import javax.swing.*;

public class GameRound extends JPanel {

    public GameTimer gameTimer;
    public WordList wordList;
    public int round = 1;
    public JLabel roundLabel = new JLabel("Round: " + round, SwingConstants.RIGHT);

    public GameRound() {
        // show round placeholder
        add(roundLabel);

        // next round button with getNewWordList() function
        JButton nextRoundButton = new JButton("Next round");
        add(nextRoundButton);
        nextRoundButton.addActionListener(e -> {
            addRound();
            wordList.getNewWordList();
            gameTimer.stopTimer();
            gameTimer.resetTimer();
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        System.out.println("GameRound initialized");
    }

    public void addRound() {
        round++;
        roundLabel.setText("Round: " + round);
    }
}
