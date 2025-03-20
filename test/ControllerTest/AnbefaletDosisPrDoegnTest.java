package ControllerTest;

import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AnbefaletDosisPrDoegnTest {

    @Test
    void testCase1(){
        double actualResult = Controller.getTestController().anbefaletDosisPrDoegn(
                new Patient(
                        "",
                        "",
                        85.5
                ),
                new Laegemiddel(
                        "",
                        1.1,
                        1.2,
                        1.3,
                        "Sprøjte"
                )
        );
        assertEquals(1.2, actualResult);
    }

    @Test
    void testCase2(){
        assertThrows(NullPointerException.class, () -> {
            Controller.getTestController().anbefaletDosisPrDoegn(
                    null, null
            );
        });
    }

}
