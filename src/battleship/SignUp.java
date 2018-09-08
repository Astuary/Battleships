
package battleship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/*
	checks validity of a new player through regex and if valid, calls dbHandler function to add a new record
*/

public class SignUp {
    
    private final String email;
    private final String usrName;
    private final String pwd;
    private final String confirmPwd;
    private final JLabel warning;
    private Pattern pattern;
    private Matcher matcher;
    private final dbHandler db1 = new dbHandler();

    private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private static final String USERNAME_PATTERN =
		"^[a-zA-Z0-9_]*$";
    
    private static final String PASSWORD_PATTERN =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
    
    SignUp(String email, String usrName, String pwd, String confirmPwd, JLabel warning){
        this.email = email;
        this.usrName = usrName;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
        this.warning = warning;
    }
    
    public void validate(){
        warning.setText("");
        if(!validateEmail()){
            warning.setText("Warning: Email ID not valid.");
            return;
        }
        if(db1.findRecordEmail(email)){
            warning.setText("Error: Account already exists on this email-ID");
            return;
        }
        if(!validateUsrName()){
            warning.setText("Warning: User name should only contain upper and lower alphabets, numbers and/or an underscore.");
            return;
        }
        if(db1.findRecordPid(usrName)){
            warning.setText("Error: Account already exists on this user name");
            return;
        }
        if(!validatePwd()){
            warning.setText("<html>Warning: Password must contain minimum 8 characters, at least one uppercase letter,<br/>one lowercase letter, one number and one special character.</html>");
        }
        if(!pwd.equals(confirmPwd)){
            warning.setText("Warning: Password not matching to its duplicate one.");
        }
        
        if(validateEmail() && validateUsrName() && validatePwd() && pwd.equals(confirmPwd)){
            add(email, usrName, pwd);
        }
    }

    private boolean validateEmail() {

        pattern = Pattern.compile(EMAIL_PATTERN);
	matcher = pattern.matcher(email);
        return matcher.matches();
	
    }

    private boolean validateUsrName() {
        pattern = Pattern.compile(USERNAME_PATTERN);
	matcher = pattern.matcher(usrName);
        return matcher.matches();
    }

    private boolean validatePwd() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
	matcher = pattern.matcher(pwd);
        return matcher.matches();
    }

    private void add(String email, String usrName, String pwd) {
        dbHandler db = new dbHandler();
        db.addRecord(email, usrName, pwd, warning);
    }
    
}
