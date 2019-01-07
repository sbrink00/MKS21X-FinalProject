import java.util.Random;
import java.util.ArrayList;
public class Deck extends CardList{

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

  /*public void shuffle(){
    for (int idx = 0; idx < size(); idx ++){
      int idxToSwapWith = r.nextInt(size());
      swap(idx, idxToSwapWith);
    }
  }*/

  /*public void swap(int idx1, int idx2){
    Card temp = get(idx1);
    set(idx1, get(idx2));
    set(idx2, temp);
  }*/

  //public ArrayList<Card> data() {return data;}


  /*public String toString(){
    String output = "[";
    for (int idx = 0; idx < data.size(); idx ++){
      output += data.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }*/
}
