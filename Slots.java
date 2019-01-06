import java.util.*;
public class Slots {
  private Random r;
  private double prob;
  private double returnPerc;
  private double cost;
  private double jackpot;
  private double payout;
  private char[] reel;
  public static void main(String[] args) {
    Slots test = new Slots(1.0);
  }
  public Slots(double bet) {
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
  public void spin() {

  }
  private static String toString(char[] input) {
    String output = "";
    for (char element:input) {
      output += element;
    }
    return output;
  }
}
