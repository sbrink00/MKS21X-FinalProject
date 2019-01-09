import java.util.*;
public class Roulette {
  private Random r;
  private ArrayList<ArrayList<Tile>> board;
  public Roulette() {
    board = new ArrayList<ArrayList<Tile>>();
    for (int i = 0; i < 4; i++) {
      board.add(new ArrayList<Tile>());
    }
    board.get(0).add(new Tile(0, 'G'));
    int counter = 1;
    while (counter < 37) {
      for (int i = 1; i < 4; i++) {
        if (counter % 2 == 0) {
          board.get(i).add(new Tile (counter, 'B'));
        }
        else if (counter % 2 == 1) {
          board.get(i).add(new Tile (counter, 'R'));
        }
        counter++;
      }
    }
    r = new Random();
  }
  public int spin() {
    return (Math.abs(r.nextInt()) % 37);
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
