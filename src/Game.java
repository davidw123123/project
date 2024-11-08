public class Game{
    boolean move = true;
    int goal = 21;
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

    public void stand(){
        move = !move;
    }
    public String randomAbility(){
        int x = (int) (Math.random()*5+1);
        if (x == 1){
            return "oneUp";
        } else if (x == 2) {
            return "twoUp";
        } else if (x == 3){
            return "oneDown";
        } else if (x == 4){
            return "drawCard";
        } else {
            return "freeTwo";
        }
    }

    public void oneUp(){
        goal += 1;
    }
    public void oneDown(){
        goal -= 1;
    }
    public void twoUp(){
        goal += 2;
    }
    public void freeTwo(){

    }

    public String toString(){
        return abilites +" "+ deck + + goal;
    }

}