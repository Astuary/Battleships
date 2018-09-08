
package battleship;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {
    
    private static FloatControl gainControl;
    private static float gain;
    private static float range;
    private static boolean suspendFlag = false;
    static Clip clip;
    static AudioInputStream audioInputStream;

    public static void playButtonSound(final String url) {
        new Thread(new Runnable() {

        public void run() {
          try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
              this.getClass().getResourceAsStream("/sounds/" + url));
            clip.open(inputStream);
            clip.start(); 
          } catch (Exception e) {
            System.out.print(e);
          }
        }
       }).start();
    }
    
    public static void playBombSound(final String url) {
        new Thread(new Runnable() {

        public void run() {
          try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
              this.getClass().getResourceAsStream("/sounds/" + url));
            clip.open(inputStream);
            clip.start(); 
          } catch (Exception e) {
            System.out.print(e);
          }
        }
       }).start();
    }
    
    public static synchronized void bgSoundTrack() {
        
        Thread t = new Thread(new Runnable(){    
            public void run(){
                try {
                    clip = AudioSystem.getClip();
                    audioInputStream = AudioSystem.getAudioInputStream(
                    this.getClass().getResourceAsStream("/sounds/"+"16WeHaveABattleship.wav"));

                    clip.open(audioInputStream);
                    /*gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    range = gainControl.getMaximum() - gainControl.getMinimum();*/
                    clip.loop(0);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
                } /*catch (InterruptedException ex){
                Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
        t.start();
        
        //MainMenuScreen.jSlider1.addChangeListener(new ChangeListener(){
            //@Override
            //public void stateChanged(ChangeEvent e) {
                //try {
                    //t.sleep(1000);
                    //t.wait();
                    /*suspendFlag = true;
                    //System.out.println(".stateChanged()");
                    gain = (range * (MainMenuScreen.jSlider1.getValue() / 100)) + gainControl.getMinimum();
                    gainControl.setValue(gain);
                    suspendFlag = false;
                    //notify();// Reduce volume by 10 decibels.
                /*} catch (InterruptedException ex) {
                Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
                }*///notify();
            //}
        //});
    }
    
    Clip getBGClip(){return clip;}
    AudioInputStream getAIS() {return audioInputStream;}
}
