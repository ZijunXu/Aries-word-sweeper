# Word Sweeper
## Team Aries
### <br>
### <bold>CAUTION
#### <br>
#### If running the test case, please go to /src/client/controller/ExitGameResponseController.java, delete the "System.exit(0)", then run the test case.
#### <br>
#### Or the test case will stop running, when it goes to the System.exit(0), the rest of the test cases will not run.
#### <br>
#### The "System.exit(0)" in ExitGameResponseController.java is responsible for terminating the game completetly.
#### <br>
#### The coverage of the test cases is up to 78.1%
#### <br>
### <bold>How to Play
#### <br>
#### lauch the client, and please input your your name and password (if you have a password), then click the Create a game button, then you will start a new game.
#### if you want to join a game, also, please input the Game ID you want to join, then click the Join a game button.
#### <br>
#### In the playing panel, you have 16 letters and please click and drag your mouse to select a word. Your selection will be displayed in the Word label below, and your selection's score will be displayed at the Word Score label below.
#### <br>
#### If you release the mouse, the word you just selected will be send to the server. If is a valid word, you gain the score, and the selected letters disappear, other letters below them will be float up, or nothing happens.
#### <br>
#### The bonus cells will be displayed in yellow. The shared cells will be displayed in different scale of grey according how many times it was shared.
#### <br>
#### You can use the 4 buttons in the middle to move the board.
#### <br>
#### You can see the Game ID, your name and current score above the moving buttons.
#### <br>
#### At the top right, you can see all the players' names and their score in the current game. Below the list, you can see who's the manager of the game.
#### <br>
#### If you are the manager, you can use the Lock Game button to lock the game and use the Reset Game button to reset the game.
#### <br>
#### Click the Exit Game button, the application will be terminate completely.