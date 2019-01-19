import java.util.*;
public class CasinoWar {
<<<<<<< HEAD
  private Hand playerHand;
=======
  private ArrayList<Hand> playerHand;
>>>>>>> 629bcf6267ee900484dbb3ffab5e695489a75460
  private Dealer dealer;
  private Player player;
  private double bet;
  private Shoe shoe;
  private Scanner in;
<<<<<<< HEAD
  private double payout;
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
  public void deal() {
    playerHand.add(shoe.remove(shoe.getRandomCard()));
    dealer.dealerHand.add(shoe.remove(shoe.getRandomCard()));
  }
  public void interpretDeal() {
    if playerHand.get(0).getValue()
  }
=======
  private class Dealer {
    private Hand hand;
    public Dealer() {
      hand = new Hand();
    }
  }
>>>>>>> 629bcf6267ee900484dbb3ffab5e695489a75460
}
