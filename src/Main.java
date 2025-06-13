import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Arrays to store up to 100 questions and answers alongside answers and caily double
        String[] categories = new String[100];
        int[] pointAmount = new int[100];
        String[] questionText = new String[100];
        String[] questionAnswer = new String[100];
        boolean[] answered = new boolean[100];
        boolean[] dailyDouble = new boolean[100];
        int questionAmount = 0;

        while (true) {
            // Main menu display
            System.out.println("Jeopardy Main Menu");
            System.out.println("1. Play Game");
            System.out.println("2. Add Question");
            System.out.println("3. Exit");
            System.out.println("Select an option");
            String menuChoice = sc.nextLine();
            
            
            if (menuChoice.equals("1")) {
                if(questionAmount == 0) {
                    System.out.println("No questions added yet! Add questions before starting the game.");
                    continue;
                }

                int numPlayers = 0;
                while (true) {
                    System.out.println("Enter number of players (2-4): ");
                    String input = sc.nextLine();

                    // Check if input length > 0 and all digits
                    boolean validInput = true;
                    if (input.length() == 0) {
                         validInput = false;
                    } else {
                        for (int i = 0; i < input.length(); i++) {
                            char ch = input.charAt(i);
                            if (ch < '0' || ch > '9') {
                                validInput = false;
                                break;
                            }
                        }
                    }

                    if (validInput) {
                        int num = Integer.parseInt(input);
                        if (num >= 2 && num <= 4) {
                            numPlayers = num;
                            break;
                        } else {
                            System.out.println("Please enter a number between 2 and 4");
                        }
                    } else {
                        System.out.println("Invalid input. Please pick either 2, 3, or 4 players");
                    }
                }

                String[] playerNames = new String[numPlayers];
                for (int i = 0; i < numPlayers; i++) {
                    System.out.printf("Enter name for player: %d: ", i + 1);
                    playerNames[i] = sc.nextLine();
                }
                System.out.println("Players: ");
                for (String name : playerNames) {
                    System.out.println("-" + name);
                }
                System.out.println();
                
                // Display Game Board (text-based grid)
                System.out.println("Game Board:");

                 // Find unique categories
                ArrayList<String> uniqueCategories = new ArrayList<>();
                 for (int i = 0; i < questionAmount; i++) {
                    if (!uniqueCategories.contains(categories[i])) {
                         uniqueCategories.add(categories[i]);
                    }
                 }

                // Print categories header
                for (String cat : uniqueCategories) {
                    System.out.print(cat + "\t");
                }
                System.out.println();

                int maxRows = 5;
                for (int row = 0; row < maxRows; row++) {
                    for (String cat : uniqueCategories) {
                        int pointsToPrint = 0;
                        int countForCat = 0;
                        for (int q = 0; q < questionAmount; q++) {
                            if (categories[q].equals(cat)) {
                                if (countForCat == row) {
                                    pointsToPrint = pointAmount[q];
                                    break;
                                }
                                countForCat++;
                            }
                        }
                        if (pointsToPrint == 0) {
                            System.out.print("\t");
                        } else {
                            System.out.print(pointsToPrint + "\t");
                        }
                    }
                    System.out.println();
                }
                System.out.println();


                int[] playerScores = new int[numPlayers];
                
                // Randomly assign one Daily Double
                if (questionAmount > 0) {
                    int ddIndex = (int)(Math.random() * questionAmount);
                    dailyDouble[ddIndex] = true;
                }

                int questionsLeft = questionAmount;
                int currentPlayer = 0;

                while (questionsLeft > 0) {
                    System.out.println("\nIt's " + playerNames[currentPlayer] + "'s turn.");
                    String selectedCategory = "";
                    int selectedPoints = 0;
                    int questionIndex = -1;

                    while (true) {
                        System.out.print("Enter category: ");
                        selectedCategory = sc.nextLine();
                        System.out.print("Enter point value: ");
                        String ptStr = sc.nextLine();

                        // Validate numeric point input
                        boolean isNum = true;
                        for (int i = 0; i < ptStr.length(); i++) {
                            if (!Character.isDigit(ptStr.charAt(i))) {
                                isNum = false;
                                break;
                            }
                        }

                        if (!isNum || ptStr.length() == 0) {
                            System.out.println("Invalid point value.");
                            continue;
                        }

                        selectedPoints = Integer.parseInt(ptStr);

                        // Find the question
                        for (int i = 0; i < questionAmount; i++) {
                            if (!answered[i] && categories[i].equalsIgnoreCase(selectedCategory) && pointAmount[i] == selectedPoints) {
                                questionIndex = i;
                                break;
                            }
                        }

                        if (questionIndex == -1) {
                            System.out.println("That question has either been answered or doesn't exist.");
                        } else {
                            break;
                        }
                    }

                    // Daily Double
                    int wager;

                    if (dailyDouble[questionIndex]) {
                        int maxWager = playerScores[currentPlayer];
                        System.out.println("Daily Double! You can wager up to " + maxWager + " points.");
                        while (true) {
                            System.out.print("Enter your wager: ");
                            String wagerStr = sc.nextLine();
                            boolean validWager = true;
                                for (int i = 0; i < wagerStr.length(); i++) {
                                    if (!Character.isDigit(wagerStr.charAt(i))) {
                                        validWager = false;
                                        break;
                                    }
                                }
                            if (!validWager || wagerStr.length() == 0) {
                                System.out.println("Invalid wager. Numbers only.");
                                continue;
                            }

                            wager = Integer.parseInt(wagerStr);
                            if (wager >= 0 && wager <= maxWager ) {
                                break;
                            } else {
                                System.out.println("Wager must be between 0 and " + maxWager );
                            }
                        }
                    } else {
                        wager = pointAmount[questionIndex];
                    }

                    // Ask the question
                    System.out.println("Question: " + questionText[questionIndex]);
                    System.out.print("Your answer: ");
                    String userAnswer = sc.nextLine();

                    if (userAnswer.equalsIgnoreCase(questionAnswer[questionIndex])) {
                        System.out.println("Correct!");
                        playerScores[currentPlayer] += wager;
                    } else {
                        System.out.println("Incorrect! The correct answer was: " + questionAnswer[questionIndex]);
                        playerScores[currentPlayer] -= wager;
                    }

                    answered[questionIndex] = true; 
                    questionsLeft--;

                    // Reprint updated board
                    System.out.println("\nUpdated Game Board:");
                    for (String cat : uniqueCategories) {
                        System.out.print(cat + "\t");
                    }
                    System.out.println();
                    for (int row = 0; row < 5; row++) {
                        for (String cat : uniqueCategories) {
                            int pointsToPrint = 0;
                            int countForCat = 0;
                            boolean found = false;
                            for (int q = 0; q < questionAmount; q++) {
                                if (categories[q].equals(cat)) {
                                    if (countForCat == row) {
                                        if (answered[q]) {
                                            System.out.print("X\t");
                                        } else {
                                            System.out.print(pointAmount[q] + "\t");
                                        }
                                        found = true;
                                        break;
                                    }
                                    countForCat++;
                                }
                            }
                            if (!found)
                            System.out.print("\t");
                        }
                        System.out.println();
                    }

                    // Show scores
                    System.out.println("\nScores:");
                    for (int i = 0; i < numPlayers; i++) {
                        System.out.println(playerNames[i] + ": " + playerScores[i] + " points");
                    }

                     // Next player
                    currentPlayer = (currentPlayer + 1) % numPlayers;
                }

                // After all questions answered
                System.out.println("\nGame Over!");
                int highScore = Integer.MIN_VALUE;
                ArrayList<String> winners = new ArrayList<>();
                for (int i = 0; i < numPlayers; i++) {
                    if (playerScores[i] > highScore) {
                        highScore = playerScores[i];
                        winners.clear();
                        winners.add(playerNames[i]);
                    } else if (playerScores[i] == highScore) {
                        winners.add(playerNames[i]); 
                    }
                }

                if (winners.size() == 1) {
                    System.out.println("Winner: " + winners.get(0) + " with " + highScore + " points!");
                } else {
                    System.out.print("It's a tie between: ");
                    for (String w : winners) {
                        System.out.print(w + " ");
                    }
                    System.out.println("with " + highScore + " points each!");
                }
                
                System.out.println("Would you like to play again? (yes/no)");
                String replayChoice = sc.nextLine();    
                if (!replayChoice.equalsIgnoreCase("yes")) {
                    System.out.println("Farewell! Thanks for playing Jeopardy!");
                    break;
                }
                
                System.out.println("Returning to main menu...");

            } else if (menuChoice.equals("2")) {
                System.out.println("Enter category:");
                categories[questionAmount] = sc.nextLine();

                 // Get and validate point value
                int points = 0;
                while (true) {
                    System.out.println("Enter point value (number): ");
                    String pointInput = sc.nextLine();
                    boolean validPoint = true;

                    if (pointInput.length() == 0) {
                        validPoint = false;
                    }
                   
                  // Check if input contains only digits
                 for (int i = 0; i < pointInput.length(); i++) {
                    char a = pointInput.charAt(i);
                    if (a < '0' || a > '9') {
                        validPoint = false;
                        break;
                    }
                 }
                
                
                if (validPoint) {
                    points = Integer.parseInt(pointInput);
                    if (points > 0) {
                        break;
                    } else {
                        System.out.println("Please enter a number greater than 0");
                    }
                } else {
                        System.out.println("Invalid input. Please enter numbers only.");
                }
            }
            
                
                pointAmount[questionAmount] = points;

                System.out.print("Enter the question text: ");
                questionText[questionAmount] = sc.nextLine();
                
                System.out.print("Enter the correct answer: ");
                questionAnswer[questionAmount] = sc.nextLine();

                // Increase question count
                questionAmount++;
                System.out.println("Question has been added! ");
                System.out.println("Returning to the main menu");
            
            } else if (menuChoice.equals("3")) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }
    }
}



