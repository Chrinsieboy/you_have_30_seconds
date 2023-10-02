package nl.chris;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    // Instantiate Clip
    protected Clip clip;

    /**
     * Play music
     * @param location - location of music file
     */
    public void PlayMusic(String location) {
        try {
            // Get music file
            File musicPath = new File(location);

            // Check if file exists then play music
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Stop music
     */
    public void StopMusic() {
        try {
            clip.stop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
