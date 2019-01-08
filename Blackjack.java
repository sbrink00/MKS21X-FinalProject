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
  }

  public void run(){
    bet();
    deal();
    //playerPlay();
    //dealerPlay();
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
    System.out.println(player.getHand());
    Card c3 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c3));
    Card c4 = shoe.getRandomCard();
    dealer.hand.add(shoe.remove(c4));
    c4.setHidden(true);
    System.out.println(dealer.hand);
  }


}
