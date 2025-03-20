package PNTest;

import static org.junit.jupiter.api.Assertions.*;

import ordination.PN;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class GivDosisTest {
    private PN pn;

    @BeforeEach
    void opretPN(){
        pn = new PN(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1, 10),
                2
        );
    }

    @Test
    void testCase1(){
        boolean actualResult = pn.givDosis(LocalDate.of(2025, 1,5));
        assertTrue(actualResult);
    }

    @Test
    void testCase2(){
        boolean actualResult = pn.givDosis(LocalDate.of(2025, 1,1));
        assertTrue(actualResult);
    }

    @Test
    void testCase3(){
        boolean actualResult = pn.givDosis(LocalDate.of(2025, 1,10));
        assertTrue(actualResult);
    }

    @Test
    void testCase4(){
        boolean actualResult = pn.givDosis(LocalDate.of(2024, 12,31));
        assertFalse(actualResult);
    }

    @Test
    void testCase5(){
        boolean actualResult = pn.givDosis(LocalDate.of(2025, 1,11));
        assertFalse(actualResult);
    }

}
