//This object represents an individual playing card used in a casino.
public class Card{
  //the number field represents what card it is(4, 5, ace, king, etc...).
  //the val suit represents what the card's value is.
  //this field exists because all face cards are worth the same in
  //blackjack but they might not necessarily be the same card.
  //it also exists so that the value of aces can be altered without
  //changing its identity from an ace.
  private int num, val;
  private char suit;

  public Card(int number, char startSuit){
    num = number;
    suit = startSuit;
    if (num == 1) val = 11;
    else if (num <= 10) val = num;
    else val = 10;

  }

  public int getNum() {return num;}
  public int getValue() {return val;}
  public char suit() {return suit;}
  public void setVal(int newVal) {val = newVal;}

}
