public class Player {
  private int balance;
  //private int xpos;
  //private int ypos;

  //public void moveUp() {}
  //public void moveDown() {}
  //public void moveLeft() {}
  //public void moveRight() {}
  public void increaseBal(int winnings) {
    balance += winnings;
  }
  public void decreaseBal(int losses) {
    balance -= losses;
  }
  public int getBal() {
    return balance;
  }
}
