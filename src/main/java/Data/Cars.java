package Data;

import Models.CarModel;
import Lists.CarLists;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cars {
    private CarLists carLists;

    public Cars(CarLists carLists) {
        this.carLists = carLists;
        addCars();
    }
    private void addCars() {
        CarModel car1 = new CarModel("X6", "BMW", 1300000, LocalDate.of(2015,03,25), new BigDecimal(500.00));
        carLists.getAllCars().add(car1);
        carLists.getAvaliableCars().add(car1);

        CarModel car2 = new CarModel("Yaris", "Toyota", 2340000, LocalDate.of(2018,9,1), new BigDecimal(350.00));
        carLists.getAllCars().add(car2);
        carLists.getAvaliableCars().add(car2);

        CarModel car3 = new CarModel("Swift", "Suzuki", 324000, LocalDate.of(2013,11,1), new BigDecimal(300.00));
        carLists.getAllCars().add(car3);
        carLists.getAvaliableCars().add(car3);

        CarModel car4 = new CarModel("Arteon", "Volkswagen", 1900000, LocalDate.of(2005,03,21), new BigDecimal(280.00));
        carLists.getAllCars().add(car4);
        carLists.getAvaliableCars().add(car4);

        CarModel car5 = new CarModel("Q7", "Audi", 2340000, LocalDate.of(2020,01,1), new BigDecimal(530.00));
        carLists.getAllCars().add(car5);

        CarModel car6 = new CarModel("Focus", "Ford", 1030000, LocalDate.of(2019,12,25), new BigDecimal(400.00));
        carLists.getAllCars().add(car6);

        CarModel car7 = new CarModel("Fabia", "Skoda", 3250000, LocalDate.of(2015,5,1), new BigDecimal(430.00));
        carLists.getAllCars().add(car7);
    }
}
