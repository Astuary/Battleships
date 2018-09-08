
package battleship;

import javax.swing.JLabel;

/*
	Checks if user is valid [signed up] and if yes, allows the player to play a round
*/

public class LogIn {
    
    protected static String usrName;
    private String password;
    private JLabel l;
    private dbHandler d = new dbHandler();
    
    LogIn(String usrName, String password, JLabel warning){
        this.usrName = usrName;
        this.password = password;
        l = warning;
    }

    void validate(JLabel welcomeLabel) {
        if(d.userExists(usrName, password)){
            l.setText("Logged In!");
            welcomeLabel.setText("Welcome, " + usrName);
            MainMenuScreen.setCanPlay();
        }
        else{
            l.setText("Wrong user name and password combination!!!");
            welcomeLabel.setText("");
        }
    }
    
}
