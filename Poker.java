import java.util.*;
public class Poker {
  private Player player;
  private double bet;
  private Deck deck;
  private Scanner in;
  private Hand hand;
  private String finalHand;

  public Poker(Player p) {
    player = p;
    deck = new Deck();
    in = new Scanner(System.in);
    hand = new Hand();
  }

  public void run(){
    System.out.println("You are now playing poker.");
    System.out.println("------------------------------------------------------");
    boolean done = false;
    while (!done){
      bet();
      deal();
      swap();
      hand.sort();
      determineHand();
      System.out.println("Your final hand is: " + finalHand);
      payout();
      if (!endgame()) done = true;
    }
  }

  public void bet(){
    boolean valid = false;
    while (!valid){
      System.out.println("Please enter your bet. It must be a number with up to two decimals\n that is less than or equal to your balance");
      try{
        Double userBet = Double.parseDouble(in.nextLine());
        if (userBet < player.getBal()){
          valid = true;
          bet = userBet;
          player.changeBal(-1 * bet);
        }
      }
      catch (NumberFormatException e){
        System.out.println("That is an invalid value to bet");
      }
    }
    System.out.println("--------------------------------------------------------");
  }

  public void deal(){
    for (int idx = 0; idx < 5; idx ++){
      hand.add(deck.remove(deck.getRandomCard()));
    }
    System.out.println("Your new hand is: " + hand);
    System.out.println("------------------------------------------------------");
  }

  public void swap(){
    String instructions = "It is now time to swap cards. You will be prompted to\n";
    instructions += "enter the indices of the cards you want to swap out one at a time.\n";
    instructions += "Once you have made all the swaps you want to enter 'done'";
    System.out.println(instructions);
    ArrayList<Integer> indexs = new ArrayList<Integer>();
    int idx = 0;
    boolean done = false;
    while (idx < 5 && !done){
      System.out.println("Please enter the index of the card you want to swap, starting with 0 as the first index");
      String badCard = in.nextLine();
      if (badCard.equals("done")) done = true;
      else{
        try{
          int index = Integer.parseInt(badCard);
          if (index > 4) System.out.println("Please enter an index that is greater than or equal to 0 and less than 5");
          else if (indexs.contains(index)) System.out.println("Please enter an index that you haven't already entered");
          else{
            indexs.add(index);
            idx ++;
          }
        }
        catch (NumberFormatException e){
          System.out.println("please either enter 'done' or a number");
        }
      }
    }
    for (int i = 0; i < indexs.size(); i ++){
      hand.set(indexs.get(i), deck.remove(deck.getRandomCard()));
    }
    System.out.println("----------------------------------------------------");
    System.out.println("Your new hand is: " + hand);
  }

  public void determineHand(){
    if (hand.royalFlush()) finalHand = "royal flush";
    else if (hand.straightFlush()) finalHand = "straight flush";
    else if (hand.four()) finalHand = "four of a kind";
    else if (hand.fullHouse()) finalHand = "full house";
    else if (hand.flush()) finalHand = "flush";
    else if (hand.straight()) finalHand = "straight";
    else if (hand.three()) finalHand = "three of a kind";
    else if (hand.twoPair()) finalHand = "two pair";
    else if (hand.pairJs()) finalHand = "jacks or better";
    else finalHand = "nothing";
  }

  /*this payout function uses a 9-6 jacks or better payout
  table as its guide. This is one of the best pay tables you
  will find in most casinos. If a player is using perfect strategy,
  they can expect the machine to return 99.54% of what they put
  into it. The values in this function are all adjusted up
  by one because in the bet function it subtracts from the
  player's balance.*/
  public void payout(){
    if (finalHand.equals("royal flush")) player.changeBal(801 * bet);
    else if (finalHand.equals("straight flush")) player.changeBal(51 * bet);
    else if (finalHand.equals("four of a kind")) player.changeBal(26 * bet);
    else if (finalHand.equals("full house")) player.changeBal(10 * bet);
    else if (finalHand.equals("flush")) player.changeBal(7 * bet);
    else if (finalHand.equals("straight")) player.changeBal(5 * bet);
    else if (finalHand.equals("three of a kind")) player.changeBal(4 * bet);
    else if (finalHand.equals("two pair")) player.changeBal(3 * bet);
    else if (finalHand.equals("jacks or better")) player.changeBal(2 * bet);
    System.out.println("Your new balance is: " + player.getBal());
  }

  public boolean endgame(){
    deck = new Deck();
    hand.clear();
    System.out.println("--------------------------------------------------------");
    System.out.println("Do you want to play again? <y/n>");
    String playAgain = in.nextLine();
    System.out.println("----------------------------------------------------------");
    if (playAgain.equals("n")) return false;
    return true;
  }

  public String indexsToString(ArrayList<Integer> ary){
    String output = "[";
    for (int idx = 0; idx < ary.size(); idx ++){
      output += ary.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }
}
