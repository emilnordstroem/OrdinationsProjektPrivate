package PNTest;

import static org.junit.jupiter.api.Assertions.*;

import ordination.PN;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class SamletDosisTest {
    private PN pn;

    @BeforeEach
    void opretPN(){
        pn = new PN(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025,1,10),
                1
        );
    }

    @Test
    void testCase59(){
        pn.setAntalGangeGivet(10);
        double actualResult = pn.samletDosis();
        assertEquals(10, actualResult);
    }

    @Test
    void testCase60(){
        double actualResult = pn.samletDosis();
        assertEquals(0, actualResult);
    }

}
