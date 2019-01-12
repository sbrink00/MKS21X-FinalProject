import java.util.*;
public class Roulette {
  private Random r;
  private double betVal;
  private ArrayList<ArrayList<Tile>> board;
  private ArrayList<Tile> spinBoard;
  private ArrayList<String> betInfo;
  private Scanner in;
  private int[] winners;
  private String EB = "Enter your bet value and bet type";
  private String PA = "Do you want to play again? <y/n>";

  public Roulette() {
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
          board.get(i).add(new Tile (counter, 'B'));
          spinBoard.add(new Tile(counter, 'B'));
        }
        else if (counter % 2 == 1) {
          board.get(i).add(new Tile (counter, 'R'));
          spinBoard.add(new Tile(counter, 'R'));
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
    String output = "Here are your betting options for Roulette and how to Bet (Please input the bet exactly as shown, ignoring angle brackets): \n";
    output += "Please enter your bet value first, followed by what you are betting on, separated by a space.\n";
    output += "Straight (1 Number): Returns 36x your bet. Input: <number>\n";
    output += "Split (2 Numbers): Returns 18x your bet. Input: <number1, number2>\n";
    output += "Street (3 Numbers): Returns 12x your bet. Input: <number1, number2, number3>\n";
    output += "Square (4 Numbers): Returns 9x your bet. Input: <number1, number2, number3, number4>\n";
    output += "Six Line (6 Numbers): Returns 6x. Input: <number1, number2, number3, number4, number5, number6>\n";
    output += "Colors (18 Numbers): Returns 2x your bet, unless you bet green in which case it returns 36x your bet. Colors are (red, black, green). Input: <color>\n";
    output += "Dozens (12 Numbers): Returns 3x your bet. DozenIDs are (1-12 is 0, 13-24 is 1, 25-36 is 2). Input: <DOZEN dozenID>\n";
    output += "Highs/Lows (18 Numbers): Returns 2x your bet. Preferences are (high, low). Input: <Preference>\n";
    output += "Odds/Evens (18 Numbers): Returns 2x your bet. Preferences are (odd, even). Input: <Preference>\n";
    output += "Columns (12 Numbers): Returns 3x your bet. columnIDs are (Column starting at 1 is 0, column starting at 2 is 1, Column starting at 3 is 2.) Input: <COLUMN columnID>\n";
    System.out.println(output);
  }
  public void betWinsPossibilites() {
    betVal = parseFloat(betInfo.get(0));
    int[] output;
    if (betInfo.get(1).equals("high")) output = new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
    else if (betInfo.get(1).equals("low")) output = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
    else if (betInfo.get(1).equals("red")) output = new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    else if (betInfo.get(1).equals("black")) output = new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    else if (betInfo.get(1).equals("green")) output = new int[]{0};
    else if (betInfo.get(1).equals("odd")) output = new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
    else if (betInfo.get(1).equals("even")) output = new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
    else if (betInfo.get(1).equals("DOZEN")) {
      if (betInfo.get(2).equals("0")) output = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
      else if (betInfo.get(2).equals("1")) output = new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
      else if (betInfo.get(2).equals("2")) output = new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
    }
    else if (betInfo.get(1).equals("COLUMN")) {
      if (betInfo.get(2).equals("0")) output = new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
      else if (betInfo.get(2).equals("1")) output = new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
      else if (betInfo.get(2).equals("2")) output = new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
    }
    else {
      int counter = 1;
      while (counter < 7 && betInfo.get(counter) != null) {
        output = new int[betInfo.size() - 1];
        output[counter - 1] = parseInt(betInfo.get(counter));
      }
    }
    winners = output;
  }
  public double interpretSpin(Tile winner) {
    if (winners.contains(winner.getVal())) {
      return betVal * (36 / winners.length);
    }
    else {
      return betVal * -1;
    }
  }
  public void bet() {
    System.out.println(EB);
    betInfo = new ArrayList<String>();
    int counter = 0;
    while (in.hasNext() && counter < 2) {
      betInfo.add(in.next());
    }
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
