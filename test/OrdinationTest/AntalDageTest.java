package OrdinationTest;

import ordination.DagligFast;
import ordination.Ordination;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AntalDageTest {

    @Test
    void testCase1(){
        Ordination ordination = new DagligFast(
                LocalDate.of(2024,3, 5),
                LocalDate.of(2024,3,10)
        );
        int actualResult = ordination.antalDage();
        assertEquals(6, actualResult);
    }

    @Test
    void testCase2(){
        Ordination ordination = new DagligFast(
                LocalDate.of(2024,3, 29),
                LocalDate.of(2024,4,2)
        );
        int actualResult = ordination.antalDage();
        assertEquals(5, actualResult);
    }

    @Test
    void testCase3(){
        Ordination ordination = new DagligFast(
                LocalDate.of(2024,12, 30),
                LocalDate.of(2025,1,2)
        );
        int actualResult = ordination.antalDage();
        assertEquals(4, actualResult);
    }

    @Test
    void testCase4(){
        Ordination ordination = new DagligFast(
                LocalDate.of(2024,3, 31),
                LocalDate.of(2024,4,1)
        );
        int actualResult = ordination.antalDage();
        assertEquals(2, actualResult);
    }

    @Test
    void testCase5(){
        Ordination ordination = new DagligFast(
                LocalDate.of(2024,3, 31),
                LocalDate.of(2025,3,31)
        );
        int actualResult = ordination.antalDage();
        assertEquals(366, actualResult);
    }

    @Test
    void testCase6(){
        Ordination ordination = new DagligFast(
                LocalDate.of(2024,12, 31),
                LocalDate.of(2025,1,1)
        );
        int actualResult = ordination.antalDage();
        assertEquals(2, actualResult);
    }

}
