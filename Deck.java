import java.util.Random;
import java.util.ArrayList;
public class Deck extends CardList{

  //fills the deck up with one of each card using a nested for loop.
  public Deck(){
    initializeCards();
    initializeRandom();
    String suits = "CDHS";
    for (int idx = 0; idx < 4; idx ++){
      char current = suits.charAt(idx);
      for (int idx2 = 1; idx2 < 14; idx2 ++){
        add(new Card(idx2, current));
      }
    }
    shuffle();
  }
}
