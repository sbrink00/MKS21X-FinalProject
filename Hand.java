import java.util.ArrayList;
public class Hand extends CardList{
  //private ArrayList<Card> cards;

  private boolean wasDoubled;
  private double bet;

  //about to do poker hands. Will write functions
  //that return booleans based on whether or not the
  //hand contains/is the given pokerHand.

  public boolean pair(){
    for (int idx = 0; idx < size() - 1; idx ++){
      if (get(idx).getNum() == get(idx + 1).getNum()) return true;
    }
    return false;
  }















  public Hand(){
    initializeCards();
    wasDoubled = false;
    bet = 0;
  }
  public boolean isFullHouse() {
    return true;
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
