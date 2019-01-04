import java.util.Random;
import java.util.ArrayList;
public class Deck{
  private ArrayList<Card> data;
  Random r;

  public Deck(){
    data = new ArrayList<Card>();
    r = new Random();
    String suits = "CDHS";
    for (int idx = 0; idx < 4; idx ++){
      char current = suits.charAt(idx);
      for (int idx2 = 1; idx2 < 14; idx2 ++){
        data.add(new Card(idx2, current));
      }
    }
    shuffle(data);
  }

  public void shuffle(ArrayList<Card> ary){
    for (int idx = 0; idx < 52; idx ++){
      int idxToSwapWith = r.nextInt(52);
      swap(ary, idx, idxToSwapWith);
    }
  }

  public void swap(ArrayList<Card> ary, int idx1, int idx2){
    Card temp = data.get(idx1);
    data.set(idx1, data.get(idx2));
    data.set(idx2, temp);
  }

  public String toString(){
    String output = "[";
    for (int idx = 0; idx < data.size(); idx ++){
      output += data.get(idx) + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }
}
