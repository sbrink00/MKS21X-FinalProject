import java.util.ArrayList;
public class Hand extends CardList{
  //private ArrayList<Card> cards;

  private boolean wasDoubled;
  private double bet;

  //constructor
  public Hand(){
    initializeCards();
    wasDoubled = false;
    bet = 0;
  }

  //the following methods return true if the hand that
  //calls them is/contains the hand they are checking for.
  //For example, if a royal flush called the royalFlush() method
  //it would return true, but if it called the pair methods
  //it would return false.
  public boolean royalFlush(){
    return straightFlush() && get(0).getNum() == 10;
  }

  public boolean straightFlush(){
    return flush() && straight();
  }

  public boolean four(){
    for (int idx = 0; idx < size() - 3; idx ++){
      int val = get(idx).getNum();
      int val2 = get(idx + 1).getNum();
      int val3 = get(idx + 2).getNum();
      int val4 = get(idx + 3).getNum();
      if (val == val2 && val == val3 && val == val4) return true;
    }
    return false;
  }

  public boolean fullHouse(){
    if (subhand(0, 3).three()){
      Hand tres = subhand(0, 3);
      Hand dos = subhand(3, 5);
      return tres.three() && dos.pair();
    }
    else{
      Hand tres = subhand(2, 5);
      Hand dos = subhand(0, 2);
      return tres.three() && dos.pair();
    }
  }

  public boolean flush(){
    for (int idx = 0; idx < size() - 1; idx ++){
      if (get(idx).suit() != get(idx + 1).suit()) return false;
    }
    return true;
  }

  public boolean straight(){
    for (int idx = 0; idx < size() - 1; idx ++){
      int val = get(idx).getNum();
      int next = get(idx + 1).getNum();
      if (val != next - 1) return false;
    }
    return true;
  }

  public boolean three(){
    for (int idx = 0; idx < size() - 2; idx ++){
      int val = get(idx).getNum();
      if (val == get(idx + 1).getNum() && val == get(idx + 2).getNum()) return true;
    }
    return false;
  }

  public boolean twoPair(){
    int index = 0;
    boolean cond1 = false;
    boolean cond2 = false;
    boolean found  = false;
    for (int idx = 0; idx < size() - 1 && !found; idx ++){
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

  public boolean pairJs(){
    Card c = new Card(2, 'S');
    for (int idx = 0; idx < size() - 1; idx ++){
      if (get(idx).getNum() == get(idx + 1).getNum()){
        c = get(idx);
      }
    }
    return c.getNum() > 10;
  }

  public boolean pair(){
    for (int idx = 0; idx < size() - 1; idx ++){
      if (get(idx).getNum() == get(idx + 1).getNum()) return true;
    }
    return false;
  }

  //generates a subhand based on indices given.
  //used in fullHouse() method.
  public Hand subhand(int idx1, int idx2){//idx1 is inclusive, idx2 is exclusive.
    Hand output = new Hand();
    try{
      for (int idx = idx1; idx < idx2; idx ++){
        output.add(get(idx));
      }
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("idx1 has to be >= 0 and idx2 has to be <= size()");
      e.printStackTrace();
    }
    return output;
  }

  //checks a hand to see if it's blackjack
  public boolean isBlackjack(){
    if (size() == 2 && sumValues() == 21) return true;
    return false;
  }

  //returns the sum of the values of the cards in the hand.
  public int sum() {return sumValues();}

  //returns whether or not the hand busted.
  public boolean bust(){
    if (size() > 21) return true;
    return false;
  }

  public boolean splittable(){
    if (size() == 2 && get(0).equalsNumber(get(1))) return true;
    return false;
  }

  //the following methods are accessor and mutator methods for
  //certain properties the hand has.
  public boolean wasDoubled() {return wasDoubled;}
  public void setWasDoubled(boolean arg) {wasDoubled = arg;}
  public void setBet(double newBal) {bet = newBal;}
  public double bet() {return bet;}

}
