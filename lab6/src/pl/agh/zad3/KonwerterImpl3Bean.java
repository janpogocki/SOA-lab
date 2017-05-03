package pl.agh.zad3;

import javax.ejb.Stateful;

/**
 * Created by Jan on 02.05.2017.
 */
@Stateful(name = "KonwerterImpl3EJB")
public class KonwerterImpl3Bean implements Konwerter {
    public KonwerterImpl3Bean() {
    }

    @Override
    public double Fahr2Cels(double temp) {
        return ((double) 5/9)*(temp-32);
    }

    @Override
    public double Cels2Fahr(double temp) {
        return ((double) 9/5)*(temp+32);
    }
}
