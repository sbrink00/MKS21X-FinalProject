import java.util.ArrayList;
import java.util.Scanner;
public class Blackjack{

  private class Dealer{
    private Hand hand;
    public Dealer(){
      hand = new Hand();
    }
  }
  private ArrayList<Hand> playerHands;
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
  private String HSD = "Do you want to hit, stand, or double?";//Hit or Stand
  private String CP = "Do you want to continue playing blackjack?";//Continue Playing
  private String YN = "Enter 'y' for yes and 'n' for no: ";//Yes or No


  public Blackjack(){
    player = new Player(1000);
    dealer = new Dealer();
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    playerSum =0;
    dealerSum = 0;
    dealerBlackjack = false;
    playerBlackjack = false;
    dealerBust = false;
    playerBust = false;
    playerHands = new ArrayList<Hand>();
    playerHands.add(new Hand());
  }

  public void run(){
    boolean done = false;
    while(!done){
      bet();
      deal();
      if (!playerBlackjack()){
        playerPlay();
        dealerPlay();
      }
      payout();
      if (!endGame()) done = true;
    }
  }

  public void bet(){
    System.out.println(EB);
    double terminalBet = Double.parseDouble(in.nextLine());
    bet = terminalBet;
    player.changeBal(-1 * bet);
    System.out.println("Your balance is: " + player.getBal());
  }

  public void deal(){
    Card c1 = shoe.getRandomCard();
    playerHands.get(0).add(shoe.remove(c1));
    Card c2 = shoe.getRandomCard();
    playerHands.get(0).add(shoe.remove(c2));
    System.out.println("your starting hand is: " + player.getHand());
    Card c3 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c3));
    Card c4 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c4));
    c4.setHidden(true);
    playerSum = player.getHand().sumValues();
    dealerSum = dealer.hand.sumValues();
    System.out.println("the dealers starting hand is: " + dealer.hand);
    System.out.println("--------------------------------------------------------------");
  }

  public boolean playerBlackjack(){
    if (playerHands.get(0).isBlackjack()){
      System.out.println("You got blackjack, congrats!!");
      return true;
    }
    return false;
  }

  public void playerPlay(){
    if (playerHands.get(0).isBlackjack()){
      System.out.println("You got blackjack, congrats!!");
    }














    if (playerHands.get(0).splittable()){
      System.out.println("Do you want to split? Enter 'y' for yes and 'n' for no.");
      String s = in.nextLine();
      if (s.equals("y")){
        playerHands.add(new Hand());
        playerHands.get(1).add(playerHands.get(0).remove(1));
        playerHands.get(0).add(shoe.remove(shoe.getRandomCard()));
        playerHands.get(0).add(shoe.remove(shoe.getRandomCard()));
        for (int idx = 0; idx < playerHands.size(); idx ++){
          if
        }
      }
    }
    while (!stand && !playerBlackjack && !playerBust){
      System.out.println(HSD);
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
      else if (hos.equals("double")){
        Double();
        if (!playerBust) stand = true;
      }
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
    if (dealerSum == 21){
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
    System.out.println("player total: " + player.getHand().sumValues());
    System.out.println("dealer total: " + dealer.hand.sumValues());
    System.out.println("Type anything when you are ready to reveal the final results");
    String Final = in.nextLine();
    System.out.println("The dealer's final hand is: " + dealer.hand);
    System.out.println("Your final hand is: " + player.getHand());
    if (playerBlackjack) player.changeBal(bet * 2.5);
    else if (!playerBust && dealerBust) player.changeBal(bet * 2);
    else if (!playerBust && !dealerBust && playerSum > dealerSum) player.changeBal(bet * 2);
    else if (!playerBust && !dealerBust && playerSum == dealerSum) player.changeBal(bet);
    else if (playerBust && dealerBust) player.changeBal(bet);
    System.out.println("Your new balance is: " + player.getBal());
  }

  public boolean endGame(){
    player.getHand().clear();
    dealer.hand.clear();
    playerSum = 0;
    dealerSum = 0;
    playerBlackjack = false;
    dealerBlackjack = false;
    playerBust = false;
    dealerBust = false;
    System.out.println("Do you want to continue playing blackjack?");
    System.out.println("Enter y for yes and n for no");
    String name = in.nextLine();
    if (name.equals("n") || player.getBal() < 0) return false;
    return true;
  }

  public void Double(){
    player.changeBal(-1 * bet);
    bet *= 2;
    System.out.println("Your new balance is: " + player.getBal());
    System.out.println("Type and enter anything to recieve your final card");
    String finalCard = in.nextLine();
    player.getHand().add(shoe.remove(shoe.getRandomCard()));
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
  }

  /*public void splitTester(){
    Hand other = new Hand();
    player.setHand(other);
    player.getHand().add(new Card(8, 'S'));
    player.getHand().add(new Card(8, 'C'));
    System.out.println(player.getHand());
    split();
  }

  public void split(){
    splitHand.add(new Hand());
    splitHand.add(new Hand());
    splitHand.get(0).add(player.getHand().get(0));
    splitHand.get(0).add(shoe.remove(shoe.getRandomCard()));
    splitHand.get(1).add(player.getHand().get(1));
    splitHand.get(1).add(shoe.remove(shoe.getRandomCard()));
    System.out.println(splitHandToString());
  }*/

  public String phToString(){ //player hand toString.
    if (playerHands.size() == 0) return "[]";
    if (playerHands.size() == 1) return playerHands.get(0).toString();
    String output = "[";
    for (int idx = 0; idx < playerHands.size(); idx ++){
      output += playerHands.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }


}
