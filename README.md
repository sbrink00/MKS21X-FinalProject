# MKS21X-FinalProject
Repo containing all the files for our final project

The Developer Log:

January 3:
-Elias Ferguson: I figured out how to git branch and git merge, and then branched off from the master to a new branch called testPlayer to begin work on the Player class.
-Samuel Brink: Figured out how to branch and merge. I also wrote the Card class, and then the Deck class, which takes an array of cards. I started the shoe class but it wasn't fully functional.

January 4:
-Elias Ferguson: Fully wrote the Player class, adding the bank account. The theoretical methods that would control player movement and x and y position in the terminal plane are commented out until we begin work with the terminal. Currently, the Player can be constructed with a certain starting balance (defaults to $1000) and can add to, subtract from, and access their balance. Additionally, the slots branch was added to begin my work on the slots feature. I added the skeleton of the class, nothing else.
-Samuel Brink: fixed shoe class so there is no more out of bounds exception. I also created the Blackjack and Dealer objects but didn't start them.

January 5:
-Elias Ferguson: I did nothing.
-Samuel Brink: I realized that the Hand, Deck, and Shoe class were all ArrayLists of cards and that many of them have the same method implementation, so I started an abstract superclass CardList in order to simplify things. I also wrote the hand class, but I would later edit it.

January 6:
-Elias Ferguson: The SlotsTriple class was fully written around a base of math that I did to determine the winnings multiplier and chance of wins. The SlotsTriple class is designed to return 99% of the money input into it, on average. A Driver was created that verified this effect.
-Samuel Brink: I started the process of taking methods from Shoe and putting them into the CardList superclass. I also created the dealer class as an inner class in blackjack.

January 7:
-Elias Ferguson: A larger driver verified the 99% rule in the SlotsTriple class. The skeleton of the Wheel, Tile and Roulette classes were added. The Tile class was written but may have been rendered irrelevant by the creation of the Wheel class, which does not utilize Tile at all.
-Samuel Brink: I finished syncing up Hand, Deck, and Shoe with the CardList class. I also got deal in blackjack to give the player and dealer a hand.

January 8:
-Elias Ferguson: I am done with the Tile class and the construction of the roulette board in the Roulette class. The printBoard() works correctly and I will next write all the ways to bet and the spin() function, which will spit out a random Tile.
-Samuel Brink: I wrote the playerPlay method so that the player could now add cards to their hand. I also wrote a sumValues method in the CardList superclass so that it would be easy to calculate the sum of the player and dealers hand.


January 9:
-Elias Fergusonn: I finished the spin() function which returns a random Tile. On the 10th I will start to write all of the bet returns and the bet options.
-Samuel Brink: I wrote the dealerPlay method so that the dealer will now hit until 17. I also wrote the payout method to pay the player if they won the game. I also wrote the method equals to compare two cards. I then realized that I also needed a method to compare whether two cards had an equal number, regardless of their suit, so I wrote the equalsNumber method. I also wrote indexOf and contains in CardList to check players and dealers hands for certain cards. I used these methods to modify players hands if they busted with an ace by changing the ace's value from 11 to 1.

January 10:
-Elias Ferguson: I coded all of the betting types and options, and the ratio to which they payout. A method displayOptions() was added in case the user is unfamiliar with all of the betting options in roulette. interpretSpin() was also completed, along with betsWinsPossibilites(), which converts the bet type input into an array full of all possible results that will return money to the player.
-Samuel Brink: I added boolean playerBust and dealerBust instance variables to track whether or not the player and dealer busted.

January 11:
-Elias Ferguson: I did nothing, we had the APCS Test today.
-Samuel Brink: I updated some of the blackjack methods so that they had print statements that made it easier for the user to follow along. I also started the process of resetting the player's and dealers hands after each game.


January 12:
-Elias Ferguson: I completed the structure of Roulette without the aspect of user input. When I tried to integrate user input into the class, it broke. Therefore, it will not make an appearance in the demo. On the other hand, user input was fully integrated into slots.
-Samuel Brink: I spent the majority of this day updating blackjack so that splitting is possible. I deleted many instance variables from the blackjack class as they are no longer relevant as the player can have multiple hands.

January 13:
-Elias Ferguson: Completely overhauled user input in Roulette. It is now fully functional and works until the user no longer wants to play or runs out of money. It can be used in our demo tomorrow as well, I am about to make a new demo commit.
-Samuel Brink: I updated the double method so that you can't double if your total is over 11. I also spent a lot of time working on the playerPlay method in Blackjack so that it allows for splitting.

