
package battleship;

import java.awt.Color;
import javax.swing.JButton;

/*
	extends abstract Player class to define methods suitable to the real player and its input to the game
*/

public class P1Player extends Player{
    
    int[][] oppShipMap;
    protected static boolean turn;
    private int count = 0;
    int shipHits[] = new int[5];
    
    public P1Player() {
        /*oppShipMap = getBoard();
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                System.out.print(oppShipMap[row][col] + " ");
            }
            System.out.println("\n");
        }*/
        turn = true;
    }
    
    @Override
    protected void play(){
        
    }
    
    @Override
    int[][] getBoard(){
        return oppShipMap;
    }
    
    protected void setShipMap(){
        oppShipMap = PlayManager.oppShipMap;
        /*for(int row = 0; row < GRID_SIZE; row++){
        for(int col = 0; col < GRID_SIZE; col++){
        System.out.print(oppShipMap[row][col] + " ");
        }
        System.out.println("\n");
        }*/
    }
    
    @Override
    protected void onBombDrop(int row, int col, JButton b){
        if(disabledMap[row][col]) return;
            
        if(oppShipMap[row][col] == 5){
            SoundManager.playBombSound("Bomb2.wav");
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-grid-100.png")));
            b.setBackground(Color.DARK_GRAY);
            disabledMap[row][col] = true;
            turn = true;
            count++;
            shipHits[0]++;
        }
        else if(oppShipMap[row][col] == 4){
            SoundManager.playBombSound("Bomb2.wav");
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-grid-100.png")));
            b.setBackground(Color.DARK_GRAY);
            disabledMap[row][col] = true;
            turn = true;
            count++;
            if(shipHits[1] >=4) shipHits[2]++;
            else shipHits[1]++;
        }
        else if(oppShipMap[row][col] == 3){
            SoundManager.playBombSound("Bomb2.wav");
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-grid-100.png")));
            b.setBackground(Color.DARK_GRAY);
            disabledMap[row][col] = true;
            turn = true;
            count++;
            shipHits[3]++;
        }
        else if(oppShipMap[row][col] == 2){
            SoundManager.playBombSound("Bomb2.wav");
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-grid-100.png")));
            b.setBackground(Color.DARK_GRAY);
            disabledMap[row][col] = true;
            turn = true;
            count++;
            shipHits[4]++;
        }
        else{
            SoundManager.playBombSound("Bomb2.wav");
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-window-50.png")));
            b.setBackground(Color.GRAY);
            disabledMap[row][col] = true;
            turn = false;
        }
        
        if(count == 18) {
            PlayManager.gameOver = true;
            PlayManager.winner = "YOU WIN!";
        }
    }
    
    protected boolean getTurn(){
        return turn;
    }
    
    int[] getHits(){
        return shipHits;
    }
}
