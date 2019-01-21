import java.util.*;
public class SlotsTriple {
  //This slots is designed to return, on average, 99% of the bet input.
  private Random r;
  private Scanner in;
  private Player player;
  private double bet;
  private double payout;
  private char[] reel;
  private char unicode;
  private int[] spinG;
  private String EB = "Please enter your bet value: ";
  private String PA = "Would you like to play again? <y/n>";
  /* J means Jackpot; one occurrence.
  A has two occurrences per reel.
  B has three occurrences per reel.
  C has four occurrences per reel.
  D has ten occurrences per reel.
  T is worthless and has 25 occurrences per reel. */
  public SlotsTriple(Player p) {
    in = new Scanner(System.in);
    r = new Random();
    player = p;
    reel = new char[45];
    for (int i = 0; i < 45; i++) {
      if (i == 0) reel[i] = 'J';
      else if (i > 0 && i < 3) reel[i] = 'A';
      else if (i > 2 && i < 6) reel[i] = 'B';
      else if (i > 5 && i < 10) reel[i] = 'C';
      else if (i > 9 && i < 20) reel[i] = 'D';
      else reel[i] = 'T';
    }
  }
  public void bet() {
    System.out.println(EB);
    boolean done = false;
    while (!done) {
      try {
        double terminalBet = Double.parseDouble(in.nextLine());
        bet = terminalBet;
        done = true;
      }
      catch (NumberFormatException e){
        System.out.println("Please enter a number with up to two decimal points.");
      }
    }
    if (bet > player.getBal() || bet <= 0) {
      bet = player.getBal();
      System.out.println("You entered an invalid bet value, so now you're betting all your money. Good luck!");
    }
  }
  public void slowDown() {
    System.out.println("Type anything to spin!");
    String check = in.nextLine();
  }
  public void spin() {
    int reel1 = r.nextInt(45);
    int reel2 = r.nextInt(45);
    int reel3 = r.nextInt(45);
    int[] spin = new int[]{reel1, reel2, reel3};
    spinG = spin;
  }
  public String printSpin() {
    String output = "";
    output += toUnicode(reel[spinG[0]]);
    output += ", " + toUnicode(reel[spinG[1]]);
    output += ", " + toUnicode(reel[spinG[2]]);
    return output;
  }
  public void interpretSpin() {
    char x = reel[spinG[0]];
    char y = reel[spinG[1]];
    char z = reel[spinG[2]];
    if (x == y && x == z) {
      if (x == 'J') payout = 2500 * bet;
      else if (x == 'A') payout = 1750 * bet;
      else if (x == 'B') payout = 750 * bet;
      else if (x == 'C') payout = 400 * bet;
      else if (x == 'D') payout = 5 * bet;
      else if (x == 'T') payout = -1 * bet;
    }
    else if (x == y || y == z) {
      if (y == 'J') payout = 100 * bet;
      else if (y == 'A') payout = 50 * bet;
      else if (y == 'B') payout = 25 * bet;
      else if (y == 'T') payout = -1 * bet;
    }
    else {
      payout = -1 * bet;
    }
  }
  public void run() {
    System.out.println("You are now playing slots.");
    System.out.println("Your balance is: " + player.getBal());
    System.out.println("------------------------------------------------------");
    boolean done = false;
    int count = 0;
    while (count < 1) {
      System.out.println("The descending order of value for each icon is : ");
      System.out.println("\u265a, \u2660, \u2665, \u2663, \u2666, \u265f.");
      count++;
    }
    while (!done) {
      bet();
      slowDown();
      spin();
      interpretSpin();
      System.out.println("This the is the spin result: " + printSpin());
      printSpin();
      System.out.println("------------------------------------------------------");
      System.out.println("Your balance has been changed by: " + payout);
      player.changeBal(payout);
      System.out.println("Your new balance is: " + player.getBal());
      if (endgame()) done = true;
    }
  }
  public boolean endgame() {
    System.out.println(PA);
    boolean output = true;
    if (player.getBal() == 0) {
      output = true;
      System.out.println("You are out of money!");
    }
    else if (in.nextLine().equals("y")) output = false;
    return output;
  }
  public char toUnicode(char input) {
    if (input == 'J') unicode = '\u265a';
    else if (input == 'A') unicode = '\u2660';
    else if (input == 'B') unicode = '\u2665';
    else if (input == 'C') unicode = '\u2663';
    else if (input == 'D') unicode = '\u2666';
    else unicode = '\u265f';
    return unicode;
  }
  public String toString() {
    String output = "";
    for (char input:reel) {
      if (input == 'J') unicode = '\u265a';
      else if (input == 'A') unicode = '\u2660';
      else if (input == 'B') unicode = '\u2665';
      else if (input == 'C') unicode = '\u2663';
      else if (input == 'D') unicode = '\u2666';
      else unicode = '\u265f';
      output += unicode;
    }
    return output;
  }
}
