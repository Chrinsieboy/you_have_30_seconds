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
        checkRound();
    }

    /**
     * Check if round is 6, if so, show dialog with score and ask if player wants to play again
     */
    public void checkRound() {
        if (round == 6) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "You have finished the game!\nYour score is: " + wordList.gameScore.score + "\nDo you want to play again?", "Game finished", dialogButton);

            // if yes, reset score and round
            if (dialogResult == JOptionPane.YES_OPTION) {
                wordList.gameScore.resetScore();
                round = 1;
                roundLabel.setText("Round: " + round);
            }

            // if no, exit game
            else {
                System.exit(0);
            }
        }
    }
}
