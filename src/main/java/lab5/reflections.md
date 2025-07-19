Why can you change the type of the returned value in promptForPlayer without changing the return type in the function signature?

We can return something like new HumanPlayer in promptForPlayer without changing the return type because of polymorphism
(means many forms, and it occurs when we have many classes that are related to each other by inheritance).
HumanPlayer is a Player as it is a subclass of the abstract Player class.
This means that any function or method that expects a player is easy to accept an omola, Linus, or HumanPlayer. 
We simply return a subclass, and Java requires control of the right method action at runtime, so the method signature doesn't require change.





Explain why the error occurred initially and why adding the abstract method signature fixes the error. 
(HINT: What is the type of the ‘whoseTurn’ variable in TicTacToeGame.doNextTurn?)

Although the variable whoseTurn was defined as type Player in TicTacToeGame, the game was still attempting to run the pickNextMove method on a Player object,
so I saw an error after replacing it into HumanPlayer. Java failed to get that method because the Player class no more had it.
I fixed it in Player by creating pickNextMove an abstract method.
It allows the code to compile without errors and guides Java that each subclass wants its own version of the method.





Explain in detail (using the terminology we have discussed in class) how it is possible that neither our main method nor our 
TicTacToeGame class need change at all when adding new Player types to our game. 
Your discussion must include an explanation of how the single call to pickNextMove in TicTacToeGame.doNextTurn 
works correctly no matter whose turn it is or which types the players are.

This is possible because of polymorphism.Every single player type in concept, including HumanPlayer, Linus, and Omola, comes from the abstract Player class. 
Every subclass must include its own version of the pickNextMove method since it is defined as abstract by the Player class.
In TicTacToeGame, when we do:
Position move = whoseTurn.pickNextMove(currentBoard);
Although the variable whoseTurn is set, is identified as of type Player, the true object it refers could be any of an Omola, Linus, or HumanPlayer.
The game will use new players automatically as long as we apply the pickNextMove method and extend the Player class. 
According to the actual object, Java knows the version of the method to use. Due to this, adding new player types without changing the main is very simple.