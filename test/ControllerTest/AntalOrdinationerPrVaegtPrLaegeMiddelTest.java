package ControllerTest;

import controller.Controller;
import ordination.Laegemiddel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AntalOrdinationerPrVaegtPrLaegeMiddelTest {

    @Test
    void testCase61(){
        int actualResult = Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                50,
                100,
                new Laegemiddel(
                        "pencilin",
                        0.1,
                        0.2,
                        0.3,
                        "styk"
                )
        );
        assertEquals(0, actualResult);
    }

    @Test
    void testCase62(){
        int actualResult = Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                80,
                80,
                new Laegemiddel(
                        "pencilin",
                        0.1,
                        0.2,
                        0.3,
                        "styk"
                )
        );
        assertEquals(0, actualResult);
    }

    @Test
    void testCase63(){
        int actualResult = Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                0,
                0,
                new Laegemiddel(
                        "pencilin",
                        0.1,
                        0.2,
                        0.3,
                        "styk"
                )
        );
        assertEquals(0, actualResult);
    }

    @Test
    void testCase64(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            int actualResult = Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                    50,
                    100,
                    null
            );
        });
        assertEquals("", exception.getMessage());
    }

    @Test
    void testCase65(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int actualResult = Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                    -1,
                    -1,
                    new Laegemiddel(
                            "pencilin",
                            0.1,
                            0.2,
                            0.3,
                            "styk"
                    )
            );
        });
        assertEquals("ugyldigt input af vaegtStart/vaegtSlut (obs. på at start ikke må være større end slut)", exception.getMessage());
    }

    @Test
    void testCase66(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int actualResult = Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                    100,
                    50,
                    new Laegemiddel(
                            "pencilin",
                            0.1,
                            0.2,
                            0.3,
                            "styk"
                    )
            );
        });
        assertEquals("ugyldigt input af vaegtStart/vaegtSlut (obs. på at start ikke må være større end slut)", exception.getMessage());
    }

}
