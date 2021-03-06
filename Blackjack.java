//this is the blackjack class
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
  private boolean dealerBlackjack, dealerBust;


  public Blackjack(Player p){
    player = p;
    dealer = new Dealer();
    shoe = new Shoe(6);
    in = new Scanner(System.in);
    dealerSum = 0;
    bet = 0;
    dealerBlackjack = false;
    dealerBust = false;
    playerHands = new ArrayList<Hand>();
    playerHands.add(new Hand());
  }

  //runs the blackjack game
  public void run(){
    System.out.println("You are now playing blackjack.");
    System.out.println("Your balance is: " + player.getBal());
    System.out.println("------------------------------------------------------");
    boolean done = false;
    while(!done){
      bet();
      deal();
      if (!playerBlackjack()){
        playerPlay();
        dealerPlay();
      }
      payout();
      replaceShoe();
      if (!endGame()) done = true;
    }
  }

  //replaces the shoe if it gets too small
  public void replaceShoe(){
    if (shoe.size() < 20) shoe = new Shoe(6);
  }


  //prompts the user to enter a bet until a valid one is inputed.
  public void bet(){
    while (bet <= 0 || bet > player.getBal()){
      System.out.println("Please enter your bet. It must be a positive number with up to two decimal points\nand must be less than or equal to your balance.");
      try {
        double terminalBet = Double.parseDouble(in.nextLine());
        bet = terminalBet;
      }
      catch (NumberFormatException e){
        System.out.println("please enter a number with up to two decimal points.");
      }
    }
    player.changeBal(-1 * bet);
    System.out.println("Your balance is: " + player.getBal());
  }

  //deals out the cards
  public void deal(){
    playerHands.get(0).add(shoe.remove(shoe.getRandomCard()));
    playerHands.get(0).add(shoe.remove(shoe.getRandomCard()));
    System.out.println("your starting hand is: " + playerHands.get(0));
    dealer.hand.add(shoe.remove(shoe.getRandomCard()));
    dealer.hand.add(shoe.remove(shoe.getRandomCard()));
    dealer.hand.get(1).setHidden(true);
    System.out.println("the dealers starting hand is: " + dealer.hand);
    System.out.println("--------------------------------------------------------------");
  }

  //method that allows the player to hit, stand, double, or split
  //according to their wishes and the rules of blackjack.
  public boolean playerBlackjack(){
    if (playerHands.get(0).isBlackjack()){
      System.out.println("You got blackjack, congrats!!");
      return true;
    }
    return false;
  }

  public void playerPlay(){
    if (playerHands.get(0).splittable()){
      System.out.println("Do you want to split this hand? Enter 'y' for yes and 'n' for no.");
      String s = in.nextLine();
      if (s.equals("y")){
        playerHands.add(new Hand());
        playerHands.get(1).add(playerHands.get(0).remove(1));
        playerHands.get(0).add(shoe.remove(shoe.getRandomCard()));//shoe.remove(shoe.getRandomCard()));
        playerHands.get(1).add(shoe.remove(shoe.getRandomCard()));//shoe.remove(shoe.getRandomCard()));
        player.changeBal(-1 * bet);
      }
      System.out.println("Your new hand is: " + phToString());
      if (playerHands.size() > 1){
        for (int idx = 0; idx < 2 && playerHands.size() < 4; idx ++){
          int handIndex;
          if (idx == 0) handIndex = 0;
          if (idx == 1) handIndex = playerHands.size() - 1;
          if (playerHands.get(idx).splittable()){
            System.out.println("Do you want to split hand "+(idx+1)+"? Enter 'y' for yes and 'n' for no.");
            s = in.nextLine();
            if (s.equals("y")){
              playerHands.add(idx + 1, new Hand());
              playerHands.get(idx + 1).add(playerHands.get(idx).remove(1));
              playerHands.get(idx).add(shoe.remove(shoe.getRandomCard()));//shoe.remove(shoe.getRandomCard()));
              playerHands.get(idx + 1).add(shoe.remove(shoe.getRandomCard()));
              System.out.println("Your new hand is: " + phToString());
              player.changeBal(-1 * bet);
            }
          }
        }
      }
    }
    setHandBets();
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
        if (!hasDoubled) System.out.println("Do you want to hit, stand, or double?");
        else System.out.println("Do you want to hit or stand?");
        String hos = in.nextLine();
        if (hos.equals("hit")){
          temp.add(shoe.remove(shoe.getRandomCard()));
          System.out.println("Your new hand is: " + phToString());
          setAces(idx);
          if (temp.sum() > 21) bust = true;
          if (temp.sum() == 21) stand = true;
        }
        else if (hos.equals("stand")) stand = true;
        else if (hos.equals("double")){
          playerHands.set(idx, temp);
          if (Double(idx)) stand = true;
          hasDoubled = true;
          temp = playerHands.get(idx);
        }
      }
      playerHands.set(idx, temp);
      System.out.println("You have finished playing on Hand " + (idx + 1) + ". Your new hand is: " + phToString());
    }
      System.out.println("Your final hand is: " + phToString());
      System.out.println("--------------------------------------------------------------");
  }

  //has the dealer hit until he hits a soft 17 (a 17 that can include an ace).
  public void dealerPlay(){
    dealerSum = dealer.hand.sumValues();
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

  //pays the user if they win.
  public void payout(){
    if (playerHands.size() == 1) System.out.println("player total: " + playerHands.get(0).sumValues());
    System.out.println("dealer total: " + dealer.hand.sumValues());
    System.out.println("Type anything when you are ready to reveal the final results");
    String Final = in.nextLine();
    System.out.println("The dealer's final hand is: " + dealer.hand);
    System.out.println("Your final hand is: " + phToString());
    for (int idx = 0; idx < playerHands.size(); idx ++){
      Hand temp = playerHands.get(idx);
      boolean bj = temp.isBlackjack();
      int psum = temp.sum();
      double tempBet = playerHands.get(idx).bet();
      if (bj && dealerBlackjack) player.changeBal(tempBet);
      else if (bj && !dealerBlackjack) player.changeBal(tempBet*2.5);
      else if (!dealerBust && psum < 22 && psum == dealerSum) player.changeBal(tempBet);
      else if (dealerBust && psum < 22) player.changeBal(tempBet*2);
      else if (!dealerBust && psum < 22 && (psum > dealerSum)) player.changeBal(tempBet*2);
    }
    System.out.println("Your new balance is: " + player.getBal());
  }

  //resets the game and asks if the player wants to play again
  public boolean endGame(){
    for (int idx = 0; idx < playerHands.size(); idx ++){
      playerHands.get(idx).clear();
    }
    dealer.hand.clear();
    dealerSum = 0;
    dealerBlackjack = false;
    dealerBust = false;
    bet = 0;
    System.out.println("Do you want to continue playing blackjack?");
    System.out.println("Enter y for yes and n for no");
    String continuE = in.nextLine();
    if (continuE.equals("n") || player.getBal() <= 0) return false;
    return true;
  }

  //if the player wishes to double this method is called
  public boolean Double(int index){
    if (playerHands.get(index).sum() > 11 || playerHands.get(index).size() > 2){
      System.out.println("You can't double if the total of your hand is over 11 or you have already hit.");
      return false;
    }
    else{
      player.changeBal(-1 * bet);
      System.out.println("Your new balance is: " + player.getBal());
      System.out.println("Type and enter anything to recieve your final card");
      String finalCard = in.nextLine();
      playerHands.get(index).add(shoe.remove(shoe.getRandomCard()));
      setAces(index);
      playerHands.get(index).setBet(2 * bet);
      playerHands.get(index).setWasDoubled(true);
      return true;
    }
  }

  //method containing a for loop that changes aces from 11 to 1 if
  //the sum is over 21
  public void setAces(int index){
    Hand temp = playerHands.get(index);
    if (temp.sum() > 21){
      for (int idx = 0; idx < temp.size() && temp.sum() > 21; idx ++){
        Card ace = new Card(1, 'S');
        if (temp.get(idx).equalsNumber(ace)){
          temp.get(idx).setVal(1);
        }
      }
      playerHands.set(index, temp);
    }
  }

  //sets the bet for each hand the player has.
  //this method exists because multiple hands with different
  //bet values can exist because of splitting and doubling.
  public void setHandBets(){
    for (int idx = 0; idx < playerHands.size(); idx ++){
      playerHands.get(idx).setBet(bet);
    }
  }

  //method used in SplitTester
  public void splitAdd(){
    playerHands.get(0).add(new Card(5, 'C'));
    playerHands.get(0).add(new Card(5, 'D'));
    System.out.println("Your hand is: " + phToString());
  }

  //prints out the players hand.
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
