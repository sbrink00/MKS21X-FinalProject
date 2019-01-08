public class Tile {
  private int val;
  private char color;
  private boolean odd;
  public Tile(int inVal, char inCol, boolean inOdd) {
    val = inVal;
    color = inCol;
    odd = inOdd;
  }
  public int getVal() {
    return val;
  }
  public char getCol() {
    return color;
  }
  public boolean isOdd() {
    return odd;
  }
  //Irrelevant class.
}
