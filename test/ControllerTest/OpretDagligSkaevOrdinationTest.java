package ControllerTest;

import controller.Controller;
import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class OpretDagligSkaevOrdinationTest {

    @Test
    void testCase1(){
        DagligSkaev dagligSkaev = Controller.getTestController().opretDagligSkaevOrdination(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,10),
                new Patient("010125-2025", "Christian", 85.5),
                new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                new LocalTime[]{
                        LocalTime.of(12, 0),
                        LocalTime.of(12, 40),
                        LocalTime.of(16, 0),
                        LocalTime.of(18, 45)
                },
                new double[]{ 0.5, 1, 2.5, 3 }
        );
        assertNotNull(dagligSkaev);
    }

    @Test
    void testCase2(){
        DagligSkaev dagligSkaev = Controller.getTestController().opretDagligSkaevOrdination(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,1),
                new Patient("010125-2025", "Christian", 85.5),
                new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                new LocalTime[]{ LocalTime.of(12, 0) },
                new double[]{ 0.5 }
        );
        assertNotNull(dagligSkaev);
    }

    @Test
    void testCase3(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretDagligSkaevOrdination(
                    LocalDate.of(2025, 1,10),
                    LocalDate.of(2025, 1,1),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    new LocalTime[]{
                            LocalTime.of(12, 0),
                            LocalTime.of(12, 40),
                            LocalTime.of(16, 0),
                            LocalTime.of(18, 45)
                    },
                    new double[]{ 0.5, 1, 2.5, 3 }
            );
        });
        assertEquals("startdato må ikke ligge efter slutdato", exception.getMessage());
    }

    @Test
    void testCase4(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Controller.getTestController().opretDagligSkaevOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,1),
                    null,
                    null,
                    null,
                    null
            );
        });
        assertEquals("patient/laegemiddel/klokkeSlet/antalEnheder er null", exception.getMessage());
    }

    @Test
    void testCase5(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretDagligSkaevOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,1),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    new LocalTime[]{
                            LocalTime.of(12, 0),
                            LocalTime.of(12, 40),
                            LocalTime.of(16, 0),
                    },
                    new double[]{ 0.5, 1, 2.5, 3 }
            );
        });
        assertEquals("uenstemmelse i arraylængde på klokkeSlet opmålt antalEnheder", exception.getMessage());
    }

    @Test
    void testCase6(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.getTestController().opretDagligSkaevOrdination(
                    LocalDate.of(2025, 1,1),
                    LocalDate.of(2025, 1,1),
                    new Patient("010125-2025", "Christian", 85.5),
                    new Laegemiddel("", 1,1.1,1,"Sprøjte"),
                    new LocalTime[]{
                            LocalTime.of(12, 0),
                            LocalTime.of(12, 40),
                            LocalTime.of(16, 0),
                            LocalTime.of(18, 45)
                    },
                    new double[]{ 0.5, 1, 2.5}
            );
        });
        assertEquals("uenstemmelse i arraylængde på klokkeSlet opmålt antalEnheder", exception.getMessage());
    }

}
