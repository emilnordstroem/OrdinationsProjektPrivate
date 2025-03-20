package DagligFastTest;

import ordination.DagligFast;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;

class SamletDosisTest {
    private DagligFast dagligFast;

    @Test
    void testCase1() {
        dagligFast = new DagligFast(
                LocalDate.of(2025,1,1),
                LocalDate.of(2025, 1,1)
        );
        LocalTime[] tidspunkter = {
                LocalTime.of(5,0),
                LocalTime.of(10,0),
                LocalTime.of(16,0),
                LocalTime.of(22, 0)
        };
        for(int dosisIndex = 0; dosisIndex < 4; dosisIndex++){
            dagligFast.opretDosis(tidspunkter[dosisIndex], 1);
        }

        double actualResult = dagligFast.samletDosis();
        assertEquals(4, actualResult);
    }

    @Test
    void testCase2() {
        dagligFast = new DagligFast(
                LocalDate.of(2025,1,1),
                LocalDate.of(2025, 1,1)
        );
        LocalTime[] tidspunkter = {
                LocalTime.of(5,0),
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
