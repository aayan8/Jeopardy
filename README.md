# Jeopardy

        Jeopardy-Style Quiz Game 

This Java program simulates a Jeopardy quiz game. Players add their own questions and then compete against each other to earn the highest score by answering questions from different categories. The game features include multiple players, scoring, user inputted questions, daily doubles, and more. 


        Variables and Data Structures

The game uses arrays and variables to store and manage game data, and it supports up to 100 questions. These are the essential variables used in the code that allow it to function. 

Scanner sc: Reads user input

String [] categories: Stores category names for each question

int [] pointAmount: Holds the point values for each question

int [] playerScores: Keeps track of all players scores

String [] questionText: Holds the text for each question 

String [] questionAnswer: Holds the correct answer for each question

String [] playerNames: Stores the names of the players

boolean [] answered: Tracks if a question has been answered or not, ensuring questions aren’t asked multiple times

boolean [] dailyDouble: Indicates if a question is the daily double for this round, daily double is randomly selected every round 

int questionAmount: Counts the amount of questions added

ArrayList<String> uniqueCategories: Stores all unique category names to display it on the gameboard 

int numPlayers: Holds the number of players in the current game 

int questionsLeft: Counts how many unanswered questions there still are 

int currentPlayer: Tracks which players turn it is 


        Logic and Structure

The game has a main menu at the beginning that it is built around, allowing users to either play, add questions, or exit.

Main Menu 

A continuous loop presents options: “1. Play Game”, “2 Add Questions”, “3. Exit”. The user’s input is checked to ensure it’s valid and they are prompted to enter a new option if invalid.

Adding a Question

Choosing “2” allows a player to enter questions. The user inputs the category name, point value, question text, and correct answer. The point value is validated to ensure its a positive integer. Once added, the questions are stored in respective arrays, the questionAmount variable is updated, and a confirmation message appears. 


        Playing the Game
Selecting “1” starts the game. 

Pregame check: The game checks to see if questions have been added. If not, the user is prompted to add more questions. 

Player setup: The user says the number of players and each player enters their name.

Game board: A text grid shows the game board. Categories are displayed as headers and question point values are shown. 

Daily double: One random question is selected as the daily double. 

Game loop: Turns rotate among the players until every question is answered.

Question Selection: The current player chooses a category and point value. The game checks if the question is valid (that it exists, and that it hasn’t been answered).

Daily Double Wager: If a daily double is selected, the player can wager any amount of money up to their current score.

Question and Answer: The question text is displayed and the player enters their answer. 

    Score update:

Correct Answers award points.

Incorrect Answers deduct points and reveal the correct answer.

Daily double correct/incorrect answers award/deduct the wagered points respectively.

Board refresh: The question is marked as answered on the board and player scores are updated. 

    Game end:

Once all questions are answered, the game ends. 

The winner(s) (highest score) are announced, or a tie is declared.

The user is then prompted to either exit or play again. If “yes” is selected, the game returns to the main menu, otherwise, the program exits with a farewell message. 

