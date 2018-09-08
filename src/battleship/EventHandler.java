
package battleship;

import static battleship.MainMenuScreen.canPlay;
import static battleship.MainMenuScreen.ownBoard;
import static battleship.MainMenuScreen.welcomeLabel;
import static battleship.SoundManager.clip;
import java.awt.Color;
import java.awt.event.*;
import javax.sound.sampled.FloatControl;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.JTableHeader;

/*
	Handles events for MainMenuScreen and Exit Dialog Box
*/
 
public class EventHandler implements MouseListener, FocusListener, ChangeListener{

    MainMenuScreen mms;
    WarningDialog wd;
    boolean theme = false;
    private Color c1 = new Color(230,200,236);
    private Color c2 = new Color(144,12,63);
    private Color c3 = new Color(204, 168, 59);
    private Color c4 = new Color(255, 255, 204);
    
    public EventHandler(MainMenuScreen m) {
        mms = m;
        wd = new WarningDialog(mms, true, "<html>Are you sure you want to exit?</html>");;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == mms.jPanel1){
            jPanel1MouseClicked();
        }
        if(e.getSource() == mms.jPanel3){
            jPanel3MouseClicked();
        }
        if(e.getSource() == mms.jPanel4){
            jPanel4MouseClicked();
        }
        if(e.getSource() == mms.jPanel5){
            jPanel5MouseClicked();
        }
        if(e.getSource() == mms.jPanel6){
            jPanel6MouseClicked();
        }
        if(e.getSource() == mms.jPanel7){
            jPanel7MouseClicked();
        }
        if(e.getSource() == mms.jPanel8){
            jPanel8MouseClicked();
        }
        if(e.getSource() == mms.jPanel9){
            jPanel9MouseClicked();
        }
        if(e.getSource() == mms.jPanel10){
            jPanel10MouseClicked();
        }
        if(e.getSource() == mms.jPanel18){
            jPanel18MouseClicked();
        }
        if(e.getSource() == mms.jPanel20){
            jPanel20MouseClicked();
        }
        if(e.getSource() == mms.jLabel24){
            jLabel24MouseClicked();
        }
        if(e.getSource() == mms.jTextField2){
            //System.out.println("battleship.EventHandler.mouseClicked()");
            mms.jTextField2.setText("");
        }
        if(e.getSource() == mms.jTextField1){
            mms.jTextField1.setText("");
        }
        if(e.getSource() == mms.jPasswordField1){
            mms.jPasswordField1.setText("");
        }
        if(e.getSource() == mms.jPasswordField2){
            mms.jPasswordField2.setText("");
        }
        if(e.getSource() == mms.jPanel14){
            jPanel14MouseClicked();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == mms.jPanel15){
            setHoverColor(mms.jPanel15);
        }
        if(e.getSource() == mms.jPanel3){
            if(canPlay){
                setHoverColor(mms.jPanel3);
            }
        }
        if(e.getSource() == mms.jPanel4){
            setHoverColor(mms.jPanel4);
        }
        if(e.getSource() == mms.jPanel5){
            setHoverColor(mms.jPanel5);
        }
        if(e.getSource() == mms.jPanel6){
            setHoverColor(mms.jPanel6);
        }
        if(e.getSource() == mms.jPanel7){
            setHoverColor(mms.jPanel7);
        }
        if(e.getSource() == mms.jPanel8){
            setHoverColor(mms.jPanel8);
        }
        if(e.getSource() == mms.jPanel14){
            setHoverColor(mms.jPanel14);
        }
        if(e.getSource() == mms.jPanel16){
            setHoverColor(mms.jPanel16);
        }
        if(e.getSource() == mms.jPanel18){
            setHoverColor(mms.jPanel18);
        }
        if(e.getSource() == mms.jPanel20){
            setHoverColor(mms.jPanel20);
        }
        if(e.getSource() == mms.jPanel9){
            mms.jPanel9.setBackground(new Color(153, 0, 153));
        }
        if(e.getSource() == mms.jPanel10){
            mms.jPanel10.setBackground(new Color(204, 102, 255));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == mms.jPanel15){
            resetHoverColor(mms.jPanel15);
        }
        if(e.getSource() == mms.jPanel3){
            if(canPlay){
                resetHoverColor(mms.jPanel3);
            }
        }
        if(e.getSource() == mms.jPanel4){
            resetHoverColor(mms.jPanel4);
        }
        if(e.getSource() == mms.jPanel5){
            resetHoverColor(mms.jPanel5);
        }
        if(e.getSource() == mms.jPanel6){
            resetHoverColor(mms.jPanel6);
        }
        if(e.getSource() == mms.jPanel7){
            resetHoverColor(mms.jPanel7);
        }
        if(e.getSource() == mms.jPanel8){
            resetHoverColor(mms.jPanel8);
        }
        if(e.getSource() == mms.jPanel14){
            resetHoverColor(mms.jPanel14);
        }
        if(e.getSource() == mms.jPanel16){
            resetHoverColor(mms.jPanel16);
        }
        if(e.getSource() == mms.jPanel18){
            resetHoverColor(mms.jPanel18);
        }
        if(e.getSource() == mms.jPanel20){
            resetHoverColor(mms.jPanel20);
        }
        if(e.getSource() == mms.jPanel9){
            mms.jPanel9.setBackground(new Color(88, 24, 69));
        }
        if(e.getSource() == mms.jPanel10){
            mms.jPanel10.setBackground(new Color(88, 24, 69));
        }
    }
    
    void setColor(JPanel panel){
        panel.setBackground(new Color(255,87,51));
    }
    
    void resetColor(JPanel panel){
        panel.setBackground(new Color(255,255,204));
    }
    
    void setHoverColor(JPanel l){
        l.setBackground(new Color(242,204,221));
        SoundManager.playButtonSound("Click2.wav");
    }
    
    void resetHoverColor(JPanel l){
        l.setBackground(new Color(255,255,204));
    }

    private void jPanel3MouseClicked() {
        if(canPlay){
            setColor(mms.jPanel3);
            resetColor(mms.jPanel4);
            resetColor(mms.jPanel5);
            resetColor(mms.jPanel6);
            resetColor(mms.jPanel7);
            resetColor(mms.jPanel8);
            mms.jPanel11.removeAll();
            mms.jPanel11.add(mms.createBoard);
            mms.jPanel11.repaint();
            mms.jPanel11.revalidate();
            mms.board = new Board(mms.boardPanel);
        }
    }

    private void jPanel4MouseClicked() {
        setColor(mms.jPanel4);
        resetColor(mms.jPanel3);
        resetColor(mms.jPanel5);
        resetColor(mms.jPanel6);
        resetColor(mms.jPanel7);
        resetColor(mms.jPanel8);
        
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.lbPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
        
        JTableHeader header = mms.jTable1.getTableHeader();
        header.setForeground(mms.darkRed);
        header.setBackground(Color.BLACK);       	
        header.setOpaque(false);
        mms.jTable1.setBackground(mms.darkYellow);
        mms.jTable1.getTableHeader().setReorderingAllowed(false);
        
        mms.dbH.loadSampleData(mms.jTable1);
    }

    private void jPanel5MouseClicked() {
        setColor(mms.jPanel5);
        resetColor(mms.jPanel4);
        resetColor(mms.jPanel3);
        resetColor(mms.jPanel6);
        resetColor(mms.jPanel7);
        resetColor(mms.jPanel8);
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.settingsPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
    }

    private void jPanel6MouseClicked() {
        setColor(mms.jPanel6);
        resetColor(mms.jPanel4);
        resetColor(mms.jPanel5);
        resetColor(mms.jPanel3);
        resetColor(mms.jPanel7);
        resetColor(mms.jPanel8);
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.signUpPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
    }

    private void jPanel7MouseClicked() {
        setColor(mms.jPanel7);
        resetColor(mms.jPanel4);
        resetColor(mms.jPanel5);
        resetColor(mms.jPanel6);
        resetColor(mms.jPanel3);
        resetColor(mms.jPanel8);
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.logInPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
    }

    private void jPanel9MouseClicked() {
        String e = mms.jTextField2.getText();
        String u = mms.jTextField1.getText();
        String p = mms.jPasswordField1.getText();
        String cp = mms.jPasswordField2.getText();
        
        mms.warning.setText("");
        SignUp s = new SignUp(e, u, p, cp, mms.warning);
        s.validate();
    }

    private void jPanel10MouseClicked() {
        String e = mms.jTextField4.getText();
        String p = mms.jPasswordField3.getText();
        
        mms.warningLogIn.setText("");
        LogIn l = new LogIn(e, p, mms.warningLogIn);
        l.validate(welcomeLabel);
    }

    private void jLabel24MouseClicked() {
        try {
            mms.board.pm.getTimer().resetTimer();
        } catch (Exception e) {
        }
        mms.boardPanel.removeAll();
        ownBoard.removeAll();
        mms.oppBoard.removeAll();
        
        mms.jPanel11.removeAll();
        mms.jPanel11.add(mms.bg);
        mms.jPanel11.repaint();
        mms.jPanel11.revalidate();
        SoundManager.playButtonSound("Click2.wav");
    }

    private void jPanel1MouseClicked() {
        resetColor(mms.jPanel8);
        resetColor(mms.jPanel4);
        resetColor(mms.jPanel5);
        resetColor(mms.jPanel6);
        resetColor(mms.jPanel7);
        resetColor(mms.jPanel3);
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.playPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
    }

    private void jPanel20MouseClicked() {
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.instructionPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
    }

    private void jPanel8MouseClicked() {
        //System.exit(0);
        wd.setPosition();
        wd.setVisible(true);
        
    }

    private void jPanel18MouseClicked() {
        if(theme){
            mms.jPanel1.setBackground(new Color(255, 195, 0));
            mms.jPanel2.setBackground(new Color(88,24,69));
            mms.lbPanel.setBackground(new Color(144,12,63));
            mms.settingsPanel.setBackground(new Color(144,12,63));
            mms.signUpPanel.setBackground(new Color(144,12,63));
            mms.logInPanel.setBackground(new Color(144,12,63));
            mms.instructionPanel.setBackground(new Color(144,12,63));
            mms.createBoard.setBackground(new Color(255,204,204));
            mms.mainGameScreen.setBackground(new Color(255,204,204));
            mms.jTextField1.setBackground(c2);
            mms.jTextField2.setBackground(c2);
            mms.jPasswordField1.setBackground(c2);
            mms.jTextField4.setBackground(c2);
            mms.jPasswordField2.setBackground(c2);
            mms.jPasswordField3.setBackground(c2);
            mms.jLabel30.setForeground(c2);
            mms.jLabel31.setForeground(c2);
            mms.jLabel32.setForeground(c2);
            mms.jLabel33.setForeground(c2);
            mms.jLabel34.setForeground(c2);
            mms.jLabel43.setForeground(c2);
            mms.jLabel44.setForeground(c2);
            mms.jLabel52.setForeground(c2);
            mms.timerLabel.setForeground(c2);
            
            theme = !theme;
        }
        else{
            mms.jPanel1.setBackground(c3);
            mms.jPanel2.setBackground(new Color(88,24,69));
            mms.lbPanel.setBackground(c1);
            mms.settingsPanel.setBackground(c1);
            mms.signUpPanel.setBackground(c1);
            mms.logInPanel.setBackground(c1);
            mms.instructionPanel.setBackground(c1);
            mms.createBoard.setBackground(new Color(0,104,104));
            mms.mainGameScreen.setBackground(new Color(0,104,104));
            mms.jTextField1.setBackground(c1);
            mms.jTextField2.setBackground(c1);
            mms.jPasswordField1.setBackground(c1);
            mms.jTextField4.setBackground(c1);
            mms.jPasswordField2.setBackground(c1);
            mms.jPasswordField3.setBackground(c1);
            mms.jLabel30.setForeground(c4);
            mms.jLabel31.setForeground(c4);
            mms.jLabel32.setForeground(c4);
            mms.jLabel33.setForeground(c4);
            mms.jLabel34.setForeground(c4);
            mms.jLabel43.setForeground(c4);
            mms.jLabel44.setForeground(c4);
            mms.jLabel52.setForeground(c4);
            mms.timerLabel.setForeground(c4);
            theme = !theme;
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        //System.out.println("battleship.EventHandler.focusGained()");
        if(e.getSource() == mms.jTextField2){
            mms.jTextField2.setText("");
        }
        if(e.getSource() == mms.jTextField1){
            mms.jTextField1.setText("");
        }
        if(e.getSource() == mms.jPasswordField1){
            mms.jPasswordField1.setText("");
        }
        if(e.getSource() == mms.jPasswordField2){
            mms.jPasswordField2.setText("");
        }
        if(e.getSource() == mms.jPasswordField3){
            mms.jPasswordField3.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == mms.jTextField2){
            if(mms.jTextField2.getText() == "") mms.jTextField2.setText("Type your email ID here");
        }
        if(e.getSource() == mms.jTextField1){
            if(mms.jTextField1.getText() == "") mms.jTextField1.setText("Type your in-game name here");
        }
    }

    private void jPanel14MouseClicked() {
        mms.jPanel2.removeAll();
        mms.jPanel2.add(mms.matchHistoryPanel);
        mms.jPanel2.repaint();
        mms.jPanel2.revalidate();
        
        dbHandler.loadMatchData(mms.jTable2);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == mms.jSlider1){
            FloatControl gainControl;
            SoundManager sm = new SoundManager();
            float gain;
            float range;
            
            gainControl = (FloatControl) sm.getBGClip().getControl(FloatControl.Type.MASTER_GAIN);
            range = gainControl.getMaximum() - gainControl.getMinimum();
            gain = (range * (mms.jSlider1.getValue() / 100)) + gainControl.getMinimum();
            gainControl.setValue(gain);
        }
    }
}

class DialogEventHandler implements MouseListener, MouseMotionListener{
    
    WarningDialog w;
    int currX;
    int currY;

    public DialogEventHandler(WarningDialog wd) {
        w = wd;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == w.jPanel3){
            System.exit(0);
        }
        if(e.getSource() == w.jPanel2){
            w.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //if(e.getSource() == w.jPanel1){
            currX = e.getX();
            currY = e.getY();
        //}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //if(e.getSource() == w.jPanel1){
            int coordX = e.getXOnScreen();
            int coordY = e.getYOnScreen();
        
            w.setLocation(coordX - currX, coordY - currY);
        //}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == w.jPanel3){
            setHoverColor(w.jPanel3);
        }
        if(e.getSource() == w.jPanel2){
            setHoverColor(w.jPanel2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == w.jPanel3){
            resetHoverColor(w.jPanel3);
        }
        if(e.getSource() == w.jPanel2){
            resetHoverColor(w.jPanel2);
        }
    }
   
    void setHoverColor(JPanel l){
        l.setBackground(new Color(242,204,221));
        SoundManager.playButtonSound("Click2.wav");
    }
    
    void resetHoverColor(JPanel l){
        l.setBackground(new Color(255, 195, 0));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}