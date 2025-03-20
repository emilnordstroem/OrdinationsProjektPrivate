package OrdinationTest;

import ordination.DagligFast;
import ordination.Ordination;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class OpretObjektTest {

    @Test
    void testCase1() {
        Ordination ordination = new DagligFast(LocalDate.of(2024,3, 5), LocalDate.of(2024,3,10));
        assertInstanceOf(Ordination.class, ordination);
    }

    @Test
    void testCase2() {
        assertThrows(IllegalArgumentException.class, () -> new DagligFast(LocalDate.of(2024,3, 10), LocalDate.of(2024,3,5)));
    }

    @Test
    void testCase3() {
        assertThrows(NullPointerException.class, () -> new DagligFast(null, LocalDate.of(2024,3,5)));
    }

    @Test
    void testCase4() {
        assertThrows(NullPointerException.class, () -> new DagligFast(LocalDate.of(2024,3, 10), null));
    }

    @Test
    void testCase5() {
        assertThrows(NullPointerException.class, () -> new DagligFast(null, null));
    }

    @Test
    void testCase6() {
        Ordination ordination = new DagligFast(LocalDate.of(2024,12, 31), LocalDate.of(2024,12,31));
        assertInstanceOf(Ordination.class, ordination);
    }

}
