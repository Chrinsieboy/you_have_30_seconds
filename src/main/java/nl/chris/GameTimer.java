package nl.chris;

import javax.swing.*;

public class GameTimer extends JPanel {
    // Import components
    private Music music = new Music();
    private Timer timer;

    // Set variables
    private String startTime = "10";
    private int timerValue = Integer.parseInt(startTime);
    private JLabel timerLabel = new JLabel(startTime, SwingConstants.RIGHT);
    private JLabel timeLeft = new JLabel("Time left:", SwingConstants.RIGHT);

    /**
     * Constructor
     */
    public GameTimer() {
        // add labels
        add(timeLeft);
        add(timerLabel);

        // Create timer
        timer = new Timer(1000, e -> {
            // Check if timer is still running
            if (timerValue > 0) {
                timerValue--;
                timerLabel.setText(String.valueOf(timerValue));
            }
            // If timer is 0 or under 0, play alarm sound and stop timer
            else {
                music.PlayMusic("src/main/resources/alarm_clock.wav");
                timer.stop();

                // Change texts
                timeLeft.setText("Time's up!");
                timerLabel.setVisible(false);
            }
        });

        // Start timer and give error back when failed
        try {
            timer.start();
            System.out.println("GameTimer initialized");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------");
            System.out.println("Error initializing GameTimer");
        }
    }

    /**
     * Stop timer
     */
    public void stopTimer() {
        this.timer.stop();
        System.out.println("Stopped timer manually");
    }

    /**
     * Reset timer
     */
    public void resetTimer() {
        // Reset all values
        startTime = "10";
        timerValue = Integer.parseInt(startTime);
        timerLabel.setVisible(true);
        timeLeft.setText("Time left:");

        // Reset timer
        this.timer.stop();
        this.timer.restart();
        System.out.println("Reset timer manually");
    }
}
