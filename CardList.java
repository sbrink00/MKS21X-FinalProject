import java.util.ArrayList;
public abstract class CardList{

  private ArrayList<Card> cards;


  public ArrayList<Card> get(){return cards;}
  public void add(Card c) {cards.add(c);}
  public Card remove(Card c){
    cards.remove(c);
    return c;
  }

  public String toString(){
    String output = "[";
    for (int idx = 0; idx < cards.size(); idx ++){
      output += cards.get(idx) + ", ";
    }
    return output.substring(0, output.legnth() - 2) + "]";
  }



}
