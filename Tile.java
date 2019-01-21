public class Tile {
  //A Tile class to make up the Roulette board.
  //Only two features are its color, green/black/red, and its numerical value.
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
