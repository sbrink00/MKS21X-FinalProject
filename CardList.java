import java.util.Random;
import java.util.ArrayList;
public abstract class CardList{

  private ArrayList<Card> cards;
  private Random r;

  public void initializeCards() {cards = new ArrayList<Card>();}
  public void initializeRandom() {r = new Random();}

  public ArrayList<Card> getCards(){return cards;}

  public Card get(int index) {return cards.get(index);}

  public void add(Card c) {cards.add(c);}

  public int size() {return cards.size();}

  public void clear() {cards.clear();}

  public Card remove(Card c){
    cards.remove(c);
    return c;
  }
  /*public void orderCards() {
    Card switcher;
    for (int i = 1; i < this.size(); i++) {
      switcher = this.get(i);
      int i2 = i;
      while ((i2 > 0) && (switcher < this.get(i2 - 1)) {
        this.get(i2) = this.get(i2 - 1);
        i2--;
      }
      this.get(i2) = switcher;
    }
  }*/

  public void sort(){
    for (int idx = 0; idx < size(); idx ++){
      int index = idx;
      for (int idx2 = idx; idx2 < size(); idx2 ++){
        if (get(idx2).getNum() < get(index).getNum()){
          index = idx2;
        }
      }
      swap(idx, index);
    }
  }





  public void add(int index, Card c) {cards.add(index, c);}

  public Card remove(int index){return cards.remove(index);}

  public boolean contains(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equals(cards.get(idx))) return true;
    }
    return false;
  }

  public boolean containsNumber(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equalsNumber(cards.get(idx))) return true;
    }
    return false;
  }

  public int indexOf(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equals(cards.get(idx))) return idx;
    }
    return -1;
  }

  public int indexOfNumber(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equalsNumber(cards.get(idx))) return idx;
    }
    return -1;
  }

  public Card set(int index, Card c){
    Card output = cards.get(index);
    cards.set(index, c);
    return output;
  }


  public void swap(int idx1, int idx2){
    Card temp = get(idx1);
    set(idx1, get(idx2));
    set(idx2, temp);
  }

  public void shuffle(){
    for (int idx = 0; idx < size(); idx ++){
      int idxToSwapWith = r.nextInt(size());
      swap(idx, idxToSwapWith);
    }
  }

  public Card getRandomCard(){
    int idx = r.nextInt(size());
    return get(idx);
  }

  public int sumValues(){
    int sum = 0;
    for (int idx = 0; idx < size(); idx ++){
      sum += get(idx).getValue();
    }
    return sum;
  }

  public String toString(){
    if (size() == 0) return "[]";
    String output = "[";
    for (int idx = 0; idx < cards.size(); idx ++){
      output += cards.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }



}
