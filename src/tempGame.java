/**
 * The Game class represents the inventory of the user. The inventory contains the initial card they have, temp, their total, deck, and abilities
 */
public class tempGame{
    int goal = 21;
    String deck = "";
    int total = 0;
    String abilities = "";

    /**
     * Constructor for the Game class. This creates a new instance of a Game with initialized variables, temp, total, deck, and abilites.
     */
    public tempGame(){
        int temp = ((int) (Math.random()*9+1));
        total += temp;
        deck += String.valueOf(temp);
        abilities += randomAbility();
    }

    /**
     * The hit method will produce a random number between 1-9, inclusive, and add it to deck and total.
     * @return returns a String representing a formatted sentence showing the number drew, current numbers, and total
     */
    public String hit(){
        int random = ((int) (Math.random()*9+1));
        deck += " , " +random;
        total += random;
        return "Drew: "+deck.substring(4)+"\n"+"Your Numbers: " + deck + " Total: " + total+"\n"+"----------------------------------------------------";
    }

    /**
     * The computerHit method will produce a random number between 1-9, inclusive, and add it to deck and total.
     * @return returns a String representing a formatted sentence showing the number drew, current numbers, and total
     */
    public String computerHit(){
        int random = ((int) (Math.random()*9+1));
        deck += " , " +random;
        total += random;
        return "Computer's Turn: Hit"+"\n"+"Drew: "+deck.substring(4);
    }

    /**
     * The randomAbility method will randomly select an ability for the user
     * @return returns an ability given the random number selected.
     */
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

    /**
     * the getGoal method retrieves the goal
     * @return returns goal
     */
    public int getGoal() {
        return goal;
    }

    /**
     * The method useAbility calls the method of the ability being used
     * @param ability represents the ability being called
     * @return returns the String representing a formatted sentence showing the new goal.
     */
    public String useAbility(String ability){
        if (ability.equalsIgnoreCase("oneUp")) {
          oneUp();
            return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else if (ability.equalsIgnoreCase("sevenUp")) {
           sevenUp();
            return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else if (ability.equalsIgnoreCase("oneDown")) {
            oneDown();
            return"The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else {
            sevenDown();
           return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        }
    }

    /**
     * The oneUp method changes the abilities String to an empty string and increments goal by 1.
     */
    public void oneUp(){
        abilities = "";
        goal += 1;
    }
    /**
     * The oneUp method changes the abilities String to an empty string and increments goal by 7.
     */
    public void sevenUp(){
        abilities = "";
        goal += 7;
    }
    /**
     * The oneUp method changes the abilities String to an empty string and decrements goal by 7.
     */
    public void sevenDown(){
        abilities = "";
        goal -=7;
    }
    /**
     * The oneUp method changes the abilities String to an empty string and decrements goal by 1.
     */
    public void oneDown(){
        abilities = "";
        goal -= 1;
    }

    /**
     * The changeGoal method changes the current goal to newGoal
     * @param newGoal represents the newGoal
     */
    public void changeGoal(int newGoal) {
        this.goal = newGoal;
    }

    /**
     * The determineWinner method determines the winner of the game given both player's total compared to the goal
     * @param playerTotal represents the total numbers of the user
     * @param computerTotal represent the total numbers of the computer
     * @param goal represents the goal the players are trying to come as close to
     * @return returns whether the user wins or looses in a simple String format.
     */
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