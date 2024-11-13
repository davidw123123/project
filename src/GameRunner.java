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
        System.out.println("Your ability cards: " + user.abilites + "\n" + "Your number: " + user.deck+"\n"+"----------------------------------------------------");
        System.out.println(computer.abilites + " " + computer.deck);

        while (UserMove || computerMove) {
            System.out.print("Choose between hit or stand or use your ability: ");
            String response = s.nextLine();
            if ((user.abilites.length()>1)&&(!response.equalsIgnoreCase("hit")&&!response.equalsIgnoreCase("stand"))){
                if (response.equalsIgnoreCase(user.abilites)) {
                    if (user.abilites.equalsIgnoreCase("oneUp")) {
                        goal += 1;
                        user.abilites = "";
                        System.out.println("The goal is now " + goal + "\n" + "Choose between hit or stand");
                    } else if (user.abilites.equalsIgnoreCase("sevenUp")) {
                        goal += 7;
                        user.abilites = "";
                        System.out.println("The goal is now " + goal + "\n" + "Choose between hit or stand");
                    } else if (user.abilites.equalsIgnoreCase("oneDown")) {
                        goal -= 1;
                        user.abilites = "";
                        System.out.println("The goal is now " + goal + "\n" + "Choose between hit or stand");
                    } else {
                        goal -= 7;
                        user.abilites = "";
                        System.out.println("The goal is now " + goal + "\n" + "Choose between hit or stand");
                    }
                } else {
                    System.out.println("You don't have this ability! Choose between hit or stand");
                }
        }
            if (response.equalsIgnoreCase(("hit"))) {
                System.out.println("You chose Hit!");
                System.out.println("Your Numbers: " + user.hit() + " Total: " + user.total);
                System.out.println("----------------------------------------------------");
                System.out.println("Computer's Turn");
            } else {
                System.out.println("Total: "+ user.total+"\n"+"----------------------------------------------------");
                System.out.println("Computer's Turn");
                UserMove = false;
            }
            if ((Math.abs(computer.total - goal) < 5)||(Math.abs(computer.total - goal) > goal)){
                System.out.println("Stand");
                System.out.println(computer.total);
                computerMove = false;
            } else {
                System.out.println("Hit");
                System.out.print("Drew: " + computer.hit().substring(4));
                int temp = computer.total - computerInitial;
                System.out.println(" Total: ? + " + temp +"\n"+"----------------------------------------------------");
            }
        }
        System.out.println("----------------------------------------------------"+"\n"+"end");
    }
}



