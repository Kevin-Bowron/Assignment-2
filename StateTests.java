import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class StateTests {
    // TODO:
    // Build test cases which test each constructor and each class method

    // Test default constructor
    @Test
    void test_defaultConstructor_secretWord() {
        // Arrange
        State testState = new State();
        // Act
        boolean test_result = State.DEFAULT_WORD.equals(State.secretWord);
        // Assert
        assertTrue(test_result, "The comparison checked if defualt word = secret word" +
                "result should have been true");
    }

    @Test
    void test_defaultConstructor_letterStatus() {
        // Arrange
        State testState = new State();
        boolean test = true;
        // Act
        for (int i = 0; i < 5; i++) {
            if (State.letterStatus[i] != 0) {
                test = false;
                break;
            }
        }
        // Assert
        assertTrue(test, "the comparison checked if all values of letterStatus = 0. " +
                "Result should have been true");
    }

    @Test
    void test_defaultConstructor_letterStatusLength() {
        // Arrange
        State testState = new State();
        boolean test;
        // Act
        test = State.letterStatus.length == testState.WORD_LENGTH;
        // Assert
        assertTrue(test, "The comparison checked if length of letterStatus = word length" +
                "result should have been true");
    }

    // Test State(String)
    @Test
    void test_Constructor_secretWord() {
        // Arrange
        State testState = new State("hello");
        // Act
        boolean test_result = State.secretWord.equals("hello");
        // Assert
        assertTrue(test_result, "the comparison checks if secretWord = inputWord" +
                "hello was passed in as inputWord, the Result should have been true");
    }

    @Test
    void test_Constructor_letterStatus() {
        // Arrange
        State testState = new State("hello");
        boolean test = true;
        // Act
        for (int i = 0; i < 5; i++) {
            if (State.letterStatus[i] != 0) {
                test = false;
                break;
            }
        }
        // Assert
        assertTrue(test, "the comparison checked if all values of letterStatus = 0. " +
                "Result should have been true");
    }

    @Test
    void test_Constructor_letterStatusLength() {
        // Arrange
        State testState = new State("hello");
        boolean test;
        // Act
        test = State.letterStatus.length == testState.WORD_LENGTH;
        // Assert
        assertTrue(test, "The comparison checked if length of letterStatus = word length" +
                "result should have been true");
    }


    // Test updateState()
    @Test
    void test_updateState_AllExactMatch() {
        // Arrange
        State testState = new State();
        State.secretWord = "hello";
        testState.updateState("hello");
        boolean test = true;
        // Act
        for (int i = 0; i < 5; i++) {
            if (State.letterStatus[i] != 2) {
                test = false;
                break;
            }
        }
        // Assert
        assertTrue(test, "the comparison checked if all values of letterStatus = 2. Result should have been true. ");
    }

    @Test
    void test_updateState_AllInWord() {
        // Arrange
        State testState = new State();
        State.secretWord = "start";
        testState.updateState("tsrta");// contains all words in wrong order
        boolean test = true;
        // Act
        for (int i = 0; i < 5; i++) {
            if (State.letterStatus[i] != 1) {
                test = false;
                break;
            }
        }
        // Assert
        assertTrue(test, "the comparison checked if all values of letterStatus = 1. Result should have been true");
    }

    @Test
    void test_updateState_AllNoMatch() {
        // Arrange
        State testState = new State();
        testState.updateState("binge");
        State.secretWord = "start";
        boolean test = true;
        // Act
        for (int i = 0; i < 5; i++) {
            if (State.letterStatus[i] != 0) {
                test = false;
                break;
            }
        }
        // Assert
        assertTrue(test, "the comparison checked if all values of letterStatus = 0. Result should have been true");
    }


    // Test hasWin()

    @Test
    void test_hasWin_True() {
        // Arrange
        State testState = new State();
        State.letterStatus = new int[]{2, 2, 2, 2, 2};
        // Act
        boolean test = testState.hasWin();
        // Assert
        assertTrue(test, "the test checks the boolean value returned by hasWin when letterStatus =2" +
                "at all indices, the result should have been true");
    }

    @Test
    void test_hasWin_False() {
        // Arrange
        State testState = new State();
        State.letterStatus = new int[]{1, 1, 1, 1, 1};
        // Act
        boolean test = testState.hasWin();
        // Assert
        assertFalse(test, "the test checks the boolean value returned by hasWin when letterStatus =1" +
                "at all indices, the result should have been false");
    }

    @Test
    void test_hasWin_AlmostTrue() {
        // Arrange
        State testState = new State();
        State.letterStatus = new int[]{2, 2, 2, 2, 0};
        // Act
        boolean test = testState.hasWin();
        // Assert
        assertFalse(test, "the test checks the boolean value returned by hasWin when letterStatus =2" +
                "for all indices except the last, the result should have been false");
    }


    // Test toString
    @Test
    void test_toString_secretWord() {
        // Arrange
        State testState = new State();
        State.secretWord = "hello";
        String toCheck = testState.toString();
        boolean test;
        // Act
        test = toCheck.contains("hello");
        // Assert
        assertTrue(test, "the test assigns secret word a value and then checks if the return of toString" +
                "contains that value, result should have been true.");
    }

    @Test
    void test_toString_letterStatus() {
        // Arrange
        State testState = new State();
        State.letterStatus = new int[]{2, 2, 2, 2, 2};
        String toCheck = testState.toString();
        boolean test;
        // Act
        test = toCheck.contains(Arrays.toString(State.letterStatus));
        // Arrange
        assertTrue(test, "the test assigns values to letter status and checks if the return" +
                "of toString contains that specific array, result should have been true ");
    }

    @Test
    void test_toString_NonAlphabeticSecretWord() {
        // Arrange
        State testState = new State();
        State.secretWord = "$";
        String toCheck = testState.toString();
        boolean test;
        // Act
        test = toCheck.contains("$");
        // Assert
        assertTrue(test, "the test sets secret word to a non albhabetic character, and then checks if thats " +
                "consistent in return of toString, result should have been true");
    }

}
