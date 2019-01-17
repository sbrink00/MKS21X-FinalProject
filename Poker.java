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

  public void run(){
    bet();
    deal();
    swap();
    //payout();
    //endgame();
  }

  public void bet(){
    boolean valid = false;
    while (!valid){
      System.out.println("Please enter your bet. It must be a number with up to two decimals\n that is less than or equal to your balance");
      try{
        Double userBet = Double.parseDouble(in.nextLine());
        if (userBet < player.getBal()) valid = true;
        bet = userBet;
        player.changeBal(-1 * bet);
      }
      catch (NumberFormatException e){
        System.out.println("That is an invalid value to bet");
      }
    }
  }

  public void deal(){
    for (int idx = 0; idx < 5; idx ++){
      hand.add(shoe.remove(shoe.getRandomCard()));
    }
    System.out.println("Your new hand is: " + hand);
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
    System.out.println(indexsToString(indexs));
  }


  public String indexsToString(ArrayList<Integer> ary){
    String output = "[";
    for (int idx = 0; idx < ary.size(); idx ++){
      output += ary.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }
}
