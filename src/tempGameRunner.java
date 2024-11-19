import java.util.Scanner;

public class tempGameRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        tempGame user = new tempGame();
        tempGame computer = new tempGame();
        // variables needed
        int computerInitial = computer.total;
        boolean userMove = true;
        boolean computerMove = true;
        int count = 0;

        //teaches user how to play
        System.out.println("Your ability cards: " + user.abilities + "\n" + "Your number: " + user.deck+"\n"+"----------------------------------------------------");
        //
        while (userMove || computerMove) {
            System.out.print("Choose between hit or stand or use your ability: ");
            String response = s.nextLine();
            if ((user.abilities.length()>1)&&(!response.equalsIgnoreCase("hit")&&!response.equalsIgnoreCase("stand"))){
                if (response.equalsIgnoreCase(user.abilities)) {
                    System.out.println(user.useAbility(user.abilities));
                    // change the computer goal to equal the player goal
                    computer.changeGoal(user.getGoal());
                    } else {
                    System.out.println("You don't have this ability! Choose between hit or stand");
                    response = s.nextLine();
                }

            } else if (!response.equalsIgnoreCase("hit")&&!response.equalsIgnoreCase("stand")){
                System.out.println("You don't have any abilities! Choose between hit or stand");
                response = s.nextLine();
            }
            if ( response.equalsIgnoreCase("hit")) {
                System.out.println(user.hit());
            } else if (response.equalsIgnoreCase("stand")){
                System.out.println("Total: "+ user.total+"\n"+"----------------------------------------------------");
                userMove = false;
            }
            if (computerMove && count != 0 && (count % 2 == 0) && computer.abilities.length() > 1){
                System.out.println("Computer used: "+computer.abilities);
                System.out.println(computer.useAbility(computer.abilities));
                user.changeGoal(computer.getGoal());
                computer.abilities = "";
                computerMove = false;
            }
            if (computerMove) {
                if (((Math.abs(computer.total - computer.goal) < 5) || (Math.abs(computer.total - computer.goal) > computer.goal))) {
                    System.out.println("Computer's Turn: Stand");
                    System.out.println(computer.total + "\n" + "----------------------------------------------------");
                    computerMove = false;
                    count++;
                } else {
                    System.out.println(computer.computerHit());
                    int temp = computer.total - computerInitial;
                    count++;
                    System.out.println("Total: ? + " + temp + "\n" + "----------------------------------------------------");
                }
            }
            // Allows the user or computer to choose if they want to hit or stand again by setting their move back to true only if one of their move is true
            if (userMove || computerMove){
                userMove = true;
                computerMove = true;
            }
        }
        //Reveals whether the user wins or loses
        System.out.println( user.determineWinner(user.total, computer.total,user.goal));
    }
}
