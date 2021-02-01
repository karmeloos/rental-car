package User;

import java.time.LocalDate;

public class UserModel {

    private String name;
    private String lastName;
    private String pesel;
    private LocalDate bithDate;
    private int rentedCars;

    public UserModel(String name, String lastName, String pesel, LocalDate bithDate) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.bithDate = bithDate;
        this.rentedCars = 0;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public int getRentedCars() {
        return rentedCars;
    }

    @Override
    public String toString() {
        return name + " "
                + lastName + ", "
                + bithDate + ", "
                + rentedCars + ".";
    }
}
