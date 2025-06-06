import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] categories = new String[100];
        int[] pointAmount = new int[100];
        String[] questionText = new String[100];
        String[] questionAnswer = new String[100];
        int questionAmmount = 0;

        while (true) {
            System.out.println("Jeopardy Main Menu");
            System.out.println("1. Play Game");
            System.out.println("2. Add Question");
            System.out.println("3. Exit");
            System.out.println("Select an option");
            String menuChoice = sc.nextLine();
            
            if (input.equals("1")) {
                System.out.println("");
            } else if (input.equals("2")) {
                System.out.println("Enter category:");
                categories[questionAmount] = sc.nextLine();

                int points = 0;
                while (true) {
                    System.out.println("Enter point value (number): ");
                    String pointInput = sc.nctLine();

                    boolean validPoint = true;
                    if (pointInput.lenght() == 0) {
                        validPoint = false;
                    }
                   
                 for (int i = 0; i < pointInput.length();, i++) {
                    char a = pointInput.charAt(i);
                    if (a < '0' || a > '9'
                        validPoint = false;
                        break;
                 }
                }
                


                
            }


            }












            
        }

        


      



        
    }
}