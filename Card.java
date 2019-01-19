//This object represents an individual playing card used in a casino.
public class Card{
  //the number field represents what card it is(4, 5, ace, king, etc...).
  //the val suit represents what the card's value is.
  //this field exists because all face cards are worth the same in
  //blackjack but they might not necessarily be the same card.
  //it also exists so that the value of aces can be altered without
  //changing its identity from an ace.
  private int num, val, warV;
  private char suit;
  private boolean hidden;


  public Card(int number, char startSuit){
    num = number;
    suit = startSuit;
    if (num == 1) val = 11;
    else if (num <= 10) val = num;
    else val = 10;
    hidden = false;
    if (num == 1) warV = 14;
    else if (num <= 10) warV = num;
    else warV = num;
  }

  public int getNum() {return num;}
  public int getValue() {return val;}
  public char suit() {return suit;}
  public void setVal(int newVal) {val = newVal;}
  public boolean isHidden() {return hidden;}
  public void setHidden(boolean arg) {hidden = arg;}
  public boolean equals(Card other){
    return this.suit == other.suit && this.num == other.num;
  }
  public boolean equalsNumber(Card other){
    return this.num == other.num;
  }


  public String toString(){
    char tempSuit;
    if (suit == 'H') tempSuit = '\u2665';
    else if (suit == 'D') tempSuit = '\u2666';
    else if (suit == 'S') tempSuit = '\u2660';
    else if (suit == 'C') tempSuit = '\u2663';
    if (hidden) return "turned over";
    if (num == 1) return "A" + suit;
    else if (num < 11) return "" + num + suit;
    else if (num == 11) return "J" + suit;
    else if (num == 12) return "Q" + suit;
    else return "K" + suit;
  }

}
