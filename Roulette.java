import java.util.*;
public class Roulette {
  private Random r;
  private ArrayList<ArrayList<Tile>> board;
  private ArrayList<Tile> spinBoard;
  private String[] betInfo;
  private Scanner in;
  public Roulette() {
    in = new Scanner(System.in);
    betInfo = new String[2];
    int counter = 0;
    while (in.hasNext() && counter < 2) {
      betInfo[counter] = in.next();
    }
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
    output += "Colors (18 Numbers): Returns 2x your bet. Input: <color>\n";
    output += "Dozens (12 Numbers): Returns 3x your bet. DozenIDs are (1-12 is 0, 13-24 is 1, 25-36 is 2). Input: <DOZENdozenID>\n";
    output += "Highs/Lows (18 Numbers): Returns 2x your bet. Preferences are (high, low). Input: <Preference>\n";
    output += "Odds/Evens (18 Numbers): Returns 2x your bet. Preferences are (odd, even). Input: <Preference>\n";
    output += "Columns (12 Numbers): Returns 3x your bet. columnIDs are (Column starting at 1 is 0, column starting at 2 is 1, Column starting at 3 is 2.) Input: <COLUMNcolumnID>\n";
    System.out.println(output);
  }

  public double interpretSpin() {
    double output = 0;

    return output;
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
