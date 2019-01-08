import java.util.*;
public class Wheel {
  private int[] values;
  private ArrayList<ArrayList<Tile>> board;
  public Wheel() {
    /* values = new int[]{0, 32, 15, 19, 4, 21, 2, 25, 17, 37, 6, 27,
              13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33,
              1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35,
              3, 26}; */
    for (int i = 0; i < 4; i++) {
      board.add(new ArrayList<Tile>());
    }
    board.get(0).add(0);
    int counter = 1;
    while (counter < 37) {
      for (int i = 1; i < 4; i++) {
        board.get(i).add(counter);
        counter++;
      }
    }
  }
  public String toString() {
    output = "";
    for (elem:board) {
      
    }
  }
}
