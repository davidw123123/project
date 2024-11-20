/**
 * The ability class represents how the abilities section of the game. It contains all the current abilities in the game.
 */
public class Ability {
    /**
     * Constructor for the Ability class. Creates a new instance of Ability
     */
    public Ability(){
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
     * The oneUp method returns 1.
     */
    public int oneUp(){
        return 1;
    }
    /**
     * The oneUp method returns 7.
     */
    public int sevenUp(){
        return 7;
    }
    /**
     * The oneUp method returns -7.
     */
    public int sevenDown(){
        return -7;
    }
    /**
     * The oneUp method returns -1.
     */
    public int oneDown(){
        return -1;
    }

}
