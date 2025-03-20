package ControllerTest;

import controller.Controller;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class OpretPNOrdinationTest {

    @Test
    void testCase1(){
        PN pn = Controller.getTestController().opretPNOrdination(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,10),
                new Patient("010125-2025", "Christian", 85.5),
                new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                2
        );
        assertNotNull(pn);
    }

    @Test
    void testCase2(){
        PN pn = Controller.getTestController().opretPNOrdination(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,1),
                new Patient("010125-2025", "Christian", 85.5),
                new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                1
        );
        assertNotNull(pn);
    }

    @Test
    void testCase3(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretPNOrdination(
                    LocalDate.of(2025, 1,10),
                    LocalDate.of(2025, 1,1),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    1
            );
        });
        assertEquals("startdato må ikke ligge efter slutdato", exception.getMessage());
    }

    @Test
    void testCase4(){
        assertThrows(NullPointerException.class, () -> {
            Controller.getTestController().opretPNOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,10),
                    null,
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    1
            );
        });
    }

    @Test
    void testCase5(){
        assertThrows(NullPointerException.class, () -> {
            Controller.getTestController().opretPNOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,10),
                    new Patient("010125-2025", "Christian", 85.5),
                    null,
                    1
            );
        });
    }

    @Test
    void testCase6(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretPNOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,10),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    0
            );
        });
        assertEquals("antal må ikke være under 1", exception.getMessage());
    }

}
