import java.util.*;
public class CasinoWar {
  private ArrayList<Hand> playerHand;
  private Dealer dealer;
  private Player player;
  private double bet;
  private Shoe shoe;
  private Scanner in;
  private class Dealer {
    private Hand hand;
    public Dealer() {
      hand = new Hand();
    }
  }
}
