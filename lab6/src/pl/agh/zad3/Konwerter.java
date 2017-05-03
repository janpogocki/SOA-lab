package pl.agh.zad3;

import javax.ejb.Remote;

/**
 * Created by Jan on 26.04.2017.
 */

@Remote
public interface Konwerter {
    public double Fahr2Cels(double temp);
    public double Cels2Fahr(double temp);
}
