import java.util.*;
public class SlotsTriple {
  //This slots is designed to return, on average, 99% of the bet input.
  private Random r;
  private double bet;
  private double jackpot;
  private double payout;
  private char[] reel;
  private char[] spinG;
  public static void main(String[] args) {
    Slots test = new Slots(1.0);
  }
  /* J means Jackpot; one occurrence.
  A has two occurrences per reel.
  B has three occurrences per reel.
  C has four occurrences per reel.
  D has ten occurrences per reel.
  T is worthless and has 25 occurrences per reel. */
  public SlotsTriple() {
    r = new Random();
    reel = new char[45];
    for (int i = 0; i < 45; i++) {
      if (i == 0) reel[i] = 'J';
      else if (i > 0 && i < 3) reel[i] = 'A';
      else if (i > 2 && i < 6) reel[i] = 'B';
      else if (i > 5 && i < 10) reel[i] = 'C';
      else if (i > 9 && i < 20) reel[i] = 'D';
      else reel[i] = 'T';
    }
    System.out.println(toString(reel));
  }
  public void spin(double bet) {
    bet = betInput;
    jackpot = 2500 * bet;
    char reel1 = Math.abs(r.nextInt()) % 45;
    char reel2 = Math.abs(r.nextInt()) % 45;
    char reel3 = Math.abs(r.nextInt()) % 45;
    char[] spin = {reel1, reel2, reel3};
    spinG = spin;
  }
  public void interpretSpin() {
    char x = spinG[0];
    char y = spinG[1];
    char z = spinG[2];
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
    System.out.println("Your account balance has been changed by: $" + payout);
    Player.changeBal(payout);
  }
  private static String toString(char[] input) {
    String output = "";
    for (char element:input) {
      output += element;
    }
    return output;
  }
}
