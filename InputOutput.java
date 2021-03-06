import java.io.IOException;
import java.lang.*;
import java.util.Scanner;
/**
 * Created by andrewnyaisonga on 2/8/17.
 */
public class InputOutput {
    public int gameNumber=0; //To check how many times the user has played





    public static void main(String args[]) throws IOException {
        InputOutput main = new InputOutput();
        main.instructions();
        main.input();
    }

        public void input() throws IOException {

            Scanner in = new Scanner(System.in);
            if(gameNumber==0){
                System.out.println("How many positions do you want to work with today? :");
            }
            else{
                System.out.println("How many positions?:");
            }

            int numberGuesses= Integer.parseInt(in.next()); //receiving user input
            if(numberGuesses >6){
                System.out.println();
                System.out.println("I have to warn you: I was not design for such big numbers!\n" +
                                    "I can still do it thought but it will take a long time and it's not fun\n" +
                                    "Do you wanna continue?(yes/no)\n");
                String continued = in.next();
                if(continued.equals("no")){
                    System.out.println("Good choice!: So how many colors (LESS THAN 7) do you wanna work with today?: ");
                    numberGuesses= Integer.parseInt(in.next()); //receiving user input
                }
            }

            in.nextLine();
            if(gameNumber==0) {
                System.out.println("PLEASE READ THIS: In this Game you have to enter the Colors like RED-,Orange-,Green-\n"
                        + "Please Notice that there is dash between the color and , but no space between , and the next color,Don't forget to put - at the last color");
                System.out.println();
                System.out.println("Give me the colors that I will be working with today, separated comma: ");
            }
            else if(gameNumber != 0){
                System.out.println("PLEASE REMEMBER TO OBEY THE INPUT FORMAT(RED-,GREEN-");
                System.out.println();
                System.out.println("Give me the colors that I will be working wuth today, separated comma: ");
            }
            String colors=in.nextLine();
            String[] tokenColors=colors.split(",");
            Mastermind mind = new Mastermind(tokenColors,numberGuesses);

            int white =0;
            while(white != numberGuesses){
                String computersguess=mind.nextMove(); //get next move from the computer

                System.out.println("Guess: "+computersguess);


                System.out.println("Enter the amount of colors that are right and in the right positions(WHITE):");

                white=in.nextInt();


                System.out.println("Enter the amount of colors that are right but not in the right position(BLACK):");
                int black=in.nextInt();


                mind. response(black, white); //analyze what to do with the response

            }
            gameNumber++;

            switch(gameNumber){
                case 1 : System.out.println("YES!!!!!");
                        System.out.println("We(Computers) are cool aren't we?");
                        System.out.println("You can try again");
                        System.out.println();
                    break;
                case 2: System.out.println("I KNEW IT ALL ALONG!!!!!");
                        System.out.println();
                        break;
                case 3: System.out.println("Can you think harder!!!!!");
                         System.out.println();
                        break;

                default: if(gameNumber>3) {
                                System.out.println("I CAN READ YOUR MIND!!!!!");
                                System.out.println();
                            }
                         break;
            }

            System.out.println ("Enter p to play,q to quit or r for instructions");
            char word;
            String input = in.next();
            word = input.charAt(0);
            if(word == 'p'){
                mind.newGame();
                input();
            }
            if (word == 'q') {
               System.out.println("SEE YOU AGAIN SOON");
            }
            if (word == 'r') {
                instructions();
                input();
            }
        }





     public void instructions(){
         System.out.println("WELCOME TO MASTERMIND GAME");
         System.out.println();
         System.out.println("HERE ARE THE RULE OF THE GAME");
         System.out.println();
         System.out.println("I will be the codeBreaker and you will be the codeMaker, So this should be easy for you. \n" +
                            "Make out combinations of colors and I will be guessing with as little guess as I can. \n"+ "\n"+
                            "I will give you the combination of numbers and a prompt asking you how many I got right \n"+
                            "The first prompt(White) is for how many I got right and in the right position \n"+
                            "Second prompt(Black) is for how many I got right but in the wrong position \n");
         System.out.println();
         System.out.println("I am ready to read your mind");
         System.out.println();
         System.out.println("LET'S GO");
         System.out.println();

     }



}
