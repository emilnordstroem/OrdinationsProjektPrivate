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
        //TODO EXCEPTION
        Laegemiddel laegemiddel = Controller.getTestController().opretLaegemiddel(
                "Matias",
                -0.1,
                -0,
                -0.1,
                "styk"
        );
    }

    @Test
    void testCase50(){
        //TODO EXCEPTION
        Laegemiddel laegemiddel = Controller.getTestController().opretLaegemiddel(
                null,
                0.2,
                0.5,
                1,
                null
        );
    }

}
