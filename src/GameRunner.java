import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        boolean UserMove = true;
        boolean computerMove = true;
        Scanner s = new Scanner(System.in);
        Game user = new Game();
        Game computer = new Game();
        System.out.println("Your abillity cards: "+ user.abilites +"\n"+ "Your number: "+ user.deck);
        System.out.println(computer.abilites +" "+ computer.deck);
        while (UserMove && computerMove){
            System.out.println("Hit or Stand");
            if (s.nextLine().equals(("hit")) || s.nextLine().equals("Hit")){
                System.out.println("You Numbers: " + user.hit() + " Total: "+user.total);
            } else {
                UserMove = false;
            }
            int computerChoice = (int) (Math.random()*5);
            if (computerChoice < 5){
                computer.hit();
            } else {
                computerMove = false;
            }
            UserMove = true;
            computerMove = true;
        }
    }
}
