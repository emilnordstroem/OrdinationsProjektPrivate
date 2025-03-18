package DagligFastTest;

import ordination.DagligFast;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoegnDosisTest {
    private DagligFast dagligFast;

    @Test
    void testCase12() {
        dagligFast = new DagligFast(
                LocalDate.of(2025,1,1),
                LocalDate.of(2025, 1,1)
        );
        LocalTime[] tidspunkter = {
                LocalTime.of(8,0),
                LocalTime.of(12,0),
                LocalTime.of(18,0),
                LocalTime.of(22, 0)
        };
        for(int dosisIndex = 0; dosisIndex < 4; dosisIndex++){
            dagligFast.opretDosis(tidspunkter[dosisIndex], 1);
        }

        double actualResult = dagligFast.doegnDosis();
        assertEquals(4, actualResult);
    }

    @Test
    void testCase13(){
        dagligFast = new DagligFast(
                LocalDate.of(2025,1,1),
                LocalDate.of(2025, 1,1)
        );
        LocalTime[] tidspunkter = {
                LocalTime.of(8,0),
                LocalTime.of(12,0),
                LocalTime.of(18,0),
                LocalTime.of(22, 0)
        };
        for(int dosisIndex = 0; dosisIndex < 4; dosisIndex++){
            dagligFast.opretDosis(tidspunkter[dosisIndex], 0);
        }

        double actualResult = dagligFast.samletDosis();
        assertEquals(0, actualResult);
    }


}
