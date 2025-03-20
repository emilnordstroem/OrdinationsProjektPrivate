package ControllerTest;

import controller.Controller;
import ordination.Laegemiddel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AntalOrdinationerPrVaegtPrLaegeMiddelTest {

    @Test
    void testCase1(){
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
    void testCase2(){
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
    void testCase3(){
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
    void testCase4(){
        assertThrows(NullPointerException.class, () -> {
            Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
                    50,
                    100,
                    null
            );
        });
    }

    @Test
    void testCase5(){
       assertThrows(IllegalArgumentException.class, () -> {
           Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
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
    }

    @Test
    void testCase6(){
        assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().antalOrdinationerPrVaegtPrLaegemiddel(
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
    }

}
