//This object represents an individual playing card used in a casino.
public class Card{
  private int val;
  private char suit;

  public Card(int value, char startSuit){
    val = value;
    suit = startSuit;
  }

  public int getValue() {return val;}
  public char suit() {return suit;}

}
