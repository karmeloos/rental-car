package Lists;

import Models.RentCar;

import java.util.LinkedList;
import java.util.List;

public class RentedCarsList {
    private List<RentCar> rented = new LinkedList<>();
    private List<RentCar> currentlyRented = new LinkedList<>();

    public List<RentCar> getCurrentlyRented() {
        return currentlyRented;
    }

    public List<RentCar> getRented() {
        return rented;
    }
}
