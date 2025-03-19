package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast extends Ordination {
    private final Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDato, LocalDate slutDato) {
        super(startDato, slutDato);
        for (int index = 0; index < doser.length; index++) {
            doser[index] = new Dosis(LocalTime.now(), 0);
        }
    }

    public Dosis[] getDoser() {
        return doser;
    }

    public void opretDosis(LocalTime tid, double antal) {
        int hour = tid.getHour();
        if(hour == 0){
            hour++;
        }

        int[] indexMapping = {3, 0, 1, 2}; // 0-6 -> 3, 7-11 -> 0, 12-17 -> 1, 18-23 -> 2
        int index = indexMapping[hour / 6];

        doser[index] = new Dosis(tid, doser[index].getAntal() + antal);
    }

    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for (Dosis dosis : doser) {
            samletDosis += (dosis.getAntal() * super.antalDage());
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / super.antalDage();
    }

    @Override
    public String getType() {
        return "DagligFast";
    }


}
