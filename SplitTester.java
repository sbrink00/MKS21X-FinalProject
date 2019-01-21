public class SplitTester{
  public static void main(String[]args){
    Blackjack blackjack = new Blackjack(new Player(1000));
    blackjack.bet();
    blackjack.splitAdd();
    blackjack.playerPlay();
    blackjack.dealerPlay();
    blackjack.payout();
  }
}
