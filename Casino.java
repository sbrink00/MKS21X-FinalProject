import java.util.Scanner;
public class Casino{
  public static void main(String[]args){
    System.out.println("WELCOME TO THE JAVA CASINO. HIT ENTER TO ENTER WITH 1000 DOLLARS!!!!");
    Scanner scan = new Scanner(System.in);
    Player player = new Player(1000);
    String enter = scan.nextLine();
    System.out.println("You have 1000 dollars. When you have 0, you will be kicked out.");
    String iUnderstand = scan.nextLine();
    boolean done = false;
    while (!done){
      System.out.println("Would you like to play Roulette, Blackjack, Slots, or Video Poker?");
      String game = scan.nextLine();
    }
  }
}
