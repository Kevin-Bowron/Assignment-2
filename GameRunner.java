import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class GameRunner {
    public final int MAX_TURNS = 6;
    public final int WORD_LENGTH = 5;

    State gameState;
    ArrayList<String> validWords;
    public String randomWord;

        public  GameRunner()
    {

        // A note: pre-setting the initial capacity of the HashSet to approximately the right size
        // should make populating the HashSet a bit faster.
        validWords = new ArrayList<>();
        try
        {
            FileReader fReader = new FileReader("main/sgb-words.txt");
            BufferedReader bReader = new BufferedReader(fReader);

            String line;
            while ((line = bReader.readLine()) != null) {
                validWords.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " );
        }
        // Randomly choose a word from the file
        Random random = new Random();
        randomWord = validWords.get(random.nextInt(validWords.size()));

    }

    public void playGame()
    {

        GuessUtilities error = new GuessUtilities();
        int numTurns = 0;
        String guess = "";
        gameState= new State(randomWord);
        Scanner input = new Scanner(System.in);

        while ((numTurns < MAX_TURNS) && (!gameState.hasWin()))
        {
            System.out.println("Type a five-letter word");
            guess = input.nextLine();
            
            if (!error.isGoodInput(guess))
            {
                System.out.println("Your input was invalid in some way. " +
                        "Make sure you have a six letter word with only characters from A-Z");
               continue;
            }
            
            gameState.updateState(guess);
            numTurns++;

            if(gameState.hasWin())
            {
                System.out.println("Wow! You won in " + numTurns  + "guesses. Good work!");
            }
            System.out.println(gameState.feedback());

            
            
        }
        
        
    }



    public boolean isEnglishAndFiveLetters(String toCheck)
    {
        return validWords.contains(toCheck);
    }


}
