package ControllerTest;

import controller.Controller;
import ordination.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OpretPatientTest {

    @Test
    void testCase44(){
        Patient patient = Controller.getTestController().opretPatient(
                "010125-0000",
                "Marianne",
                61.5
        );
        assertNotNull(patient);
    }

    @Test
    void testCase45(){
        Patient patient = Controller.getTestController().opretPatient(
                "010125-0000",
                "Marianne",
                0.0
        );
        assertNotNull(patient);
    }

    @Test
    void testCase46(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Patient patient = Controller.getTestController().opretPatient(
                    "xxxxxxXX-2025",
                    "Marianne",
                    -1
            );
        });
        assertEquals("ugyldig CPR", exception.getMessage());
    }

    // Denne test har ikke et korrekt numerisk TestCaseID
    @Test
    void testCase4X(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Patient patient = Controller.getTestController().opretPatient(
                    "xxxxxx-2025",
                    "Marianne",
                    -1
            );
        });
        assertEquals("acceptere ikke negativt numerisk vaegt", exception.getMessage());
    }

}
