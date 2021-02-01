package Car;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarModel {
    private String model;
    private String brand;
    private int mileage;
    private LocalDate productionDate;
    private BigDecimal dayCost;

    @Override
    public String toString() {
             return brand + " - "
                    + model + ". Mileage: "
                    + mileage + ", year of production: "
                    + productionDate + ", price per day:"
                    + dayCost;
    }

    public void setDayCost(BigDecimal dayCost) {
        this.dayCost = dayCost;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getMileage() {
        return mileage;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public BigDecimal getDayCost() {
        return dayCost;
    }

    public CarModel(String model, String brand, int mileage, LocalDate productionDate, BigDecimal dayCost) {
        this.model = model;
        this.brand = brand;
        this.mileage = mileage;
        this.productionDate = productionDate;
        this.dayCost = dayCost;
    }
}
