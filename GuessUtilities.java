public class GuessUtilities {
    public final int WORD_LENGTH = 5;
    public String createLowerCase(String toCheck) {
        String guess;
        guess = toCheck.toLowerCase();
        return guess;
    }

    public boolean isGoodInput(String toCheck)
    {
        GameRunner English = new GameRunner();
        boolean isValid = false;

        // Ensure wor is not case-sensitive
        toCheck = createLowerCase(toCheck);

        // ensure word is five letters
        if (toCheck.length() == WORD_LENGTH)
        {
            isValid = true;

            for (Character letter:toCheck.toCharArray())
            {
                // ensure word has only letters
                if (!Character.isLetter(letter)) {
                    isValid = false;
                    break;
                }
            }
        }
        // Ensure word is an english word
        if (!English.isEnglishAndFiveLetters(toCheck)){
            isValid = false;
        }

        return isValid;
    }


}
