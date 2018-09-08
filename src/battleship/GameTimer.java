
package battleship;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
	A timer thread to keep track of how long the match has been played for
*/

public class GameTimer implements Runnable{
    
    private Thread t;
    private boolean stopTimer = false;
    private static int mm = 00;
    private static int ss = 00;
    
    GameTimer(){
        t = new Thread(this, "Timer Thread");
        t.start();
    }
    
    @Override
    public void run(){
        ss = mm = 0;
        while(!stopTimer){
            try{
                MainMenuScreen.timerLabel.setText(String.format("%02d", mm) + ":" + String.format("%02d", ss++));
                if(ss == 60){
                    ss = 0;
                    mm++;
                }
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    protected void setTimer(){
        stopTimer = false;
    }
    
    protected void resetTimer(){
        stopTimer = true;
    }
    
    protected static int getMM(){
        return mm;
    }
    
    protected static int getSS(){
        return ss;
    }
}
