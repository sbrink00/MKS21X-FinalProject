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

  public Card set(int index, Card c){
    Card output = cards.get(index);
    cards.set(index, c);
    return output;
  }

  public Card remove(Card c){
    cards.remove(c);
    return c;
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
    String output = "[";
    for (int idx = 0; idx < cards.size(); idx ++){
      output += cards.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }



}
