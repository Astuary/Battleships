
package battleship;

import java.awt.Color;
import javax.swing.JButton;

abstract public class Player {
    protected static int oppShipsDestroyed = 0;
    protected static int ownShipsDestroyed = 0;
    protected boolean turn = false;
    protected static final int GRID_SIZE = 9;
    protected boolean[][] disabledMap = new boolean[GRID_SIZE][GRID_SIZE];
    protected static Color cyanS[] = Board.cyanShades;
    
    Player(){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                disabledMap[i][j] = false;
            }
        }
    }
    
    abstract protected void play();
    void createBoard(){}
    abstract int[][] getBoard();
    abstract void onBombDrop(int row, int col, JButton b);
    abstract protected boolean getTurn();
}
