import java.util.*;
public class SlotsTriple {
  //This slots is designed to return, on average, 99% of the bet input.
  private Random r;
  private Scanner in;
  private Player player;
  private double bet;
  private double payout;
  private String unicode;
  private char[] reel;
  private int[] spinG;
  private String EB = "Please enter your bet value: ";
  private String PA = "Would you like to play again? <y/n>";
  /* J means Jackpot; one occurrence.
  A has two occurrences per reel.
  B has three occurrences per reel.
  C has four occurrences per reel.
  D has ten occurrences per reel.
  T is worthless and has 25 occurrences per reel. */
  public SlotsTriple() {
    in = new Scanner(System.in);
    r = new Random();
    player = new Player(1000);
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
    bet = Double.parseDouble(in.nextLine());
    if (bet > player.getBal()) bet = player.getBal();
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
    boolean done = false;
    while (!done) {
      bet();
      spin();
      interpretSpin();
      System.out.println("This the is the spin result: " + printSpin());
      printSpin();
      System.out.println("Your balance has been changed by: " + payout);
      player.changeBal(payout);
      System.out.println("Your new balance is: " + player.getBal());
      if (endgame()) done = true;
    }
  }
  public boolean endgame() {
    System.out.println(PA);
    boolean output = true;
    if (player.getBal() == 0) output = true;
    else if (in.nextLine().equals("y")) output = false;
    return output;
  }
  public String toUnicode(char input) {
    String unicode = "";
    if (input == 'J') unicode = "\u1F4B0";
    else if (input == 'A') unicode = "\u1F352";
    else if (input == 'B') unicode = "\u1F34C";
    else if (input == 'C') unicode = "\u1F351";
    else if (input == 'D') unicode = "\u1F345";
    else unicode = "\u1F4A9";
    return unicode;
  }
  public String toString() {
    String output = "";
    for (char input:reel) {
      if (input == 'J') unicode = "\u1F4B0";
      else if (input == 'A') unicode = "\u1F352";
      else if (input == 'B') unicode = "\u1F34C";
      else if (input == 'C') unicode = "\u1F351";
      else if (input == 'D') unicode = "\u1F345";
      else unicode = "\u1F4A9";
      output += unicode;
    }
    return output;
  }
}
