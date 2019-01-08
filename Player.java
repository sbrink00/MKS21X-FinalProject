public class Player {
  private double balance;
  private Hand hand;
  //private int xpos;
  //private int ypos;
  public Player(double startingBal) {
    hand = new Hand();
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
  public void changeBal(double value) {
    balance += value;
  }
  public double getBal() {
    return balance;
  }
  public Hand getHand() {return hand;}
}
