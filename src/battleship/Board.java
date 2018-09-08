
package battleship;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/*
	The player will create its board which will be the play area for computer.
	All board characteristics here.
	Must check if a ship doesn't ovelap another,
	  or a ship is in bounds of the board,
	  or a ship is not in diagonal position.
*/

public class Board{
    
    private static final int GRID_SIZE = 9;
    private final JButton[][] tlCells = new JButton[GRID_SIZE][GRID_SIZE];
    private boolean[][] tlCellsEnable = new boolean[GRID_SIZE][GRID_SIZE];
    private boolean[][] tlCellsClicks = new boolean[GRID_SIZE][GRID_SIZE];
    private boolean[][] ShipMap = new boolean[GRID_SIZE][GRID_SIZE];
    protected static Color[] cyanShades = {new Color(0, 183, 235), new Color(0, 255, 255), new Color(201, 255, 229), new Color(127, 255, 212),
                                        new Color(13, 152, 186), new Color(0, 109, 111), new Color(178, 255, 255), new Color(0, 123, 167),
                                        new Color(0, 139, 139), new Color(125, 249, 255), new Color(17, 100, 180), new Color(224, 255, 255)};
    private JButton ship5, ship4_1, ship4_2, ship3, ship2;
    private boolean setShip5, setShip4_1, setShip4_2, setShip3, setShip2;
    private final JPanel boardPanel;
    private static Color selectionColor = Color.WHITE;
    private static int boatSize;
    private static boolean onBoard;
    private static int startX, startY;
    private JPanel readyPanel;
    private JLabel readyMessage;
    protected PlayManager pm;
    
