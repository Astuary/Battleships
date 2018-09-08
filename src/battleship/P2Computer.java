
package battleship;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;

/*
	extends abstract Player class to define methods suitable to the computer and its algorithm for the game
*/

public class P2Computer extends Player{
    
    private int[][] shipCells = new int[GRID_SIZE][GRID_SIZE];
    private int[] shipSize = {5, 4, 4, 3, 2};
    protected static int[] shipDamaged = {0, 0, 0, 0, 0};
    private P1Player p = new P1Player();
    private boolean[][] disabledMap = new boolean[GRID_SIZE][GRID_SIZE];
    private Color c;

    public P2Computer() {
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                shipCells[row][col] = 0;
                disabledMap[row][col] = false;
            }
        }
        createBoard();
    }
    
    @Override
    protected void play(){
        
        int i = getRan();
        int j = getRan();
        
        if(disabledMap[i][j]) return;
        //System.out.println("battleship.P2Computer.play()");
        SoundManager.playBombSound("Bomb1.wav");
        if(Arrays.asList(cyanS).contains(PlayManager.shipCells[i][j].getBackground())){
            PlayManager.shipCells[i][j].setBackground(Color.BLACK);
            PlayManager.shipCells[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-window-50.png")));
            disabledMap[i][j] = true;
            turn = false;
            p.turn = true;
            return;
        }
        else{
            c = PlayManager.shipCells[i][j].getBackground();
            if(c.getRed() == 88 && c.getGreen() == 24 && c.getBlue()== 69){
                MainMenuScreen.jProgressBar2.setValue(MainMenuScreen.jProgressBar2.getValue() + 1);
                if(MainMenuScreen.jProgressBar2.getValue() == 5){
                    Player.ownShipsDestroyed++;
                }
            }
            else if(c.getRed() == 144 && c.getGreen() == 12 && c.getBlue()== 63){
                MainMenuScreen.jProgressBar1.setValue(MainMenuScreen.jProgressBar1.getValue() + 1);
                if(MainMenuScreen.jProgressBar1.getValue() == 4){
                    Player.ownShipsDestroyed++;
                }
            }
            else if(c.getRed() == 255 && c.getGreen() == 0 && c.getBlue()== 42){
                MainMenuScreen.jProgressBar4.setValue(MainMenuScreen.jProgressBar4.getValue() + 1);
                if(MainMenuScreen.jProgressBar4.getValue() == 4){
                    Player.ownShipsDestroyed++;
                }
            }
            else if(c.getRed() == 255 && c.getGreen() == 87 && c.getBlue()== 51){
                MainMenuScreen.jProgressBar5.setValue(MainMenuScreen.jProgressBar5.getValue() + 1);
                if(MainMenuScreen.jProgressBar5.getValue() == 3){
                    Player.ownShipsDestroyed++;
                }
            }
            else if(c.getRed() == 255 && c.getGreen() == 255 && c.getBlue()== 0){
                MainMenuScreen.jProgressBar3.setValue(MainMenuScreen.jProgressBar3.getValue() + 1);
                if(MainMenuScreen.jProgressBar3.getValue() == 2){
                    Player.ownShipsDestroyed++;
                }
            }
            PlayManager.shipCells[i][j].setBackground(Color.DARK_GRAY);
            PlayManager.shipCells[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-window-96.png")));
            disabledMap[i][j] = true;
            turn = true;
            p.turn = false;
            
            if(MainMenuScreen.jProgressBar2.getValue() == 5 &&
               MainMenuScreen.jProgressBar1.getValue() == 4 &&
               MainMenuScreen.jProgressBar4.getValue() == 4 &&
               MainMenuScreen.jProgressBar5.getValue() == 3 &&
               MainMenuScreen.jProgressBar3.getValue() == 2){
                PlayManager.gameOver = true;
            }
        }
    }
    
    @Override
    void createBoard(){
        for(int i: shipSize){
            putShip(i);
        }
        
        /*for(int row = 0; row < GRID_SIZE; row++){
        for(int col = 0; col < GRID_SIZE; col++){
        System.out.print(shipCells[row][col] + " ");
        }
        System.out.println("\n");
        }*/
    }
    
    @Override
    int[][] getBoard(){
        return shipCells;
    }
    
    private int getRan(){
        return (0 + (int)(Math.random() * ((GRID_SIZE - 1) + 1)));
    }
    
    void putShip(int size){
        int k = getRan();
        int l = getRan();       
        
        while(shipCells[k][l] != 0){
            k = getRan();
            l = getRan();
        }
        
        if(checkDown(k, l, size)){
            for(int i = k; i < k + size; i++){
                shipCells[i][l] = size;
            }
        }
        else if(checkRight(k, l, size)){
            for(int i = l; i < l + size; i++){
                shipCells[k][i] = size;
            }
        }
        else if(checkUp(k, l, size)){
            for(int i = k; i > k - size; i--){
                shipCells[i][l] = size;
            }
        }
        else if(checkLeft(k, l, size)){
            for(int i = l; i > l - size; i--){
                shipCells[k][i] = size;
            }
        }
        else{
            putShip(size);
        }
    }
    
    boolean checkDown(int k, int l, int size){ 
        if(k + size >= GRID_SIZE) return false;
        for(int i = k; i < k + size; i++){
            if(shipCells[i][l] != 0){
                return false;
            }
        }
        return true;
    }
    
    boolean checkUp(int k, int l, int size){
        if(k - size < 0) return false;
        for(int i = k; i > k - size; i--){
            if(shipCells[i][l] != 0){
                return false;
            }
        }
        return true;
    }
    
    boolean checkRight(int k, int l, int size){ 
        if(l + size >= GRID_SIZE) return false;
        for(int i = l; i < l + size; i++){
            if(shipCells[k][i] != 0){
                return false;
            }
        }
        return true;
    }
    
    boolean checkLeft(int k, int l, int size){ 
        if(l - size < 0) return false;
        for(int i = l; i > l - size; i--){
            if(shipCells[k][i] != 0){
                return false;
            }
        }
        return true;
    }
    
    void onBombDrop(int row, int col, JButton b){
        
    }
    
    protected boolean getTurn(){
        return turn;
    }
    
    protected void checkIfDestroyed(int i, int j){
        switch(shipCells[i][j]){
            case 5:
                shipDamaged[0]++;
                if(shipDamaged[0] == 5) {
                    MainMenuScreen.jLabel51.setVisible(true);
                    Player.oppShipsDestroyed++;
                }
                break;
            case 4:
                if(shipDamaged[1] == 4){
                    shipDamaged[2]++;
                    if(shipDamaged[2] == 4) {
                        MainMenuScreen.jLabel49.setVisible(true);
                        Player.oppShipsDestroyed++;
                    }
                }
                else{
                    shipDamaged[1]++;
                    if(shipDamaged[1] == 4) {
                        MainMenuScreen.jLabel50.setVisible(true);
                        Player.oppShipsDestroyed++;
                    }
                }
                break;
            case 3:
                shipDamaged[3]++;
                if(shipDamaged[3] == 3) {
                    MainMenuScreen.jLabel48.setVisible(true);
                    Player.oppShipsDestroyed++;
                }
                break;
            case 2:
                shipDamaged[4]++;
                if(shipDamaged[4] == 2) {
                    MainMenuScreen.jLabel47.setVisible(true);
                    Player.oppShipsDestroyed++;
                }
                break;
        }
    }
}
