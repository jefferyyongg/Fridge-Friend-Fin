package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceptDecisionTest {

    public class Recept {
        private String userInput;
        private boolean hasSpecialCharacters;
        private boolean isInputLengthValid;
        private boolean isProductFoundInAPI;

        public Recept(String userInput, boolean hasSpecialCharacters, boolean isInputLengthValid, boolean isProductFoundInAPI) {
            this.userInput = userInput;
            this.hasSpecialCharacters = hasSpecialCharacters;
            this.isInputLengthValid = isInputLengthValid;
            this.isProductFoundInAPI = isProductFoundInAPI;
        }

        public boolean isValidInput() {
            return !hasSpecialCharacters && isInputLengthValid && isProductFoundInAPI;
        }
    }

    @Test
    public void testNoSpecialCharactersValidLengthProductFound() {
        Recept recept = new Recept("validInput", false, true, true);
        assertTrue(recept.isValidInput());
    }

    @Test
    public void testSpecialCharactersValidLengthProductFound() {
        Recept recept = new Recept("invalid@Input", true, true, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void testNoSpecialCharactersInvalidLengthProductFound() {
        Recept recept = new Recept("validInputLongerThanFiftyCharactersWhichIsInvalid", false, false, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void testNoSpecialCharactersValidLengthProductNotFound() {
        Recept recept = new Recept("validInput", false, true, false);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void testSpecialCharactersValidLengthProductNotFound() {
        Recept recept = new Recept("invalid@Input", true, true, false);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void testNoSpecialCharactersInvalidLengthProductNotFound() {
        Recept recept = new Recept("validInputLongerThanFiftyCharactersWhichIsInvalid", false, false, false);
        assertFalse(recept.isValidInput());
    }
}
