import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTests {


    @Test
    void test_isEnglishAndFiveLetters_Basic()
    {
        // Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "begin";
        // Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        // Assert
        assertTrue(test_result, "Used word <begin>. Result should have been true.");
    }


    @Test
    void test_isEnglishAndFiveLetters_WrongSpelling()
    {
        // Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "heolw";
        // Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        // Assert
        assertFalse(test_result,  "Used word <heolw>. Result should have been false.");
    }


    @Test
    void test_isEnglishAndFiveLetters_noInput(){
        // Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "";
        // act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        // Assert
        assertFalse(test_result, "Used input <null>. Result should have been false");


    }


    @Test
    void test_isEnglishAndFiveLetters_notAlpha()
    {
        // Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "beg1n";
        // Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        // Assert
        assertFalse(test_result, "Used word <beg1n>. Result should have been false.");
    }

}
