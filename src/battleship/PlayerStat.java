
package battleship;

/*
	a class which directly provides all information to the player database when a new player signs up
*/

public class PlayerStat {
    
    private String pid;
    private int wins = 0;
    private int loses = 0;
    private int shipsDestroyed = 0;
    private int shipsLost = 0;    
    
    PlayerStat(String pid){
        this.pid = pid;
    }
    
    String getPid(){
        return pid;
    }
    int getWins(){
        return wins;
    }
    int getLoses(){
        return loses;
    }
    int getShipDest(){
        return shipsDestroyed;
    }
    int getShipsLost(){
        return shipsLost;
    }
    
    void setWins(int wins){
        this.wins = wins;
    }
    void setLoses(int loses){
        this.loses = loses;
    }
    void setShipDest(int shipsDestroyed){
        this.shipsDestroyed = shipsDestroyed;
    }
    void setShipsLost(int shipsLost){
        this.shipsLost = shipsLost;
    }
    
}
