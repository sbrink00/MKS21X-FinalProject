import java.util.Scanner;
public class Blackjack{

  private class Dealer{
    private Hand hand;
    public Dealer(){
      hand = new Hand();
    }
  }

  private Dealer dealer;
  private Player player;
  private double bet;
  private Shoe shoe;
  private Scanner in;
  public int playerSum, dealerSum;
  public boolean playerBlackjack, dealerBlackjack, playerBust, dealerBust;
  //the following strings are going to be used in the run function.
  //they are acronyms and will be explained with comments after the string
  private String EB = "Please enter your bet: "; //Enter Bet
  private String HS = "Do you want to hit or stand?";//Hit or Stand
  private String CP = "Do you want to continue playing blackjack?";//Continue Playing
  private String YN = "Enter 'y' for yes and 'n' for no: ";//Yes or No


  public Blackjack(){
    player = new Player(1000);
    dealer = new Dealer();
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    dealerBlackjack = false;
    playerBlackjack = false;
    dealerBust = false;
    playerBust = false;
  }

  public void run(){
    boolean done = false;
    while(!done){
      bet();
      deal();
      playerPlay();
      if (!playerBlackjack) dealerPlay();
      payout();
      player.getHand().clear();
      dealer.hand.clear();
      System.out.println("Do you want to continue playing blackjack?");
      System.out.println("Enter y for yes and n for no");
      String name = in.nextLine();
      if (name.equals("n") || player.getBal() == 0) done = true;
    }
  }

  public void bet(){
    System.out.println(EB);
    double terminalBet = Double.parseDouble(in.nextLine());
    bet = terminalBet;
    player.changeBal(-1 * bet);
  }

  public void deal(){
    Card c1 = shoe.getRandomCard();
    player.getHand().add(shoe.remove(c1));
    Card c2 = shoe.getRandomCard();
    player.getHand().add(shoe.remove(c2));
    System.out.println("your starting hand is: " + player.getHand());
    Card c3 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c3));
    Card c4 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c4));
    c4.setHidden(true);
    System.out.println("the dealers starting hand is: " + dealer.hand);
    System.out.println("--------------------------------------------------------------");
  }

  public void playerPlay(){
    boolean stand = false;
    if (player.getHand().sumValues() == 21){
      System.out.println("You got blackjack, congrats!!");
      playerBlackjack = true;
    }
    while (!stand && !playerBlackjack && !playerBust){
      System.out.println(HS);
      String hos = in.nextLine();
      if (hos.equals("hit")){
        player.getHand().add(shoe.remove(shoe.getRandomCard()));
        System.out.println("Your new hand is: " + player.getHand());
        playerSum = player.getHand().sumValues();
        if (playerSum > 21){
          for (int idx = 0; idx < player.getHand().size() && playerSum > 21; idx ++){
            Card temp = new Card(1, 'S');
            if (player.getHand().get(idx).equalsNumber(temp)){
              player.getHand().get(idx).setVal(1);
            }
            playerSum = player.getHand().sumValues();
          }
        }
        if (playerSum > 21) playerBust = true;
        if (playerSum == 21) stand = true;
      }
      else if (hos.equals("stand")) stand = true;
    }
    System.out.println("Your final hand is: " + player.getHand());
    if (playerBust) System.out.println("You busted cause you're trash");
    System.out.println("--------------------------------------------------------------");
  }

  public void dealerPlay(){
    for (int idx = 0; idx < dealer.hand.size(); idx ++){
      dealer.hand.get(idx).setHidden(false);
    }
    System.out.println("type and enter anything to reveal the dealers other card");
    String reveal = in.nextLine();
    System.out.println(dealer.hand);
    boolean stand = false;
    if (dealer.hand.sumValues() == 21){
      dealerBlackjack = true;
      System.out.println("The dealer got blackjack");
    }
    while (!stand && dealer.hand.sumValues() < 17){
      System.out.println("Type anything when you are ready for the dealer to hit again");
      String dealerHit = in.nextLine();
      dealer.hand.add(shoe.remove(shoe.getRandomCard()));
      dealerSum = dealer.hand.sumValues();
      System.out.println("The dealer's new hand is: " + dealer.hand);
      if (dealerSum > 21){
        for (int idx = 0; idx < dealer.hand.size() && dealerSum > 21; idx ++){
          Card temp = new Card(1, 'S');
          if (dealer.hand.get(idx).equalsNumber(temp)){
            dealer.hand.get(idx).setVal(1);
          }
          dealerSum = dealer.hand.sumValues();
        }
      }
      if (dealerSum > 21){
        System.out.println("The dealer busted");
        dealerBust = true;
      }
    }
    System.out.println("--------------------------------------------------------------");
  }

  public void payout(){
    System.out.println("Type anything when you are ready to reveal the final results");
    String Final = in.nextLine();
    System.out.println("The dealer's final hand is: " + dealer.hand);
    System.out.println("Your final hand is: " + player.getHand());
    if (playerBlackjack) player.changeBal(bet * 2.5);
    else if (!playerBust && dealerBust) player.changeBal(bet * 2);
    else if (!playerBust && !dealerBust && playerSum > dealerSum) player.changeBal(bet * 2);
    else if (!playerBust && !dealerBust && playerSum == dealerSum) player.changeBal(bet);
    System.out.println("Your new balance is: " + player.getBal());
  }


}
