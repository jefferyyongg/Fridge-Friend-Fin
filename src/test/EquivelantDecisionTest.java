package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EquivelantDecisionTest {

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
    public void falseTrueTrue() {
        Recept recept = new Recept("validInput", false, true, true);
        assertTrue(recept.isValidInput());
    }

    @Test
    public void falseFalseTrue() {
        Recept recept = new Recept("validInputLongerThanFiftyCharactersWhichIsInvalid", false, false, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void falseTrueFalse() {
        Recept recept = new Recept("validInput", false, true, false);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void trueTrueTrue() {
        Recept recept = new Recept("invalid@Input", true, true, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void trueFalseTrue() {
        Recept recept = new Recept("invalid@InputLongerThanFiftyCharactersWhichIsInvalid", true, false, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void trueTrueFalse() {
        Recept recept = new Recept("invalid@Input", true, true, false);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void falseFalseTrue2() {
        Recept recept = new Recept("InputLongerThanFiftyCharactersWhichIsInvalid", false, false, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void falseTrueFalse2() {
        Recept recept = new Recept("", false, true, false);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void trueTrueTrue2() {
        Recept recept = new Recept("@", true, true, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void trueFalseTrue2() {
        Recept recept = new Recept("@InputLongerThanFiftyCharactersWhichIsInvalid", true, false, true);
        assertFalse(recept.isValidInput());
    }

    @Test
    public void trueTrueFalse2() {
        Recept recept = new Recept("@", true, true, false);
        assertFalse(recept.isValidInput());
    }
}
