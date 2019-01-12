public class Tile {
  private int val;
  private char color;
  public Tile(int inVal, char inCol) {
    val = inVal;
    color = inCol;
  }
  public int getVal() {
    return val;
  }
  public char getCol() {
    return color;
  }
  public String toString() {
    return val + "-" + color;
  }
}
