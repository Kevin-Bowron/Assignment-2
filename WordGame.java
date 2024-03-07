public class WordGame {
    public static void main(String [] args)
    {
        GameRunner myGame = new GameRunner();
        WordGame.printWelcome();
        myGame.playGame();

    }

    public static void printWelcome()
    {
        System.out.println("Hi! We're starting a game.");
    }
}
