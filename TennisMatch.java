package csci1010.assign5;
/**
 * TennisMatch class has constructor for taking
 * user input, which calculates number of
 * sets & matched needed to play for Player1 to win
 * based on Math.random logic.
 * @author $Charles Owens
 */
public class TennisMatch {    
    private int setsToWin;
    private double player1WinsServing;
    private double player2WinsServing;
    private double playerCurrentlyServing;
    private int gamesWonPlayer1CurrentSet;
    private int gamesWonPlayer2CurrentSet;
    private int setsInMatchWonPlayer1;
    private int setsInMatchWonPlayer2;
    private String resultsOfEachSet;
    
    public TennisMatch(int setsToWin, double player1WinsServing, double player2WinsServing){
        setsetsToWin(setsToWin);
        setplayer1WinsServing(player1WinsServing);
        setplayer2WinsServing(player2WinsServing);
        
        this.playerCurrentlyServing = player1WinsServing; 
        gamesWonPlayer1CurrentSet = 0;
        gamesWonPlayer2CurrentSet = 0;
        setsInMatchWonPlayer1 = 0;
        setsInMatchWonPlayer2 = 0;
        resultsOfEachSet = "";
    }
    
    public void setsetsToWin(int setsToWin){
        this.setsToWin = setsToWin;
    }
    public void setplayer1WinsServing(double player1WinsServing){
        this.player1WinsServing = player1WinsServing;
    }
    public void setplayer2WinsServing(double player2WinsServing){
        this.player2WinsServing = player2WinsServing;
    }
    
    
    public void playMatch(){
        while(matchOver() == false){
            playSet();
        }
        System.out.println("Player 1 wins: " + resultsOfEachSet);
    }
    //med.
    private void playSet(){
        gamesWonPlayer1CurrentSet = 0;
        gamesWonPlayer2CurrentSet = 0;
        while(setOver() == false){
            playGame(); 
        }
        gamesWonPlayer1CurrentSet = this.gamesWonPlayer1CurrentSet;
        gamesWonPlayer2CurrentSet = this.gamesWonPlayer2CurrentSet;
        
        if(gamesWonPlayer1CurrentSet > gamesWonPlayer2CurrentSet)
            setsInMatchWonPlayer1++;
        else
            setsInMatchWonPlayer2++;
        
        String results = gamesWonPlayer1CurrentSet + "-" + gamesWonPlayer2CurrentSet + " ";
        resultsOfEachSet += results;
    }
    //low
    private void playGame(){
        double random = Math.random();
        if(random <= this.player1WinsServing)
            gamesWonPlayer1CurrentSet++;
        else
            gamesWonPlayer2CurrentSet++;
        
        random = Math.random();
        if(random <= this.player2WinsServing)
            gamesWonPlayer2CurrentSet++;
        else
            gamesWonPlayer1CurrentSet++;      
    }
    //high
    private boolean matchOver(){
        return((this.setsInMatchWonPlayer1 == this.setsToWin) || (this.setsInMatchWonPlayer2 == this.setsToWin));
    }
    //med.
    private boolean setOver(){
        return ((this.gamesWonPlayer1CurrentSet > 5 && (this.gamesWonPlayer1CurrentSet - this.gamesWonPlayer2CurrentSet) > 1) ||
                (this.gamesWonPlayer2CurrentSet > 5 && (this.gamesWonPlayer2CurrentSet - this.gamesWonPlayer1CurrentSet) > 1));
    }
    
}
