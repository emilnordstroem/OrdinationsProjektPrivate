package DagligSkaevTest;

import ordination.DagligSkaev;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DoegnDosisTest {

    private DagligSkaev dagligSkaev;

    @BeforeEach
    void opretDagligSkaev(){
        dagligSkaev = new DagligSkaev(LocalDate.now(), LocalDate.now());
    }

    @Test
    void testCase1(){
        for(int dosisIndex = 0; dosisIndex < 6; dosisIndex++){
            dagligSkaev.opretDosis(LocalTime.now(), 1);
        }
        double actualResult = dagligSkaev.doegnDosis();
        assertEquals(6, actualResult);
    }

    @Test
    void testCase2(){
        for(int dosisIndex = 0; dosisIndex < 6; dosisIndex++){
            dagligSkaev.opretDosis(LocalTime.now(), 0);
        }
        double actualResult = dagligSkaev.doegnDosis();
        assertEquals(0, actualResult);
    }

}
