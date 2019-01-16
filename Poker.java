import java.util.*;
public class Poker {
  private Player player;
  private double bet;
  private Shoe shoe;
  private Scanner in;
  private Hand hand;
  public Poker() {
    player = new Player(1000);
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    hand = new Hand();
  }
}
