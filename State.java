import java.util.*;

public class State {

    public static String secretWord;
    public static int[] letterStatus;
    public final int WORD_LENGTH = 5;
    public static final String DEFAULT_WORD = "start";

    private final int NO_MATCH = 0;
    private final int IN_WORD = 1;
    private final int EXACT_MATCH = 2;

    public State()
    {
         secretWord = new String(DEFAULT_WORD);
         letterStatus = new int[WORD_LENGTH];
         for (int i = 0; i < WORD_LENGTH;i++)
         {
             letterStatus[i] = NO_MATCH;
         }

    }

    public State(String inputWord)
    {
        secretWord = new String(inputWord);
        letterStatus = new int[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH;i++)
        {
            letterStatus[i] = NO_MATCH;
        }
    }

    public void updateState(String newGuess)
    {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (secretWord.contains(String.valueOf(newGuess.charAt(i)))) {
                letterStatus[i] = IN_WORD;
                if (secretWord.charAt(i) == newGuess.charAt(i))
                    letterStatus[i] = EXACT_MATCH;
            }
        }
    }

    public boolean hasWin()
    {
        boolean winState = true;
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            if (letterStatus[i] < EXACT_MATCH)
                winState = false;
        }
        return winState;
    }

    @Override
    public String toString() {
        return "State{" +
                "secretWord='" + secretWord + '\'' +
                ", letterStatus=" + Arrays.toString(letterStatus) +
                '}';
    }

    public String feedback(){
        // initialize variables
        int rightSpot = 0;
        int inWordWrongSpot = 0;
        int notInWord = 0;
        for (int i = 0; i < 5; i++){
            if (letterStatus[i] == EXACT_MATCH){
                rightSpot++;
            }
            else if(letterStatus[i] == IN_WORD ){
                inWordWrongSpot++;
            }
            else{
                notInWord++;
            }
        }
        return ("Your word has "+ rightSpot + " words in the right spot:\n" +
                "Your word has "+ inWordWrongSpot+ " words that are in the word but in the wrong spot:\n" +
                "Your word has "+ notInWord+ " words that are not in the word at all:");

    }

}

