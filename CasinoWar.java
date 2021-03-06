import java.util.*;
//Game, based off the card game war, is designed to return 99.27% of the users input money.
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
  private String EB = "Please enter your bet value. It must be a number with up to two decimal points that is less than or equal to your balance";
  private String PA = "Would you like to play again? <y/n>";
  private class Dealer {
    private Hand dealerHand;
    public Dealer() {
      dealerHand = new Hand();
    }
  }
  public void run() {
    System.out.println("You are now playing war.");
    System.out.println("Your balance is: " + player.getBal());
    System.out.println("------------------------------------------------------");
    boolean done = false;
    while (!done) {
      bet();
      deal();
      slowDown();
      System.out.println("------------------------------------------------");
      System.out.println("This is your card: " + playerHand.toString());
      System.out.println("This is the dealer's card: " + dealer.dealerHand.toString());
      interpretDeal();
      playerHand.clear();
      dealer.dealerHand.clear();
      slowDown2();
      System.out.println("------------------------------------------------");
      if (payout > 0) System.out.println("You win!");
      else System.out.println("The Dealer wins!");
      System.out.println("Your balance has been changed by: " + payout);
      player.changeBal(payout);
      System.out.println("Your new balance is: " + player.getBal());
      if (endgame()) done = true;
      System.out.println("------------------------------------------------");
    }
  }
  public CasinoWar(Player p) {
    player = p;
    dealer = new Dealer();
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    playerHand = new Hand();
  }
  //Deals one card to each entity.
  public void deal() {
    playerHand.add(shoe.remove(shoe.getRandomCard()));
    dealer.dealerHand.add(shoe.remove(shoe.getRandomCard()));
  }
  //Handles the user bet input.
  public void bet() {
    boolean done = false;
    while (!done){
      System.out.println(EB);
      try {
        double terminalBet = Double.parseDouble(in.nextLine());
        if (terminalBet < player.getBal() && terminalBet > 0){
          bet = terminalBet;
          done = true;
        }
      }
      catch (NumberFormatException e){
        System.out.println("Please enter a number with up to two decimal points.");
      }
    }
  }
  //Asks if the user would like to keep playing. If not, this instance of the game is terminated.
  public boolean endgame() {
    if (player.getBal() <= 0) {
      System.out.println("You're out of money!");
      return true;
    }
    System.out.println(PA);
    boolean output = true;
    if (in.nextLine().equals("y")) output = false;
    return output;
  }
  //Determines the payout based on the winners' bet and occurrances of war(). It determines the winner, or if a war is necessary.
  public void interpretDeal() {
    int curP = playerHand.get(0).getwarV();
    int curD = dealer.dealerHand.get(0).getwarV();
    if (curP == curD) war();
    else if (curP > curD) payout = bet;
    else payout = bet * -1;
  }
  //Determines payout if there is a war(), because the payouts change. A surrender causes the user to lose .5 of their bet, and a war win returns only their original bet.
  public void warDealInterpret() {
    int curP = playerHand.get(0).getwarV();
    int curD = dealer.dealerHand.get(0).getwarV();
    if (curP == curD) war();
    else if (curP > curD) payout = bet;
    else payout = warBet * -1;
  }
  //Two methods to slow down the use of the user input.
  public void slowDown() {
    System.out.println("Type anything to be dealt a card.");
    String check = in.nextLine();
  }
  public void slowDown2() {
    System.out.println("Type anything to reveal the results.");
    String check = in.nextLine();
  }
  //Next two methods are for demonstration of the war() method only.
  public void warTest() {
    dealer.dealerHand.add(new Card(1, 'S'));
    playerHand.add(new Card(1, 'S'));
  }
  public void warRun() {
    System.out.println("Hey Mr. K, you are now playing the War Test!");
    System.out.println("Your balance is: " + player.getBal());
    System.out.println("------------------------------------------------------");
    boolean done = false;
    while (!done) {
      bet();
      warTest();
      slowDown();
      System.out.println("------------------------------------------------");
      System.out.println("This is your card: " + playerHand.toString());
      System.out.println("This is the dealer's card: " + dealer.dealerHand.toString());
      interpretDeal();
      playerHand.clear();
      dealer.dealerHand.clear();
      slowDown2();
      System.out.println("------------------------------------------------");
      if (payout > 0) System.out.println("You win!");
      else System.out.println("The Dealer wins!");
      System.out.println("Your balance has been changed by: " + payout);
      player.changeBal(payout);
      System.out.println("Your new balance is: " + player.getBal());
      if (endgame()) done = true;
      System.out.println("------------------------------------------------");
    }
  }
  //Handles a tie in the original deal. Repeats depending on how many wars occur in sequence. It burns three cards before dealing one more.
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
      else {
        payout = bet * .5 * -1;
        System.out.println("You surrendered!");
      }
      if (payout != 0) done = true;
    }
  }
}
