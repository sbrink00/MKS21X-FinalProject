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
  public boolean playerBlackjack, dealerBlackjack;
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
  }

  public void run(){
    bet();
    deal();
    playerPlay();
    dealerPlay();
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
    System.out.println("your hand is: " + player.getHand());
    Card c3 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c3));
    Card c4 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c4));
    c4.setHidden(true);
    System.out.println("the dealers hand is: " + dealer.hand);
  }

  public boolean playerPlay(){
    boolean stand = false;
    boolean blackjack = false;
    boolean bust = false;
    if (player.getHand().sumValues() == 21){
      System.out.println("You got blackjack, congrats!!");
      playerBlackjack = true;
      return true;
    }
    while (!stand && !blackjack && !bust){
      System.out.println(HS);
      String hos = in.nextLine();
      if (hos.equals("hit")){
        player.getHand().add(shoe.remove(shoe.getRandomCard()));
        System.out.println("Your new hand is: " + player.getHand());
        playerSum = player.getHand().sumValues();
        if (playerSum > 21) bust = true;
        if (playerSum == 21) stand = true;
      }
      else if (hos.equals("stand")) stand = true;
    }
    System.out.println("Your final hand is: " + player.getHand());
    if (bust) System.out.println("You busted cause you're trash");
    return false;
  }

  public boolean dealerPlay(){
    boolean stand = false;
    if (dealer.hand.sumValues() == 21){
      dealerBlackjack = true;
      System.out.println("The dealer got blackjack");
      return true;
    }
    while (!stand && dealer.hand.sumValues() < 17){
      dealer.hand.add(shoe.remove(shoe.getRandomCard()));
      System.out.println("The dealer's new hand is: " + dealer.hand);
      if (dealer.hand.sumValues() > 21) System.out.println("The dealer busted");
    }
    System.out.println("The dealer's final hand is: " + dealer.hand);
    System.out.println("Your final hand is: " + player.getHand());
    System.out.println("The dealer's final total is: " + dealer.hand.sumValues());
    System.out.println("Your final total is: " + player.getHand().sumValues());
    return false;
  }


}
