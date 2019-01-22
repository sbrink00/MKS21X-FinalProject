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
public class Shoe extends CardList{

  private ArrayList<Deck> tempData;

  //the constructor first fills tempData up with the desired
  //number of decks. It then converts the ArrayList of decks into
  //an ArrayList of cards and then shuffles them.
  public Shoe(int numDecks){
    initializeCards();
    initializeRandom();
    tempData = new ArrayList<Deck>();
    for (int idx = 0; idx < numDecks; idx ++){
      tempData.add(new Deck());
    }
    convertToOneArray();
    shuffle();
  }

  //takes all the cards in the decks in tempData
  //and moves them into cards.
  public void convertToOneArray(){
    for (int idx = 0; idx < tempData.size(); idx ++){
      for (int idx2 = 0; idx2 < tempData.get(idx).size(); idx2 ++){
        add(tempData.get(idx).get(idx2));
      }
    }
  }
}
