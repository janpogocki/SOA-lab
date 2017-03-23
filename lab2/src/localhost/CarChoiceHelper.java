package localhost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 22.03.2017.
 */
public class CarChoiceHelper {
    private class PriceAndNameAndType {
        private int price;
        private String name;
        private String type;

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public PriceAndNameAndType(int price, String name, String type) {
            this.price = price;
            this.name = name;
            this.type = type;
        }
    }

    private String rodzaj;
    private int cenaMin;
    private int cenaMax;
    private List<PriceAndNameAndType> cars;

    public CarChoiceHelper(String rodzaj, String przedzialCenowy){
        this.rodzaj = rodzaj;
        String [] przedzialCenowySplit = przedzialCenowy.split("-");
        cenaMin = Integer.parseInt(przedzialCenowySplit[0]);
        cenaMax = Integer.parseInt(przedzialCenowySplit[1]);

        // adding cars
        cars = new ArrayList<>();
        cars.add(new PriceAndNameAndType(500000, "Porsche", "sportowy"));
        cars.add(new PriceAndNameAndType(750000, "Lamborghini Murciélago", "sportowy"));
        cars.add(new PriceAndNameAndType(1000000, "Ferrari", "sportowy"));

        cars.add(new PriceAndNameAndType(10000, "Smart", "miejski"));
        cars.add(new PriceAndNameAndType(999, "Multipla", "miejski"));
        cars.add(new PriceAndNameAndType(2000, "Tico", "miejski"));

        cars.add(new PriceAndNameAndType(700000, "Mercedes S", "lukusowy"));
        cars.add(new PriceAndNameAndType(800000, "Audi A8", "lukusowy"));
        cars.add(new PriceAndNameAndType(1500000, "Bentlay", "lukusowy"));

    }

    public List<String> getListOfCars(){
        List<String> returned = new ArrayList<>();

        for (PriceAndNameAndType element : cars){
            if (element.getPrice() >= cenaMin && element.getPrice() <= cenaMax && element.getType().equals(rodzaj))
                returned.add(element.getName() + " (" + element.getPrice() + " PLN)");
        }

        return returned;
    }
}
