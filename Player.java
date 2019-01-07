public class Player {
  private int balance;
  //private int xpos;
  //private int ypos;
  public Player(int startingBal) {
    if (startingBal < 1000) {
      balance = 1000;
    }
    else {
      balance = startingBal;
    }
  }

  //public void moveUp() {}
  //public void moveDown() {}
  //public void moveLeft() {}
  //public void moveRight() {}
  public void increaseBal(int value) {
    balance += winnings;
  }
  public int getBal() {
    return balance;
  }
}
