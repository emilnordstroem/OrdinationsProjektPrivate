package PNTest;

import static org.junit.jupiter.api.Assertions.*;

import ordination.PN;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OpretPNTest {
    private PN pn;

    @Test
    void testCase51(){
        pn = new PN(LocalDate.now(), LocalDate.now(), 5);
        double actualResult = pn.getAntalEnheder();
        assertEquals(5, actualResult);
    }

    @Test
    void testCase52(){
        pn = new PN(LocalDate.now(), LocalDate.now(), 1);
        double actualResult = pn.getAntalEnheder();
        assertEquals(1, actualResult);
    }

    @Test
    void testCase53(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pn = new PN(LocalDate.now(), LocalDate.now(), 0);
        });
        assertEquals("Kan ikke oprette objekter på 0 eller negativ numerisk værdi", exception.getMessage());
    }

}
