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
        //TODO EXCEPTION
        Patient patient = Controller.getTestController().opretPatient(
                "xxxx-20dd",
                "0",
                -1
        );
    }

}
