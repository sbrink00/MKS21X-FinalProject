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

January 8: I am done with the Tile class and the construction of the roulette board in the Roulette class. The printBoard() works correctly and I will next write all the ways to bet and the spin() function, which will spit out a random Tile.

January 9: I finished the spin() function which returns a random Tile. On the 10th I will start to write all of the bet returns and the bet options.

January 10: I coded all of the betting types and options, and the ratio to which they payout. A method displayOptions() was added in case the user is unfamiliar with all of the betting options in roulette. interpretSpin() was also completed, along with betsWinsPossibilites(), which converts the bet type input into an array full of all possible results that will return money to the player.

January 11: I did nothing, we had the APCS Test today.

January 12: I completed the structure of Roulette without the aspect of user input. When I tried to integrate user input into the class, it broke. Therefore, it will not make an appearance in the demo. On the other hand, user input was fully integrated into slots.

January 13: Completely overhauled user input in Roulette. It is now fully functional and works until the user no longer wants to play or runs out of money. It can be used in our demo tomorrow as well, I am about to make a new demo commit.
