package Lists;

import Models.CarModel;

import java.util.LinkedList;
import java.util.List;

public class CarLists {
    private List<CarModel> allCars = new LinkedList<>();
    private List<CarModel> avaliableCars = new LinkedList<>();



    public List<CarModel> getAllCars() {
        return allCars;
    }

    public List<CarModel> getAvaliableCars() {
        return avaliableCars;
    }
}
