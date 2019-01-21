import java.util.*;
//Roulette Game:
public class Roulette {
  private Random r;
  private double betVal;
  private ArrayList<ArrayList<Tile>> board;
  private ArrayList<Tile> spinBoard;
  private Player player;
  private Scanner in;
  private int[] winners;
  private String betType;
  private int dozenID;
  private int columnID;
  private int numberBetLength;
  private String EB = "Enter your bet value: ";
  private String PA = "Do you want to play again? <y/n>";
  private String BT = "Please enter your bet type: ";
  private String GN = "Please enter a number you would like to bet on: ";
  public Roulette(Player p) {
    player = p;
    in = new Scanner(System.in);
    board = new ArrayList<ArrayList<Tile>>();
    spinBoard = new ArrayList<Tile>();
    for (int i = 0; i < 4; i++) {
      board.add(new ArrayList<Tile>());
    }
    board.get(0).add(new Tile(0, 'G'));
    spinBoard.add(new Tile(0, 'G'));
    int counter = 1;
    while (counter < 37) {
      for (int i = 1; i < 4; i++) {
        if (counter % 2 == 0) {
          board.get(i).add(new Tile (counter, 'R'));
          spinBoard.add(new Tile(counter, 'R'));
        }
        else if (counter % 2 == 1) {
          board.get(i).add(new Tile (counter, 'B'));
          spinBoard.add(new Tile(counter, 'B'));
        }
        counter++;
      }
    }
    r = new Random();
  }
  public Tile spin() {
    int rando = r.nextInt(37);
    return spinBoard.get(rando);
  }
  public void displayOptions() {
    String output = "Here are your betting options for Roulette and how to Bet (Please input the bet exactly as shown inside the angle brackets): \n";
    output += "Please enter your bet value first, followed by what you are betting on, separated by a space.\n";
    output += "Straight (1 Number): Returns 36x your bet. <straight>\n";
    output += "Split (2 Numbers): Returns 18x your bet. Input: <split>\n";
    output += "Street (3 Numbers): Returns 12x your bet. Input: <street>\n";
    output += "Square (4 Numbers): Returns 9x your bet. Input: <square>\n";
    output += "Six Line (6 Numbers): Returns 6x. Input: <sixline>\n";
    output += "Colors (18 Numbers): Returns 2x your bet, unless you bet green in which case it returns 36x your bet. Colors are (red, black, green). Input: <color>\n";
    output += "Dozens (12 Numbers): Returns 3x your bet. DozenIDs are (1-12 is 0, 13-24 is 1, 25-36 is 2). Input: <dozen>\n";
    output += "Highs/Lows (18 Numbers): Returns 2x your bet. Preferences are (high, low). Input: <Preference>\n";
    output += "Odds/Evens (18 Numbers): Returns 2x your bet. Preferences are (odd, even). Input: <Preference>\n";
    output += "Columns (12 Numbers): Returns 3x your bet. columnIDs are (Column starting at 1 is 0, column starting at 2 is 1, Column starting at 3 is 2.) Input: <column>\n";
    System.out.println(output);
  }
  public void betWinsPossibilites() {
    winners = new int[0];
    if (betType.equals("high")) winners = new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
    else if (betType.equals("low")) winners = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
    else if (betType.equals("red")) winners = new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    else if (betType.equals("black")) winners = new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    else if (betType.equals("green")) winners = new int[]{0};
    else if (betType.equals("odd")) winners = new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
    else if (betType.equals("even")) winners = new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
    else if (betType.equals("dozen")) {
      dozenBet();
      if (dozenID == 0) winners = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
      else if (dozenID == 1) winners = new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
      else if (dozenID == 2) winners = new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
    }
    else if (betType.equals("column")) {
      columnBet();
      if (columnID == 0) winners = new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
      else if (columnID == 1) winners = new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
      else if (columnID == 2) winners = new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
    }
    else {
      if (betType.equals("straight")) numberBetLength = 1;
      else if (betType.equals("split")) numberBetLength = 2;
      else if (betType.equals("street")) numberBetLength = 3;
      else if (betType.equals("square")) numberBetLength = 4;
      else if (betType.equals("sixline")) numberBetLength = 6;
      winners = new int[numberBetLength];
      int counter = 0;
      while (counter < numberBetLength) {
        winners[counter] = getNumBet();
        counter++;
      }
    }
  }
  public double interpretSpin(Tile winner) {
    boolean contains = false;
    for (int val:winners) {
      if (winner.getVal() == val) contains = true;
    }
    if (contains) {
      return betVal * (36 / winners.length);
    }
    else {
      return betVal * -1;
    }
  }
  public void run() {
    System.out.println("You are now playing roulette.");
    System.out.println("Your balance is: " + player.getBal());
    System.out.println("------------------------------------------------------");
    boolean done = false;
    int counter = 0;
    while (!done) {
      if (counter == 0) displayOptions();
      bet();
      betType();
      betWinsPossibilites();
      Tile winner = spin();
      System.out.println("The winning Tile is: " + winner.toString());
      player.changeBal(interpretSpin(winner));
      System.out.println("Your balance has been changed by: " + interpretSpin(winner));
      System.out.println("Your balance is now: " + player.getBal());
      counter++;
      if (endgame()) done = true;
    }
  }
  public boolean endgame() {
    if (player.getBal() == 0) return true;
    System.out.println(PA);
    String ans = in.nextLine();
    if (ans.equals("y")) return false;
    return true;
  }
  public int getNumBet() {
    System.out.println(GN);
    return Integer.parseInt(in.nextLine());
  }
  public void bet() {
    System.out.println(EB);
    betVal = Double.parseDouble(in.nextLine());
    if (betVal > player.getBal()) betVal = player.getBal();
  }
  public void betType() {
    System.out.println(BT);
    betType = in.nextLine().toLowerCase();
  }
  public void dozenBet() {
    System.out.println("Which dozenID would you like to bet on?");
    dozenID = Integer.parseInt(in.nextLine());
  }
  public void columnBet() {
    System.out.println("Which columnID would you like to bet on?");
    columnID = Integer.parseInt(in.nextLine());
  }
  public String printBoard() {
    String output = "";
    for (int i = 0; i < 4; i++) {
      output += "[";
      for (Tile elem:board.get(i)) {
        output += elem.toString();
        output += ", ";
      }
      output += "]";
    }
    return output;
  }
}
