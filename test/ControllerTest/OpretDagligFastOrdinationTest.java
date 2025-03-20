package ControllerTest;

import controller.Controller;
import ordination.DagligFast;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OpretDagligFastOrdinationTest {

    @Test
    void testCase1(){
        DagligFast dagligFast = Controller.getTestController().opretDagligFastOrdination(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,10),
                new Patient("010125-2025", "Christian", 85.5),
                new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                2,
                5,
                3,
                0
        );
        assertNotNull(dagligFast);
    }

    @Test
    void testCase2(){
        DagligFast dagligFast = Controller.getTestController().opretDagligFastOrdination(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,1),
                new Patient("010125-2025", "Christian", 85.5),
                new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                0,
                0,
                0,
                0
        );
        assertNotNull(dagligFast);
    }

    @Test
    void testCase3(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretDagligFastOrdination(
                    LocalDate.of(2025, 1,10),
                    LocalDate.of(2025, 1,1),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    0,
                    0,
                    0,
                    0
            );
        });
        assertEquals("startdato må ikke ligge efter slutdato", exception.getMessage());
    }

    @Test
    void testCase4(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Controller.getTestController().opretDagligFastOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,1),
                    null,
                    null,
                    0,
                    0,
                    0,
                    0
            );
        });
        assertEquals("patient/laegemiddel er null", exception.getMessage());
    }

    @Test
    void testCase5(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretDagligFastOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,1),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    -1,
                    -1,
                    -1,
                    -1
            );
        });
        assertEquals("antal må ikke være under 0", exception.getMessage());
    }

}
