package Lists;

import Models.CarModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

class ListsDisplayTest {

    @Test
    public void shouldDisplayNames() {
        List<String> names = new LinkedList<>();
        names.add("Jakub");
        names.add("Jakub");
        names.add("Kasia");
        names.add("Jakub");
        View.ListsDisplay list = new View.ListsDisplay((LinkedList) names);
        list.displayList();
    }
    @Test
    public void shouldDisplayCars() {
        CarModel car1 = new CarModel("Toyota", "Avensis", 500000, LocalDate.now(), new BigDecimal(100));
        CarModel car2 = new CarModel("Fiat", "Avensis", 500000, LocalDate.now(), new BigDecimal(100));
        CarModel car3 = new CarModel("Suzuki", "Avensis", 500000, LocalDate.now(), new BigDecimal(100));
        CarModel car4 = new CarModel("Opel", "Avensis", 500000, LocalDate.now(), new BigDecimal(100));
        List<CarModel> list = new LinkedList<>();
        list.add(car1);
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car1);
        View.ListsDisplay<CarModel> displayCars = new View.ListsDisplay<CarModel>((LinkedList<CarModel>) list);
        displayCars.displayList();

    }

}