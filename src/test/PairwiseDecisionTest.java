package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairwiseDecisionTest {

    public class Recept {
        private boolean hasSpecialCharacters;
        private boolean isInputLengthValid;
        private boolean isProductFoundInAPI;

        public Recept(boolean hasSpecialCharacters, boolean isInputLengthValid, boolean isProductFoundInAPI) {
            this.hasSpecialCharacters = hasSpecialCharacters;
            this.isInputLengthValid = isInputLengthValid;
            this.isProductFoundInAPI = isProductFoundInAPI;
        }

        public boolean isValidInput() {
            return hasSpecialCharacters && (isInputLengthValid || isProductFoundInAPI);
        }
    }

    @Test
    public void testPairwise() {
        Recept recept1 = new Recept(true, true, true);
        Recept recept2 = new Recept(true, true, false);
        Recept recept3 = new Recept(true, false, true);
        Recept recept4 = new Recept(true, false, false);
        Recept recept5 = new Recept(false, true, true);
        Recept recept6 = new Recept(false, true, false);
        Recept recept7 = new Recept(false, false, true);
        Recept recept8 = new Recept(false, false, false);

        assertTrue(recept1.isValidInput());
        assertTrue(recept2.isValidInput());
        assertTrue(recept3.isValidInput());
        assertFalse(recept4.isValidInput());
        assertFalse(recept5.isValidInput());
        assertFalse(recept6.isValidInput());
        assertFalse(recept7.isValidInput());
        assertFalse(recept8.isValidInput());
    }
}
