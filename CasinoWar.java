import java.util.*;
public class CasinoWar {
  private Hand playerHand;
  private Dealer dealer;
  private Player player;
  private double bet;
  private Shoe shoe;
  private Scanner in;
  private class Dealer {
    private Hand dealerHand;
    public Dealer() {
      dealerHand = new Hand();
    }
  }
  public CasinoWar() {
    player = new Player(1000);
    dealer = new Dealer();
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    playerHand = new Hand();
  }
}
