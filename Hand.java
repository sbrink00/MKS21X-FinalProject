import java.util.ArrayList;
public class Hand extends CardList{
  //private ArrayList<Card> cards;

  private boolean wasDoubled;
  private double bet;


  public Hand(){
    initializeCards();
    wasDoubled = false;
    bet = 0;
  }
  public boolean isFullHouse() {

  }
  public boolean isBlackjack(){
    if (size() == 2 && sumValues() == 21) return true;
    return false;
  }

  public int sum() {return sumValues();}

  public boolean bust(){
    if (size() > 21) return true;
    return false;
  }

  public boolean splittable(){
    if (size() == 2 && get(0).equalsNumber(get(1))) return true;
    return false;
  }

  public boolean wasDoubled() {return wasDoubled;}
  public void setWasDoubled(boolean arg) {wasDoubled = arg;}
  public void setBet(double newBal) {bet = newBal;}
  public double bet() {return bet;}

}
