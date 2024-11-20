public class Ability {
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
     * The oneUp method changes the abilities String to an empty string and increments goal by 1.
     */
    public int oneUp(){
        return 1;
    }
    /**
     * The oneUp method changes the abilities String to an empty string and increments goal by 7.
     */
    public int sevenUp(){
        return 7;
    }
    /**
     * The oneUp method changes the abilities String to an empty string and decrements goal by 7.
     */
    public int sevenDown(){
        return -7;
    }
    /**
     * The oneUp method changes the abilities String to an empty string and decrements goal by 1.
     */
    public int oneDown(){
        return -1;
    }

}
