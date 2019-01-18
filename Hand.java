import java.util.ArrayList;
public class Hand extends CardList{
  //private ArrayList<Card> cards;

  private boolean wasDoubled;
  private double bet;

  //about to do poker hands. Will write functions
  //that return booleans based on whether or not the
  //hand contains/is the given pokerHand.



  public boolean twoPair(){
    int index = 0;
    boolean cond1 = false;
    boolean cond2 = false;
    boolean found  = false;
    for (int idx = 0; idx < size() && !found; idx ++){
      if (get(idx).getNum() == get(idx + 1).getNum()){
        cond1 = true;
        index = idx + 2;
        found = true;
      }
    }
    if (index < size() - 1){
      for (int idx2 = index; idx2 < size() - 1; idx2 ++){
        if (get(idx2).getNum() == get(idx2 + 1).getNum()) cond2 = true;
      }
    }
    return cond1 && cond2;
  }

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
