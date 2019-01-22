//This object represents an individual playing card used in a casino.
import java.util.*;
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
  private char tempSuit;

  //constructs card.
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

  //variety of methods used to access and
  //change the cards instance variables.
  public int getwarV() {return warV;}
  public int getNum() {return num;}
  public void setNum(int newNum) {num = newNum;}//used for aces in poker.
  public int getValue() {return val;}
  public char suit() {return suit;}
  public void setVal(int newVal) {val = newVal;}
  public boolean isHidden() {return hidden;}
  public void setHidden(boolean arg) {hidden = arg;}

  //returns true if the suit and number of the two cards are equal.
  public boolean equals(Card other){
    return this.suit == other.suit && this.num == other.num;
  }

  //returns true if the number of the two cards are equal.
  public boolean equalsNumber(Card other){
    return this.num == other.num;
  }

  //toString that uses unicode to make it look nice.
  public String toString(){
    if (suit == 'H') tempSuit = '\u2665';
    else if (suit == 'D') tempSuit = '\u2666';
    else if (suit == 'S') tempSuit = '\u2660';
    else if (suit == 'C') tempSuit = '\u2663';
    if (hidden) return "turned over";
    if (num == 1) return "A" + tempSuit;
    else if (num < 11) return "" + num + tempSuit;
    else if (num == 11) return "J" + tempSuit;
    else if (num == 12) return "Q" + tempSuit;
    else return "K" + tempSuit;
  }

}
