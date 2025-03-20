package PNTest;

import static org.junit.jupiter.api.Assertions.*;

import ordination.PN;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OpretPNTest {
    private PN pn;

    @Test
    void testCase1(){
        pn = new PN(LocalDate.now(), LocalDate.now(), 5);
        assertNotNull(pn);
    }

    @Test
    void testCase2(){
        pn = new PN(LocalDate.now(), LocalDate.now(), 1);
        assertNotNull(pn);
    }

    @Test
    void testCase3(){
        assertThrows(IllegalArgumentException.class, () -> {
            pn = new PN(LocalDate.now(), LocalDate.now(), 0);
        });
    }

}
