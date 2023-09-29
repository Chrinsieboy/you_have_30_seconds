package nl.chris;

import javax.swing.*;
import java.util.ArrayList;

public class WordList extends JPanel {
    // Import components
    public GameScore gameScore;

    // Arraylist with words
    private ArrayList<Object> words = new ArrayList<>();

    /**
     * Constructor
     */
    public WordList() {
        try {
            getNewWordList();

            // Box layout
            setSize(500, 650);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            System.out.println("WordList initialized");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------");
            System.out.println("Error initializing WordList");
        }
    }

    /**
     * Get new word list
     */
    public void getNewWordList() {
        try {
            // make sure panel is empty
            this.removeAll();
            this.repaint();

            // add words to list
            addWordsToWordList();

            // Get 5 random words from the list
            for (int i = 0; i < 5; i++) {
                int random = (int) (Math.random() * words.size());
                String word = (String) words.get(random);

                // remove all the other words from list
                words.remove(random);

                // add word with checkbox to panel
                JCheckBox checkbox = new JCheckBox(word);
                add(checkbox);
                rightWordCheck(word, checkbox);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("----------");
        }
    }

    /**
     * Add words to word list
     */
    public void addWordsToWordList() {
        words.add("Firetruck");
        words.add("Bicycle");
        words.add("President");
        words.add("Elephant");
        words.add("Pencil");
        words.add("Computer");
        words.add("School");
        words.add("House");
        words.add("Flower");
        words.add("Guitar");
        words.add("Piano");
        words.add("Mouse");
        words.add("HDMI-Adapter");
        words.add("Notebook");
        words.add("Milky way");
        words.add("Mars chocolate");
        words.add("Huib");
        words.add("Right side");
        words.add("V-string");
        words.add("Soccer");
        words.add("Fridge");
        words.add("Coffee");
        words.add("Child predator");
        words.add("Paper");
        words.add("Chair");
        words.add("Chain");
        words.add("Clock");
        words.add("Black buss");
        words.add("Crocs");
        words.add("Platform");
        words.add("Germany");
        words.add("Street");
        words.add("Spain");
        words.add("Smint");
        words.add("Blouse");
        words.add("Glasses");
        words.add("Bread");
        words.add("Banana");
        words.add("Meerkat");
        words.add("Otter");
        words.add("Monopoly");
        words.add("Lamp");
        words.add("Capybara");
        words.add("Sunglasses");
        words.add("Submarine");
        words.add("Ocean gate");
        words.add("Plastic");
        words.add("Sparkling water");
        words.add("Apple");
        words.add("Communist");
        words.add("Timer");
        words.add("Beer");
        words.add("Axolotl");
        words.add("Dopper");
        words.add("Johnny depp");
    }

    /**
     * Check if checkbox of the word is checked
     * @param word String - The word to check
     * @param checkBox JCheckBox - The checkbox to check
     */
    public void rightWordCheck(String word, JCheckBox checkBox) {
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
                System.out.println("Right word guessed: " + word);
                System.out.println("You get 1 point");
                gameScore.addScorePoint();
            } else if (!checkBox.isSelected()) {
                System.out.println("Word not guessed: " + word);
                System.out.println("You lose 1 point");
                gameScore.removeScorePoint();
            }
        });
    }
}
