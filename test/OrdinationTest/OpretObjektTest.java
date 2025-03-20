package OrdinationTest;

import ordination.DagligFast;
import ordination.Ordination;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class OpretObjektTest {

    @Test
    void testOrdinationOprettetForStartdatoFørSlutdato() {
        Ordination ordination = new DagligFast(LocalDate.of(2024,3, 5), LocalDate.of(2024,3,10));
        assertInstanceOf(Ordination.class, ordination);
    }

    @Test
    void testOrdinationIkkeOprettetForStartdatoEfterSlutdato() {
        assertThrows(IllegalArgumentException.class, () -> new DagligFast(LocalDate.of(2024,3, 10), LocalDate.of(2024,3,5)));
    }

    @Test
    void testOrdinationIkkeOprettetForStartdatoNull() {
        assertThrows(NullPointerException.class, () -> new DagligFast(null, LocalDate.of(2024,3,5)));
    }

    @Test
    void testOrdinationIkkeOprettetForSlutdatoNull() {
        assertThrows(NullPointerException.class, () -> new DagligFast(LocalDate.of(2024,3, 10), null));
    }

    @Test
    void testOrdinationIkkeOprettetForBådeStartOgSlutdatoNull() {
        assertThrows(NullPointerException.class, () -> new DagligFast(null, null));
    }

    @Test
    void testOrdinationOprettetForBådeStartOgSlutdatoSamme() {
        Ordination ordination = new DagligFast(LocalDate.of(2024,12, 31), LocalDate.of(2024,12,31));
        assertInstanceOf(Ordination.class, ordination);
    }

}
