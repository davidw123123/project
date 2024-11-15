import java.util.Scanner;

public class tempGameRunner {
    public static void main(String[] args) {
        boolean UserMove = true;
        boolean computerMove = true;
        Scanner s = new Scanner(System.in);
        tempGame user = new tempGame();
        tempGame computer = new tempGame();
        tempGame goal = new tempGame(21);
        int computerInitial = computer.total;
        System.out.println("Your ability cards: " + user.abilites + "\n" + "Your number: " + user.deck+"\n"+"----------------------------------------------------");
        System.out.println(computer.abilites + " " + computer.deck);

        while (UserMove || computerMove) {
            System.out.print("Choose between hit or stand or use your ability: ");
            String response = s.nextLine();
            if ((user.abilites.length()>1)&&(!response.equalsIgnoreCase("hit")&&!response.equalsIgnoreCase("stand"))){
                if (response.equalsIgnoreCase(user.abilites)) {
                    System.out.println(user.useAbility(user.abilites));
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
                UserMove = false;
            }
            if ((Math.abs(computer.total - goal) < 5)||(Math.abs(computer.total - goal) > goal)){
                System.out.println("Computer's Turn: Stand");
                System.out.println(computer.total+"\n"+"----------------------------------------------------");
                computerMove = false;
            } else {
                System.out.println(computer.computerHit());
                int temp = computer.total - computerInitial;
                System.out.println("Total: ? + " + temp +"\n"+"----------------------------------------------------");
            }
            if (UserMove || computerMove){
                UserMove = true;
                computerMove = true;
            }
        }

        System.out.println("----------------------------------------------------"+"\n"+ user.determineWinner(user.total, computer.total,goal));
    }
}
