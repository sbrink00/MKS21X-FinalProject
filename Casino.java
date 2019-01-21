import java.util.Scanner;
public class Casino{
  public static void main(String[]args){
    Casino c = new Casino();
    c.run();
  }

  private Player player;
  private Blackjack blackjack;
  private CasinoWar war;
  private Roulette roulette;
  private SlotsTriple slots;
  private Poker poker;
  private Scanner in;

  public Casino(){
    player = new Player(1000);
    blackjack = new Blackjack(1000);
    war = new CasinoWar();
    roulette = new Roulette();
    slots = new SlotsTriple();
    poker = new Poker();
    in = new Scanner(System.in);
  }

  public void run(){
    start();
    String instructions = "Which game would you like to play? Your options are:\n\n";
    instructions += "blackjack\nroulette\npoker\nslots\nwar\n";
    instructions += "please enter your choice exactly as depicted above.\n";
    boolean done = false;
    while (!done){
      System.out.println(instructions);
      String game = in.nextLine();
      System.out.println("-------------------------------------------------");
      if (game.equals("blackjack")) blackjack.run();
      else if (game.equals("slots")) slots.run();
      else if (game.equals("poker")) poker.run();
      else if (game.equals("roulette")) roulette.run();
      else if (game.equals("war")) war.run();
      else System.out.println("That is not a valid input");
      System.out.println("Do you want to play a different game? <y/n>");
      String playMore = in.nextLine();
      if (!playMore.equals("y")) done = true;
    }
    System.out.println("Thank you for coming to the Java Casino.\nWe hope to see you again soon.");
  }

  public void start(){
    System.out.println("WELCOME TO THE JAVA CASINO. HIT ENTER TO ENTER WITH 1000 DOLLARS!!!!");
    String enter = in.nextLine();
    System.out.println("You have 1000 dollars. When you have 0, you will be kicked out.");
    String iUnderstand = in.nextLine();
  }







}
