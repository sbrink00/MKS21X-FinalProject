//this is an abstract superclass for Deck, Shoe, and Hand.
//It takes an ArrayList of cards, which is what makes up all
//three of its subclasses. CardList is an abstract class because the
//implementation for many methods, such as getRandomCard() and toString()
//is the same for all subclasses.
import java.util.Random;
import java.util.ArrayList;
public abstract class CardList{

  private ArrayList<Card> cards;
  private Random r;

  public void initializeCards() {cards = new ArrayList<Card>();}
  public void initializeRandom() {r = new Random();}

  //returns the cards. This method is not used in any of the games.
  public ArrayList<Card> getCards(){return cards;}


  //the following methods exist so that other classes can access
  //methods that they might need.
  public Card get(int index) {return cards.get(index);}
  public void add(Card c) {cards.add(c);}
  public int size() {return cards.size();}
  public void clear() {cards.clear();}
  public Card remove(Card c){
    cards.remove(c);
    return c;
  }
  public void add(int index, Card c) {cards.add(index, c);}
  public Card remove(int index){return cards.remove(index);}

  //this method sorts the cards for poker.
  //this is useful in determining what hand the player has
  public void sort(){
    //this loop sets the ace's numbers to 14 because they are high in poker
    //and poker is the only game so far that requires the sort method.
    for (int idx = 0; idx < size(); idx ++){
      if (get(idx).getNum() == 1) get(idx).setNum(14);
    }
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

  //checks cards for a specific card (both number and suit).
  public boolean contains(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equals(cards.get(idx))) return true;
    }
    return false;
  }

  //checks cards for a specific card (only number).
  //if an ace is given as the parameter, it will check
  //for any aces, regardless of suit.
  public boolean containsNumber(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equalsNumber(cards.get(idx))) return true;
    }
    return false;
  }

  //returns first index of certain card.
  public int indexOf(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equals(cards.get(idx))) return idx;
    }
    return -1;
  }

  //returns first index of card with the
  //same number as the parameter.
  public int indexOfNumber(Card other) {
    for (int idx = 0; idx < size(); idx ++){
      if (other.equalsNumber(cards.get(idx))) return idx;
    }
    return -1;
  }

  //uses the ArrayList set method.
  public Card set(int index, Card c){
    Card output = cards.get(index);
    cards.set(index, c);
    return output;
  }

  //swaps two cards given their indices.
  public void swap(int idx1, int idx2){
    Card temp = get(idx1);
    set(idx1, get(idx2));
    set(idx2, temp);
  }

  //shuffles the deck.
  public void shuffle(){
    for (int idx = 0; idx < size(); idx ++){
      int idxToSwapWith = r.nextInt(size());
      swap(idx, idxToSwapWith);
    }
  }

  //returns a random card from cards.
  public Card getRandomCard(){
    int idx = r.nextInt(size());
    return get(idx);
  }

  //returns the sum of the values of the cards
  //in cards. This is used in blackjack.
  public int sumValues(){
    int sum = 0;
    for (int idx = 0; idx < size(); idx ++){
      sum += get(idx).getValue();
    }
    return sum;
  }

  //prints out cards.
  public String toString(){
    if (size() == 0) return "[]";
    String output = "[";
    for (int idx = 0; idx < cards.size(); idx ++){
      output += cards.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }



}
