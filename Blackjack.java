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
  }

  public void run(){
    bet();
    //deal();
    //playerPlay();
    //dealerPlay();
  }

  public double bet(){
    System.out.println(EB);
  }


}
