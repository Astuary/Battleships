
package battleship;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
	after the player finishes up creating the board,
	the play manager takes control.
	All turn management and keeping track of how many hits registered on the ships
	 and if the match is finished with a winner_id is done here.
	 
	Both player's resources and statistics shared here.
*/

public class PlayManager {
    
    private static int GRID_SIZE = 9;
    private JPanel p2Board; //computer
    private JPanel p1Board; //player
    protected static JButton[][] bArray = new JButton[GRID_SIZE][GRID_SIZE];
    protected static JButton[][] shipCells = new JButton[GRID_SIZE][GRID_SIZE];
    private boolean[][] shipMap = new boolean[GRID_SIZE][GRID_SIZE];
    protected static int[][] oppShipMap;
    private final P2Computer p2;
    private final P1Player p1;
    private boolean turn = true;
    protected static boolean gameOver = false;
    protected static String winner = "YOU LOSE";
    private GameTimer gt;

    public PlayManager(JButton[][] shipCells, boolean[][] shipMap) {
        this.p1 = new P1Player();
        this.p2 = new P2Computer();
        p2Board = MainMenuScreen.oppBoard;
        p1Board = MainMenuScreen.ownBoard;
        p2Board.removeAll();
        p2Board.repaint();
        p2Board.revalidate();
        p1Board.removeAll();
        p1Board.repaint();
        p1Board.revalidate();
        this.shipCells = shipCells;
        this.shipMap = shipMap;
        oppShipMap = p2.getBoard();
        /*for(int row = 0; row < GRID_SIZE; row++){
        for(int col = 0; col < GRID_SIZE; col++){
        System.out.print(oppShipMap[row][col] + " ");
        }
        System.out.println("\n");
        }*/
        MainMenuScreen.jLabel47.setVisible(false);
        MainMenuScreen.jLabel48.setVisible(false);
        MainMenuScreen.jLabel49.setVisible(false);
        MainMenuScreen.jLabel50.setVisible(false);
        MainMenuScreen.jLabel51.setVisible(false);
        setP2Board();
        setP1Board();
        p1.setShipMap();
        startGame();
        gt = new GameTimer();
    }
       
    private void setP2Board(){
        p2Board.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                int i = row, j = col;
                bArray[row][col] = new JButton();
                bArray[row][col].setBackground(Board.cyanShades[0 + (int)(Math.random() * ((Board.cyanShades.length - 1) + 1))]);
                bArray[row][col].addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {          
                        p1.onBombDrop(i, j, bArray[i][j]);
                        p2.checkIfDestroyed(i, j);
                    }
                });
                //if(oppShipMap[row][col] != 0) bArray[row][col].setBackground(Color.RED);
                p2Board.add(bArray[row][col]);
            }
        }
    }
    
    private void setP1Board(){
        p1Board.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                p1Board.add(shipCells[row][col]);
            }
        }
    }

    private void startGame() {
        //give a prompt to tell player its his/her first turn
        
        new Thread(new Runnable() {

        public void run() {
          try {
            
            while(!gameOver){
                Thread.sleep(100);
                if(!p1.getTurn()) {
                    //diasble player's mouse pointer
                    MainMenuScreen.mainGameScreen.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    // TO DO: disable cursor
                    Thread.sleep(2000);
                    //setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    p2.play();
                }
                else{
                    MainMenuScreen.mainGameScreen.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
            
            gameOverCleanUp();
            
          } catch (Exception e) {
            System.out.print(e);
          }
        }
       }).start();
    }

    void gameOverCleanUp() {
        dbHandler.updateMatchShip(p1.getHits());
        gt.resetTimer();
        JFrame jf = (JFrame)SwingUtilities.getWindowAncestor(MainMenuScreen.mainGameScreen);
        jf.dispose();
        GameOver go = new GameOver();
        go.setVisible(true);
    }
    
    void updateShipData(){
        dbHandler.updateMatchShip(p1.getHits());
    }
    
    protected GameTimer getTimer(){
        return gt;
    }
    
}

