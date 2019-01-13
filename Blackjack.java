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
  //private String EB = "Please enter your bet: "; //Enter Bet
  //private String HSD = "Do you want to hit, stand, or double?";//Hit or Stand
  //private String CP = "Do you want to continue playing blackjack?";//Continue Playing
  //private String YN = "Enter 'y' for yes and 'n' for no: ";//Yes or No

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
    System.out.println("Please enter your bet");
    double terminalBet = Double.parseDouble(in.nextLine());
    bet = terminalBet;
    player.changeBal(-1 * bet);
    System.out.println("Your balance is: " + player.getBal());
  }

  public void deal(){
    Card c1 = new Card(5, 'S');//shoe.getRandomCard();
    playerHands.get(0).add(shoe.remove(c1));
    Card c2 = new Card(5, 'C');//shoe.getRandomCard();
    playerHands.get(0).add(shoe.remove(c2));
    System.out.println("your starting hand is: " + playerHands.get(0));
    Card c3 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c3));
    Card c4 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c4));
    c4.setHidden(true);
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
    for (int idx = 0; idx < playerHands.size() && playerHands.size() < 5; idx ++){
      if (playerHands.get(idx).splittable()){
        System.out.println("Do you want to split? Enter 'y' for yes and 'n' for no.");
        String s = in.nextLine();
        if (s.equals("y")){
          playerHands.add(new Hand());
          playerHands.get(1).add(playerHands.get(0).remove(1));
          playerHands.get(0).add(shoe.remove(shoe.getRandomCard()));
          playerHands.get(1).add(shoe.remove(shoe.getRandomCard()));
          idx = 0;
        }
        System.out.println("Your new hand is: " + phToString());
      }
    }
    for (int idx = 0; idx < playerHands.size(); idx ++){
      Hand temp = playerHands.get(idx);
      System.out.println("You are now playing on hand " + (idx+1));
      boolean stand = false;
      boolean blackjack = false;
      boolean bust = false;
      if (temp.isBlackjack()){
        blackjack = true;
        System.out.println("You got blackjack, Congrats!");
      }
      while (!stand && !blackjack && !bust){
        boolean hasDoubled = false;
        if (!hasDoubled) System.out.println("Do you want to hit, stand, or double");
        else System.out.println("do you want to hit or stand");
        String hos = in.nextLine();
        if (hos.equals("hit")){
          temp.add(shoe.remove(shoe.getRandomCard()));
          System.out.println("Your new hand is: " + phToString());
          if (temp.sum() > 21){
            for (int index = 0; index < temp.size() && playerSum > 21; index ++){
              Card ace = new Card(1, 'S');
              if (temp.get(index).equalsNumber(ace)){
                temp.get(index).setVal(1);
              }
            }
          }
          if (temp.sum() > 21) bust = true;
          if (temp.sum() == 21) stand = true;
        }
        else if (hos.equals("stand")) stand = true;
        else if (hos.equals("double")){
          Double();
          hasDoubled = true;
          if (!(temp.sum() > 21)) stand = true;
          else bust = true;
        }
      }
      playerHands.set(idx, temp);
    }
      System.out.println("Your final hand is: " + phToString());
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
    if (playerHands.size() == 1) System.out.println("player total: " + playerHands.get(0).sumValues());
    System.out.println("dealer total: " + dealer.hand.sumValues());
    System.out.println("Type anything when you are ready to reveal the final results");
    String Final = in.nextLine();
    System.out.println("The dealer's final hand is: " + dealer.hand);
    System.out.println("Your final hand is: " + phToString());
    if (playerBlackjack) player.changeBal(bet * 2.5);
    else if (!playerBust && dealerBust) player.changeBal(bet * 2);
    else if (!playerBust && !dealerBust && playerSum > dealerSum) player.changeBal(bet * 2);
    else if (!playerBust && !dealerBust && playerSum == dealerSum) player.changeBal(bet);
    else if (playerBust && dealerBust) player.changeBal(bet);
    System.out.println("Your new balance is: " + player.getBal());
  }

  public boolean endGame(){
    for (int idx = 0; idx < playerHands.size(); idx ++){
      playerHands.get(idx).clear();
    }
    dealer.hand.clear();
    dealerSum = 0;
    dealerBlackjack = false;
    dealerBust = false;
    System.out.println("Do you want to continue playing blackjack?");
    System.out.println("Enter y for yes and n for no");
    String continuE = in.nextLine();
    if (continuE.equals("n") || player.getBal() < 0) return false;
    return true;
  }

  public void Double(int index){
    player.changeBal(-1 * bet);
    bet *= 2;
    System.out.println("Your new balance is: " + player.getBal());
    System.out.println("Type and enter anything to recieve your final card");
    String finalCard = in.nextLine();
    playerHands.get(index).add(shoe.remove(shoe.getRandomCard()));
    if (playerHands.get(index).sum() > 21){
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
