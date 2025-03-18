package ControllerTest;

import controller.Controller;
import ordination.Laegemiddel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OpretLaegeMiddelTest {

    @Test
    void testCase47(){
        Laegemiddel laegemiddel = Controller.getTestController().opretLaegemiddel(
                "Matias",
                0.2,
                0.5,
                1,
                "pust"
        );
        assertNotNull(laegemiddel);
    }

    @Test
    void testCase48(){
        Laegemiddel laegemiddel = Controller.getTestController().opretLaegemiddel(
                "Matias",
                0,
                0,
                0,
                "ml"
        );
        assertNotNull(laegemiddel);
    }

    @Test
    void testCase49(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Laegemiddel laegemiddel = Controller.getTestController().opretLaegemiddel(
                    "Matias",
                    -0.1,
                    -0,
                    -0.1,
                    "styk"
            );
        });
        assertEquals("enhedPrKgPrDoegn kan ikke være en negativ numerisk værdi", exception.getMessage());
    }

    @Test
    void testCase50(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Laegemiddel laegemiddel = Controller.getTestController().opretLaegemiddel(
                    null,
                    0.2,
                    0.5,
                    1,
                    null
            );
        });
        assertEquals("navn og eller enhed er null", exception.getMessage());
    }

}
