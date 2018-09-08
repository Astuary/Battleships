
package battleship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class dbHandler {
    
    static int currMatch;
    static String userName;
    
	/*
		fetch data for leaderboards
	*/
    void loadSampleData(JTable tab){
        int c = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            /*ResultSet rs = st.executeQuery("select * from playerstats order by wins desc, opp_ships_destroyed desc, own_ships_destroyed asc, loses asc");*/
            ResultSet rs = st.executeQuery("select pid, wins, loses, own_ships_destroyed, opp_ships_destroyed from player1 order by wins desc, opp_ships_destroyed desc, own_ships_destroyed asc, loses asc");
            
            while(tab.getRowCount() > 0){
                ((DefaultTableModel)tab.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            
            while(rs.next()){
                Object [] rows = new Object[col + 1];
                
                for(int i = 1; i <= col; i++){
                    rows[0] = c;
                    rows[i] = rs.getObject(i);
                }
                c++;
                ((DefaultTableModel)tab.getModel()).insertRow(rs.getRow() - 1, rows);
            }
            rs.close();
            st.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            //add Warning dialog
            new ErrorDialog();
        }
    }
    
	/*
		fetch data for all matches the player has played
	*/
    static void loadMatchData(JTable tab){
        int c = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            /*ResultSet rs = st.executeQuery("select * from playerstats order by wins desc, opp_ships_destroyed desc, own_ships_destroyed asc, loses asc");*/
            ResultSet rs = st.executeQuery("select mid, pid2, winnerid, time_played, date_played from matchstats1 where pid1 = '" + userName + "'");
            
            while(tab.getRowCount() > 0){
                ((DefaultTableModel)tab.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            
            while(rs.next()){
                Object [] rows = new Object[col + 1];
                
                for(int i = 1; i <= col; i++){
                    rows[0] = c;
                    rows[i] = rs.getObject(i);
                }
                c++;
                ((DefaultTableModel)tab.getModel()).insertRow(rs.getRow() - 1, rows);
            }
            rs.close();
            st.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            //add WArning dialog
            new ErrorDialog();
        }
    }
    
	/*
		add new player at Sign up time
	*/
    void addRecord(String email, String usrName, String pwd, JLabel warning) {
        PlayerStat p = new PlayerStat(usrName);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            /*st.executeUpdate("insert into player values('" + usrName + "', '" + email + "', '" + pwd + "')");
            st.executeUpdate("insert into playerstats values('" + usrName + "', '" + p.getWins() + "', '" + p.getLoses() + "', '"
            + p.getShipsLost() + "', '" + p.getShipDest()+ "')");*/
            st.executeUpdate("insert into player1 values('" + usrName + "', '" + email + "', '" + pwd + "', '" + p.getWins() + "', '" + p.getLoses() + "', '"
                                                                + p.getShipsLost() + "', '" + p.getShipDest()+ "')");
            warning.setText("Signed up!");
        } catch (ClassNotFoundException | SQLException ex) {
            new ErrorDialog();
        }
    }
    
	/*
		check if the email id is already used to make an account
	*/
    boolean findRecordEmail(String email){
        int count = 1;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            /*ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM PLAYER WHERE upper(emailID) ='" + email.toUpperCase() + "'" );*/
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM PLAYER1 WHERE upper(email) ='" + email.toUpperCase() + "'" );
            while(rs.next()){
                count = rs.getInt("total");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            new ErrorDialog();
        }
        
        return count != 0;
    }
	
	/*
		check if user name is taken by some other player
    */
    boolean findRecordPid(String usrName){
        int count = 1;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            /*ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM PLAYER WHERE upper(pid) ='" + usrName.toUpperCase() +"'" );*/
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM PLAYER1 WHERE upper(pid) ='" + usrName.toUpperCase() +"'" );
            while(rs.next()){
                count = rs.getInt("total");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            new ErrorDialog();
        }
        
        return count != 0;
    }
	
    boolean userExists(String pid, String password){
        
        int count = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            /*ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM player WHERE upper(pid) ='" + pid.toUpperCase() +"' and"
                                            + " upper(passwd) = '" + password.toUpperCase() + "'" );*/
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM player1 WHERE upper(pid) ='" + pid.toUpperCase() +"' and"
                                            + " upper(pwrd) = '" + password.toUpperCase() + "'" );
            while(rs.next()){
                count = rs.getInt("total");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            new ErrorDialog();
        }
        
        return count != 0;
    }
    
	/*
		add match stats
	*/
    static void addMatch() {
        int c = 0;
        userName = LogIn.usrName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(mid) AS C FROM matchstats1");
            try {
               while(rs.next()){
                    c = rs.getInt("C");
               }
            } catch (SQLException sQLException) {
            }
            if (c != 0) {
                c++;
                st.executeUpdate("insert into matchstats1(mid, pid1, pid2, date_played) values(" + c + ", '" + userName + "', '#computer', now())");
                currMatch = c;
            }else{
                st.executeUpdate("insert into matchstats1(mid, pid1, pid2, date_played) values(101" + ", '" + userName + "', '#computer', now())");
                currMatch = 101;
            }
            addMatchShip(currMatch, userName);
        } catch (ClassNotFoundException | SQLException ex) {
            new ErrorDialog();
            //Logger.getLogger("Test").log(Level.INFO, "BOOM!", ex);
        }
    }
    
    static void addMatchShip(int matchid, String pid){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            for(int i = 1; i <= 5; i++){
                st.executeUpdate("insert into playership1(mid, pid, shipid) values(" + matchid + ", '" + pid + "', " + i + ")");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            new ErrorDialog();
            //Logger.getLogger("Test").log(Level.INFO, "BOOM!", e);
        }
    }
    
	/*
		update match stats
    */
    static void updateMatchShip(int [] shipHits){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();
            for(int i = 0; i < 5; i++){
                st.executeUpdate("update playership1 set noOfhits = " + shipHits[i] + " where mid = " + currMatch + " and pid = '" + userName + "' and shipid = " + (i+1));
            }
        }
        catch(ClassNotFoundException | SQLException e){
            //new ErrorDialog();
            Logger.getLogger("Test").log(Level.INFO, "BOOM!", e);
        }
    }
    
    static void updateMatch(String winner, int sd, int oppsd, String time) {
        String winnerid = (winner == "YOU LOSE")?"#computer":LogIn.usrName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleship_db", "root", "");
            Statement st = con.createStatement();

            st.executeUpdate("update matchstats1 set winnerid = '" + winnerid + "', ships_destroyed_pid1 = " + sd + ", ships_destoryed_pid2 = " + oppsd + ", time_played = '" + time + "' where mid = " + currMatch);

        } catch (ClassNotFoundException | SQLException ex) {
            //new ErrorDialog();
            Logger.getLogger("Test").log(Level.INFO, "BOOM!", ex);
        }
    }
}
