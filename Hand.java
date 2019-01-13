import java.util.ArrayList;
public class Hand extends CardList{
  //private ArrayList<Card> cards;
  private boolean blackjack;
  public Hand(){
    initializeCards();
    blackjack = false;
  }

  public boolean isBlackjack(){
    if (size() == 2 && sumValues() == 21) return true;
    return false;
  }

  public boolean splittable(){
    if (size() == 2 && get(0).equalsNumber(get(1))) return true;
    return false;
  }

}
