import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessUtilitiesTests {

    @Test
    void test_isGoodInput_Basic()
    {
        // Arrange
        GuessUtilities testUtilities = new GuessUtilities();
        String toCheck = "begin";
        // Act
        boolean test_result = testUtilities.isGoodInput(toCheck);
        // Assert
        assertTrue(test_result, "Used word <begin>. Result should have been true.");
    }


    @Test
    void test_isGoodInput_tooLong()
    {
        // Arrange
        GuessUtilities testUtilities = new GuessUtilities();
        String toCheck = "battle";
        // Act
        boolean test_result = testUtilities.isGoodInput(toCheck);
        // Assert
        assertFalse(test_result,  "Used word <battle>. Result should have been false.");
    }


    @Test
    void test_isGoodInput_tooShort(){
        // Arrange
        GuessUtilities testUtilities = new GuessUtilities();
        String toCheck = "four";
        // Act
        boolean test_result = testUtilities.isGoodInput(toCheck);
        // Assert
        assertFalse(test_result, "Used word <four>. Result should have been false");
    }

    @Test
    void test_isGoodInput_noInput(){
        // Arrange
        GuessUtilities testUtilities = new GuessUtilities();
        String toCheck = "";
        // act
        boolean test_result = testUtilities.isGoodInput(toCheck);
        // Assert
        assertFalse(test_result, "Used input <null>. Result should have been false");


    }


    @Test
    void test_isGoodInput_notAlpha()
    {
        // Arrange
        GuessUtilities testUtilities = new GuessUtilities();
        String toCheck = "beg1n";
        // Act
        boolean test_result = testUtilities.isGoodInput(toCheck);
        // Assert
        assertFalse(test_result, "Used word <beg1n>. Result should have been false.");
    }
    

}
