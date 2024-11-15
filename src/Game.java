public class Game{
    String deck = "";
    int total = 0;
    String abilites = "";

    public Game(){
    int temp = ((int) (Math.random()*9+1));
    total += temp;
    deck += String.valueOf(temp);
    abilites += randomAbility();
    }

    public String hit(){
        int random = ((int) (Math.random()*9+1));
        deck += " , " +random;
        total += random;
        return deck;
    }

    public String randomAbility(){
        int x = (int) (Math.random()*4+1);
        if (x == 1){
            return "oneUp";
        } else if (x == 2) {
            return "sevenUp";
        } else if (x == 3){
            return "oneDown";
        } else {
            return "sevenDown";
        }
    }

    public String determineWinner(int playerTotal, int computerTotal, int goal){
        String winner = "";
        if (playerTotal == computerTotal) {
            winner = "No winner!";
        } else if (playerTotal > goal && computerTotal < goal){
            winner = "You lose!";
        } else if (computerTotal > goal && playerTotal < goal){
            winner = "You win!";
        } else if (playerTotal>goal&&computerTotal>goal){
         int playerScore = goal - playerTotal;
         int computerScore = goal - computerTotal;
         if (playerTotal > computerScore)
         {
            winner = "You lose!";
         }
         else if (computerScore > playerScore) {
             winner = "You win!";
         }
     } else if (goal - playerTotal < goal - computerTotal){
         winner = "You win!";
     } else {
         winner = "You lose!";
     }
     return  winner;
        }

}