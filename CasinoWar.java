import java.util.*;
public class CasinoWar {
  private Hand playerHand;
  private Dealer dealer;
  private Player player;
  private double bet;
  private Shoe shoe;
  private Scanner in;
  private double warBet;
  private double payout = 0;
  private String WAR = "Would you like to go to war (double your bet, but payout is only your original bet),  or surrender (forfeit half your bet) <war/surrender>: \n";
  private String EB = "Please enter your bet value: ";
  private String PA = "Would you like to play again? <y/n>";
  private class Dealer {
    private Hand dealerHand;
    public Dealer() {
      dealerHand = new Hand();
    }
  }
  public void run() {
    System.out.println("You are now playing war.");
    System.out.println("------------------------------------------------------");
    boolean done = false;
    while (!done) {
      bet();
      deal();
      System.out.println("This is your card: " + playerHand.toString());
      System.out.println("This is the dealer's card: " + dealer.dealerHand.toString());
      interpretDeal();
      playerHand.clear();
      dealer.dealerHand.clear();
      if (payout > 0) System.out.println("You win!");
      else System.out.println("The Dealer wins!");
      System.out.println("Your balance has been changed by: " + payout);
      player.changeBal(payout);
      System.out.println("Your new balance is: " + player.getBal());
      if (endgame()) done = true;
    }
  }
  public CasinoWar(Player p) {
    player = p;
    dealer = new Dealer();
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    playerHand = new Hand();
  }
  public void deal() {
    playerHand.add(shoe.remove(shoe.getRandomCard()));
    dealer.dealerHand.add(shoe.remove(shoe.getRandomCard()));
  }
  public void bet() {
    System.out.println(EB);
    bet = Double.parseDouble(in.nextLine());
    if (bet > player.getBal()) bet = player.getBal();
  }
  public boolean endgame() {
    System.out.println(PA);
    boolean output = true;
    if (player.getBal() == 0) output = true;
    else if (in.nextLine().equals("y")) output = false;
    return output;
  }
  public void interpretDeal() {
    int curP = playerHand.get(0).getwarV();
    int curD = dealer.dealerHand.get(0).getwarV();
    if (curP == curD) war();
    else if (curP > curD) payout = bet;
    else payout = bet * -1;
  }
  public void warDealInterpret() {
    int curP = playerHand.get(0).getwarV();
    int curD = dealer.dealerHand.get(0).getwarV();
    if (curP == curD) war();
    else if (curP > curD) payout = bet;
    else payout = warBet * -1;
  }
  public void war() {
    warBet = bet;
    boolean done = false;
    while (!done) {
      System.out.println(WAR);
      String answer = in.nextLine();
      if (answer.equals("war")) {
        warBet = warBet + bet;
        for (int i = 0; i < 3; i++) {
          System.out.println(shoe.remove(shoe.getRandomCard()).toString() + " was burned.");
        }
        playerHand.clear();
        dealer.dealerHand.clear();
        deal();
        System.out.println("This is your new card: " + playerHand.toString());
        System.out.println("This is the dealer's new card: " + dealer.dealerHand.toString());
        warDealInterpret();
      }
      else if (answer.equals("surrender")) {
        payout = bet * .5 * -1;
      }
      if (payout != 0) done = true;
    }
  }
}
