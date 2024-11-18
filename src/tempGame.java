public class tempGame{
    int goal = 21;
    String deck = "";
    int total = 0;
    String abilities = "";

    public tempGame(){
        int temp = ((int) (Math.random()*9+1));
        total += temp;
        deck += String.valueOf(temp);
        abilities += randomAbility();
    }

    public int goal(){
        int goal = 21;
        return goal;
    }
    public String hit(){
        int random = ((int) (Math.random()*9+1));
        deck += " , " +random;
        total += random;
        return "Drew: "+deck.substring(4)+"\n"+"Your Numbers: " + deck + " Total: " + total+"\n"+"----------------------------------------------------";
    }
    public String computerHit(){
        int random = ((int) (Math.random()*9+1));
        deck += " , " +random;
        total += random;
        return "Computer's Turn: Hit"+"\n"+"Drew: "+deck.substring(4);
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

    public int getGoal() {
        return goal;
    }

    public String useAbility(String ability){
        if (abilities.equalsIgnoreCase("oneUp")) {
          oneUp();
            return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else if (abilities.equalsIgnoreCase("sevenUp")) {
           sevenUp();
            return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else if (abilities.equalsIgnoreCase("oneDown")) {
            oneDown();
            return"The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else {
            sevenDown();
           return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        }
    }
    public void oneUp(){
        abilities = "";
        goal += 1;
    }
    public void sevenUp(){
        abilities = "";
        goal += 7;
    }
    public void sevenDown(){
        abilities = "";
        goal -=7;
    }
    public void oneDown(){
        abilities = "";
        goal -= 1;
    }

    public void changeGoal(int newGoal) {
        this.goal = newGoal;
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