package DagligSkaevTest;

import ordination.DagligSkaev;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OpretObjektTest {

    @Test
    void testCase1(){
        DagligSkaev dagligSkaev = new DagligSkaev(
                LocalDate.now(),
                LocalDate.now()
        );
        int actualResult = dagligSkaev.getDoser().size();
        assertEquals(0, actualResult);
    }

}
