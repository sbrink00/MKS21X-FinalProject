# MKS21X-FinalProject
Repo containing all the files for our final project

The Developer Log:
Elias Ferguson's Work:

January 3: I figured out how to git branch and git merge, and then branched off from the master to a new branch called testPlayer to begin work on the Player class.

January 4: Fully wrote the Player class, adding the bank account. The theoretical methods that would control player movement and x and y position in the terminal plane are commented out until we begin work with the terminal. Currently, the Player can be constructed with a certain starting balance (defaults to $1000) and can add to, subtract from, and access their balance. Additionally, the slots branch was added to begin my work on the slots feature. I added the skeleton of the class, nothing else.

January 5: I did nothing.

January 6: The SlotsTriple class was fully written around a base of math that I did to determine the winnings multiplier and chance of wins. The SlotsTriple class is designed to return 99% of the money input into it, on average. A Driver was created that verified this effect.

January 7: A larger driver verified the 99% rule in the SlotsTriple class. The skeleton of the Wheel, Tile and Roulette classes were added. The Tile class was written but may have been rendered irrelevant by the creation of the Wheel class, which does not utilize Tile at all.

January 8: I am done with the Tile class and the construction of the roulette board in the Roulette class. The printBoard() works correctly and I will next write all the ways to bet and the spin() function, which will spit out a random Tile.
