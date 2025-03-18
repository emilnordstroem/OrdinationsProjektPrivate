package DagligFastTest;

import ordination.DagligFast;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class OpretObjektTest {

    @Test
    void opretDagligFast(){
        DagligFast dagligFast = new DagligFast(
                LocalDate.of(2025, 1,1),
                LocalDate.of(2025, 1,10)
        );
        assertNotNull(dagligFast);
    }

}
