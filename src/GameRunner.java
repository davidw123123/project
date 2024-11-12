import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        boolean UserMove = true;
        boolean computerMove = true;
        int goal = 21;
        Scanner s = new Scanner(System.in);
        Game user = new Game();
        Game computer = new Game();
        int computerInitial = computer.total;
        System.out.println("Your abillity cards: " + user.abilites + "\n" + "Your number: " + user.deck+"\n"+"----------------------------------------------------");
        System.out.println(computer.abilites + " " + computer.deck);

        while (UserMove || computerMove) {
            System.out.print("Choose between hit or stand or use your ability: ");
            if ((s.nextLine()).toLowerCase().equals(("hit"))) {
                System.out.println("You chose Hit!");
                System.out.println("Your Numbers: " + user.hit() + " Total: " + user.total);
                System.out.println("----------------------------------------------------");
                System.out.println("Computer's Turn");
            } else {
                System.out.println("Total: "+ user.total+"\n"+"----------------------------------------------------");
                System.out.println("Computer's Turn");
                UserMove = false;
            }
            if (Math.abs(computer.total - goal) < 5){
                System.out.println("Stand");
                System.out.println(computer.total);
                computerMove = false;
            } else {
                System.out.println("Hit");
                System.out.print("Computer's Numbers: " + computer.hit().substring(4));
                int see = computer.total - computerInitial;
                System.out.println(" Total: ? + " + see+"\n"+"----------------------------------------------------");
            }
        }
        System.out.println(UserMove);
        System.out.println(computerMove);
        System.out.println("----------------------------------------------------"+"\n"+"END");
    }
}



