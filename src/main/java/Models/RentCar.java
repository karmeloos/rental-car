package Models;

import Models.CarModel;
import Models.UserModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentCar {
    private CarModel car;
    private UserModel user;
    LocalDate rentStart;
    LocalDate rentStop;
    int days;
    BigDecimal cost;

    public RentCar(CarModel car, UserModel user, int days, BigDecimal cost) {
        this.car = car;
        this.user = user;
        this.days = days;
        this.cost = cost;
        this.rentStart = LocalDate.now();
    }

    public void setRentStart(LocalDate rentStart) {
        this.rentStart = rentStart;
    }

    public void setRentStop(LocalDate rentStop) {
        this.rentStop = rentStop;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public CarModel getCar() {
        return car;
    }

    public UserModel getUser() {
        return user;
    }

    public LocalDate getRentStart() {
        return rentStart;
    }

    public LocalDate getRentStop() {
        return rentStop;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String toString() {
        return user.getName() + " "
                + user.getLastName() + " rents car "
                + car.getModel() + " "
                + car.getModel() + " for "
                + days + " days a total cost of "
                + cost;
    }
}
