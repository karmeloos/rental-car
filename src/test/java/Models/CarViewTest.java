package Models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class CarViewTest {
    @Test
    public void shouldDisplayCarsDetails()
    {
        CarView carView = new CarView(new CarModel("Toyota", "Avensis", 500000, LocalDate.now(), new BigDecimal(100)));
        carView.display();
    }

}