January 14:
-Elias Ferguson: I added a couple fields to try and begin work on Poker. Most of the day was spent trying to figure out how video poker worked, and doing research on the various different types.
-Samuel Brink: I added a bet instance variable to the Hand class so that the bets for the hands could be updated separately if one of them doubled and another didn't. I also wrote a setAces method in the Blackjack class so that I wouldn't have to have the same redundant for loop in many different methods.

January 15:
-Elias Ferguson: Sam will take over work on Poker because he is fully done with Blackjack. I am looking for a different game to code because we decided to end the possibility of us using any lanterna.
-Samuel Brink: I updated the payout method in Blackjack so that it pays the correct amount when the player and dealer tie but are both under 21. I also started working on the master Casino file that the user will use to run the casino.

January 16:
-Elias Ferguson: I tried to do some work on Poker constructor because I am still unsure of what I should do, but Sam will be doing most of the Poker work. I pulled his work so far and tested out his game, there is still work to be done.
-Samuel Brink: I built on Elias's work on the poker class by adding a bet method, a deal method, and most of the swap method. The bet method is error proof, it will just keep asking for a bet until the user inputs a valid one. The deal method is very similar to the blackjack deal method except it deals out five cards instead of two. The swap method asks the user to input the indices (starting with 0) of all the cards they want to swap out (up to all five). It then puts these indices in an ArrayList. The next thing I will implement is a way to replace the cards at the given indices with random cards from the shoe.

January 17:
-Elias Ferguson: I have decided upon Casino War, which will be the fifth game in our Casino. I did zero coding today, but I mathematically wrote a paytable for the Casino War game that will ensure that, on average, the game returns 99.27% of the users bets. War is obviously a simple game with not much leeway for the house, but the money will be made during the event of a war.
-Samuel Brink: I wrote 9 methods in the hand class that check the hand to see if it is the hand specified by the method. For example, the fullHouse() method returns true if the hand that calls it is a full house, and false if it isn't. I did this for all nine poker hands, not including the high card hand, as that is the default if it isn't any other hand. I combined these methods into the determineHand() method in Poker, which checks the players hand against each possible poker hand starting from the top (royal flush) and going down (to a pair). This is because the way I wrote the checker methods means that a three of a kind is also a pair, so it is necessary to check from high to low, not low to high, or else a three of a kind could get marked as a pair.

January 18:
-Elias Ferguson: I implemented Unicode for the suits of cards. Additionally, I wrote the entire preliminary CasinoWar class, which is fully functional although lacking certain exception checks. It was relatively simple except for the war() method, which goes into effect when there is a tie. The hands of the player and dealer are only one card long, and they are just compared during normal play. However, when there is a war, special betting rules go into effect and three cards must be burned from the shoe before the hands are refreshed. The special betting rules implemented are the user must go to war by doubling his bet, or surrender by forfeiting half his bet. However, should the user win the war he only receives the amount of his original bet back.

-Samuel Brink: I added a setNum method to the card class so that for poker aces could be set to the highest card instead of the lowest card.

January 19:
-Elias Ferguson: Casino War is now fully functional. I attempted to implement unicode into the Slots class, but it did not implement correctly and the characters make no sense. I will revisit that problem tomorrow and possible end up making the Slots characters similar to those of the suits of cards, because those are proven to work.

-Samuel Brink: I created an string instance variable in poker to store what hand the player had.

January 20:
-Elias Ferguson: I did nothing, I had other work.

-Samuel Brink: I started writing the payout method in poker based on a 9-6 jacks or better payout table. I also wrote a method that checks for a pair of jacks or better as well as just a pair.

January 21:
-Elias Ferguson: I put the finishing touches on the aesthetic aspects of the games. I also implemented bad input handling into all the games I wrote, so that under no circumstances should the user ever see an error message that wasn't written by me. The instructions for each game should now be clear enough for everybody. I also wrote kWarDriver, which can be compiled and run to test the war() method in CasinoWar. It guarantees both players and ace of spades to trigger a war so that Mr. K doesn't have to keep running CasinoWar until the dealer and him get the same card. 
-Samuel Brink: Almost everything was done by this point. I added all the other games to the casino file so that all the user needs to do is compile and run Casino.java and follow the directions in order to play any game they want. I also made each individual game take a player in their constructor so the player could remain consistent throughout the whole casino experience. Another thing I did is that I went through the games and added some print statements to make them more user friendly and to show the user their balance more often. In order to allow the user to test the splitting feature in blackjack without playing many hands in a row, I created the SplitTester class. When this class is compiled and run the user will be guaranteed a hand that is made up of two fives, so they can split it.




























```
