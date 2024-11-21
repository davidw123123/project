/**
 * The Game class represents the inventory of the user. The inventory contains the initial card they have, temp, their total, deck, and abilities
 */
public class Game{
    int goal = 21;
    String deck = "";
    int total = 0;
    String abilities = "";
    Ability ability = new Ability();
    /**
     * Constructor for the Game class. This creates a new instance of a Game with initialized variables, temp, total, deck, and abilities.
     */
    public Game(){
        int temp = ((int) (Math.random()*9+1));
        total += temp;
        deck += String.valueOf(temp);
        abilities += ability.randomAbility();
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
     * the getGoal method retrieves the goal
     * @return returns goal
     */
    public int getGoal() {
        return goal;
    }

    /**
     * The method useAbility calls the method of the ability1 being used
     * @param ability1 represents the ability1 being called
     * @return returns the String representing a formatted sentence showing the new goal.
     */
    public String useAbility(String ability1){
        if (ability1.equalsIgnoreCase("oneUp")) {
          goal += ability.oneUp();
          abilities = "";
            return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else if (ability1.equalsIgnoreCase("sevenUp")) {
            goal += ability.sevenUp();
            abilities = "";
            return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else if (ability1.equalsIgnoreCase("oneDown")) {
            goal += ability.oneDown();
            abilities = "";
            return"The goal is now " + goal+"\n"+"----------------------------------------------------";
        } else {
            goal += ability.sevenDown();
            abilities = "";
           return "The goal is now " + goal+"\n"+"----------------------------------------------------";
        }
    }

    /**
     * The abilityDescription method tells the user the description of the ability.
     * @param ability represents the ability that the method is returning the description for.
     * @return returns the ability of the given ability.
     */
    public String abilityDescription(String ability){
        if (ability.equalsIgnoreCase("oneUp")){
            return "- increases goal by 1";
        } else if (ability.equalsIgnoreCase("oneDown")){
            return "- decreases goal by 1";
        } else if (ability.equalsIgnoreCase("sevenUp")){
            return "- increases goal by 7";
        } else return "- decreases goal by 7";
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