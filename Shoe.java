/*This class will have two variables that will store cards.
The first will be an ArrayList of Decks. This is here to make
sure that the show has a certain number of complete decks, rather
than a random assortment of cards. This ensures that there's an equal
number of each card in the shoe when it is created.

However, in casinos the decks are intermixed so it's possible to
draw two of the same card in a row. Thus, there will be a second
ArrayList, this one made up of cards. This is what games like blackjack
will actually use to draw cards from*/

import java.util.ArrayList;
import java.util.Random;
public class Shoe{

  private ArrayList<Deck> tempData;
  private ArrayList<Card> cards;
  private Random r;

  public Shoe(int numDecks){
    r = new Random();
    tempData = new ArrayList<Deck>();
    cards = new ArrayList<Card>();
    for (int idx = 0; idx < numDecks; idx ++){
      tempData.add(new Deck());
    }
    convertToOneArray();
    shuffle();
  }

  public void convertToOneArray(){
    for (int idx = 0; idx < tempData.size(); idx ++){
      for (int idx2 = 0; idx2 < tempData.get(idx).data().size(); idx ++){
        cards.add(tempData.get(idx).data().get(idx2));
      }
    }
  }

  public void swap(int idx1, int idx2){
    Card temp = cards.get(idx1);
    cards.set(idx1, cards.get(idx2));
    cards.set(idx2, temp);
  }

  public void shuffle(){
    for (int idx = 0; idx < cards.size(); idx ++){
      int idxToSwapWith = r.nextInt(cards.size());
      swap(idx, idxToSwapWith);
    }
  }

  public String toString(){
    String output = "[";
    for (int idx = 0; idx < cards.size(); idx ++){
      output += cards.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }

}