    Board(JPanel bPanel) {
        boardPanel = bPanel;
        onBoard = false;
        setShip5 = false;
        setShip4_1 = false;
        setShip4_2 = false;
        setShip3 = false;
        setShip2 = false;
        boardPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));  // 9x9 GridLayout
 
      // Allocate a common listener as the ActionEvent listener for all the
      //  JTextFields
      // ... [TODO 3] (Later) ....
 
      // Construct 9x9 JTextFields and add to the content-pane
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
             
            int r = row, c = col;
            
            int i = (0 + (int)(Math.random() * ((cyanShades.length - 1) + 1)));
             
            tlCells[row][col] = new JButton(); // Allocate element of array
            tlCellsEnable[row][col] = true;
            tlCellsClicks[row][col] = true;   // true = not clicked yet, 0 clicks
            ShipMap[row][col] = false;
            
            tlCells[row][col].addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {                  
                    if(tlCellsEnable[r][c] && selectionColor != Color.WHITE) tlMouseClicked(e, tlCells[r][c], r, c);
                } 
            } );
            
            //Border border = BorderFactory.createLineBorder(cyanShades[i], 1);
            Border border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
            tlCells[row][col].setBorder(border);
            
            tlCells[row][col].setBackground(cyanShades[i]);

            boardPanel.add(tlCells[row][col]);            // ContentPane adds JTextField
            //tlCells[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png")));     // set to empty string
         }
      }
      
      initButtons();
      initReady();
      readyMessage.setText("");
    } 

    private void initButtons() {
        ship5 = MainMenuScreen.getShip5();
        ship4_1 = MainMenuScreen.getShip4_1();
        ship4_2 = MainMenuScreen.getShip4_2();
        ship3 = MainMenuScreen.getShip3();
        ship2 = MainMenuScreen.getShip2();
        
        ship5.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    selectionColor = ship5.getBackground();
                    boatSize = 5;
                    ship5.setBorder(new LineBorder(Color.BLACK, 3));
                    ship4_1.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_2.setBorder(new EmptyBorder(0,0,0,0));
                    ship3.setBorder(new EmptyBorder(0,0,0,0));
                    ship2.setBorder(new EmptyBorder(0,0,0,0));
                } 
            } );
        
        ship4_1.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    selectionColor = ship4_1.getBackground();
                    boatSize = 4;
                    ship5.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_1.setBorder(new LineBorder(Color.BLACK, 3));
                    ship4_2.setBorder(new EmptyBorder(0,0,0,0));
                    ship3.setBorder(new EmptyBorder(0,0,0,0));
                    ship2.setBorder(new EmptyBorder(0,0,0,0));
                } 
            } );
        
        ship4_2.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    selectionColor = ship4_2.getBackground();
                    boatSize = 4;
                    ship5.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_1.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_2.setBorder(new LineBorder(Color.BLACK, 3));
                    ship3.setBorder(new EmptyBorder(0,0,0,0));
                    ship2.setBorder(new EmptyBorder(0,0,0,0));
                } 
            } );
        
        ship3.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    selectionColor = ship3.getBackground();
                    boatSize = 3;
                    ship5.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_1.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_2.setBorder(new EmptyBorder(0,0,0,0));
                    ship3.setBorder(new LineBorder(Color.BLACK, 3));
                    ship2.setBorder(new EmptyBorder(0,0,0,0));
                } 
            } );
        
        ship2.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    selectionColor = ship2.getBackground();
                    boatSize = 2;
                    ship5.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_1.setBorder(new EmptyBorder(0,0,0,0));
                    ship4_2.setBorder(new EmptyBorder(0,0,0,0));
                    ship3.setBorder(new EmptyBorder(0,0,0,0));
                    ship2.setBorder(new LineBorder(Color.BLACK, 3));
                } 
            } );
    }
    
    private void tlMouseClicked(MouseEvent e, JButton b, int r, int c) {
        
        /*if(b.getBackground() != selectionColor){
            for (int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){               
                    if(!Arrays.asList(cyanShades).contains(tlCells[i][j].getBackground())){
                        tlCells[i][j].setBackground(cyanShades[0 + (int)(Math.random() * ((cyanShades.length - 1) + 1))]);
                        //tlCellsEnable[i][j] = true;
                    }
                    tlCellsEnable[i][j] = true;
                }
            }
        
            b.setBackground(selectionColor);
        
            for (int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){               
                    if((i == r || j == c) && !(i == r && j == c)){
                        tlCells[i][j].setBackground(Color.pink);
                    }
                    else if(!(i == r && j == c)){
                        tlCellsEnable[i][j] = false;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){
                    tlCellsEnable[i][j] = true;
                    if(i == r || j == c){
                        tlCells[i][j].setBackground(cyanShades[0 + (int)(Math.random() * ((cyanShades.length - 1) + 1))]);
                    }
                }
            }
        }*/
               
        if (tlCellsClicks[r][c] && !onBoard && !ShipMap[r][c]) {
            onBoard = true;
            startX = r;
            startY = c;
            b.setBackground(selectionColor);
            tlCellsClicks[r][c] = false;
            for (int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){               
                    tlCellsEnable[i][j] = false;
                }
            }
            tlCellsEnable[r][c] = true;
            
            try {
                if ((r + boatSize - 1) <= GRID_SIZE && tlCellsClicks[r + boatSize - 1][c]
                    && Arrays.asList(cyanShades).contains(tlCells[r + boatSize - 1][c].getBackground())) {
                    tlCells[r + boatSize - 1][c].setBackground(selectionColor);
                    tlCellsEnable[r + boatSize - 1][c] = true;
                }
            } catch (Exception ex) {
            }
            try {
                if ((r - boatSize + 1) <= GRID_SIZE && tlCellsClicks[r - boatSize + 1][c]
                    && Arrays.asList(cyanShades).contains(tlCells[r - boatSize + 1][c].getBackground())) {
                    tlCells[r - boatSize + 1][c].setBackground(selectionColor);
                    tlCellsEnable[r - boatSize + 1][c] = true;
                }
            } catch (Exception ex) {
            }
            try {
                if ((c + boatSize - 1) <= GRID_SIZE && tlCellsClicks[r][c + boatSize - 1]
                     && Arrays.asList(cyanShades).contains(tlCells[r][c + boatSize - 1].getBackground())) {
                    tlCells[r][c + boatSize - 1].setBackground(selectionColor);
                    tlCellsEnable[r][c + boatSize - 1] = true;
                }
            } catch (Exception ex) {
            }
            try {
                if ((c - boatSize + 1) <= GRID_SIZE && tlCellsClicks[r][c - boatSize + 1]
                     && Arrays.asList(cyanShades).contains(tlCells[r][c - boatSize + 1].getBackground())) {
                    tlCells[r][c - boatSize + 1].setBackground(selectionColor);
                    tlCellsEnable[r][c - boatSize + 1] = true;
                }
            } catch (Exception ex) {
            }
        } 
        else {
            onBoard = false;
            for (int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){  
                    if(!Arrays.asList(cyanShades).contains(tlCells[i][j].getBackground()) && !ShipMap[i][j]){
                        tlCells[i][j].setBackground(cyanShades[0 + (int)(Math.random() * ((cyanShades.length - 1) + 1))]);             
                    }
                    tlCellsEnable[i][j] = true;
                    tlCellsClicks[i][j] = true;
                }
            }
            
            if(selectionColor == ship5.getBackground() && setShip5){
                return;
            }
            if(selectionColor == ship4_1.getBackground() && setShip4_1){
                return;
            }
            if(selectionColor == ship4_2.getBackground() && setShip4_2){
                return;
            }
            if(selectionColor == ship3.getBackground() && setShip3){
                return;
            }
            if(selectionColor == ship2.getBackground() && setShip2){
                return;
            }
            
            if (r != startX || c != startY) {
                if (r > startX) {
                    if (c > startY) {
                        for (int i = startX; i <= r; i++) {
                            for (int j = startY; j <= c; j++) {
                                if (!(Arrays.asList(cyanShades).contains(tlCells[i][j].getBackground()) || selectionColor == tlCells[i][j].getBackground())) return;
                            }
                        }
                        for (int i = startX; i <= r; i++) {
                            for (int j = startY; j <= c; j++) {                           
                                    setShip(i, j);
                            }
                        }
                    } else {
                        for (int i = startX; i <= r; i++) {
                            for (int j = startY; j >= c; j--) {
                                if (!(Arrays.asList(cyanShades).contains(tlCells[i][j].getBackground()) || selectionColor == tlCells[i][j].getBackground())) return;
                            }
                        }
                        for (int i = startX; i <= r; i++) {
                            for (int j = startY; j >= c; j--) {
                                setShip(i, j);
                            }
                        }
                    }
                } else {
                    if (c > startY) {
                        for (int i = startX; i >= r; i--) {
                            for (int j = startY; j <= c; j++) {
                                if (!(Arrays.asList(cyanShades).contains(tlCells[i][j].getBackground()) || selectionColor == tlCells[i][j].getBackground())) return;
                            }
                        }
                        for (int i = startX; i >= r; i--) {
                            for (int j = startY; j <= c; j++) {
                                setShip(i, j);
                            }
                        }
                    } else {
                        for (int i = startX; i >= r; i--) {
                            for (int j = startY; j >= c; j--) {
                                if (!(Arrays.asList(cyanShades).contains(tlCells[i][j].getBackground()) || selectionColor == tlCells[i][j].getBackground())) return;
                            }
                        }
                        for (int i = startX; i >= r; i--) {
                            for (int j = startY; j >= c; j--) {
                                setShip(i, j);
                            }
                        }
                    }
                }
            }
            
            if(selectionColor == ship5.getBackground()){
                setShip5 = true;
            }
            if(selectionColor == ship4_1.getBackground()){
                setShip4_1 = true;
            }
            if(selectionColor == ship4_2.getBackground()){
                setShip4_2 = true;
            }
            if(selectionColor == ship3.getBackground()){
                setShip3 = true;
            }
            if(selectionColor == ship2.getBackground()){
                setShip2 = true;
            }
        }
    }
    
    private void setShip(int i, int j){
        tlCells[i][j].setBackground(selectionColor);
        tlCellsEnable[i][j] = false;
        tlCellsClicks[i][j] = false;
        ShipMap[i][j] = true;
    }
    
    private void initReady(){
        readyPanel = MainMenuScreen.getReady();
        readyMessage = MainMenuScreen.getMessage();
        
        readyPanel.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) {
                    if(!(setShip5 && setShip4_1 && setShip4_2 && setShip3 && setShip2)){
                        readyMessage.setText("Place all the ships on board!");
                    }
                    else{
                        dbHandler.addMatch();
                        MainMenuScreen.jPanel11.removeAll();
                        MainMenuScreen.jPanel11.add(MainMenuScreen.mainGameScreen);
                        MainMenuScreen.jPanel11.repaint();
                        MainMenuScreen.jPanel11.revalidate();
                        pm = new PlayManager(tlCells, ShipMap);
                    }
                } 
        } ); 
        
        readyPanel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                readyPanel.setBackground(new Color(255,153,153));
                SoundManager.playButtonSound("Click2.wav"); 
            }
        });
        
        readyPanel.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e){
                readyPanel.setBackground(new Color(255,255,255));
                SoundManager.playButtonSound("Click2.wav"); 
            }
        });
    }
}
