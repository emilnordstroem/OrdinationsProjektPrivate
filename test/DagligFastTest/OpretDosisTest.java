package DagligFastTest;

import ordination.DagligFast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class OpretDosisTest {
    private DagligFast dagligFast;

    @BeforeEach
    void opretDagligFastObjekt(){
        dagligFast = new DagligFast(
                LocalDate.of(2025,1,1),
                LocalDate.of(2025, 1,1)
        );
    }

    @Test
    void testCase1() {
        dagligFast.opretDosis(LocalTime.now(), 5);
        double actualResult = dagligFast.samletDosis();
        assertEquals(5, actualResult);
    }

    @Test
    void testCase2() {
        dagligFast.opretDosis(LocalTime.now(), 0);
        double actualResult = dagligFast.samletDosis();
        assertEquals(0, actualResult);
    }

    @Test
    void testCase3() {
        assertThrows(IllegalArgumentException.class, () -> {
            dagligFast.opretDosis(LocalTime.now(), -1);
        });
    }

}