import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Arrays to store up to 100 questions and answers
        String[] categories = new String[100];
        int[] pointAmount = new int[100];
        String[] questionText = new String[100];
        String[] questionAnswer = new String[100];
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
                System.out.println("");
            // Add a new question
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
            
            }

             else if (menuChoice.equals("3")) {
                System.out.println("Thanks for playing!");
                break;
             } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
             }
          }
     }
  }












            
        

        


      



        
    
