package Controllers;

import Models.CarModel;
import Models.RentCar;
import Models.UserModel;
import View.ListsDisplay;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;

public class RentController extends MainController{
    Scanner scanner = new Scanner(System.in);

    public void returnCar(){
        LinkedList<RentCar> list = (LinkedList<RentCar>) super.getRentedCarsList().getCurrentlyRented();
        displayCurrentlyRented();
        System.out.println("Which rent should be aborted?");
        String index = scanner.nextLine();
        if (isCorrectIndex(index, list.size())) {
            int intIndex = Integer.parseInt(index) - 1;
            RentCar rentCar =
            super.getRentedCarsList().getCurrentlyRented().remove(intIndex);
        }else {
            System.out.println("Incorrect index..");

        }
    }

    public void displayCurrentlyRented(){
        System.out.println("Active rentals:");
        new ListsDisplay((LinkedList) super.getRentedCarsList().getCurrentlyRented());
    }

    public void rentACar() {
        UserModel user = getUser();
        CarModel car = getCar();
        int days = getDaysAmount();
        BigDecimal cost = car.getDayCost().multiply(BigDecimal.valueOf(days));
        if (getComfirmation(cost)) {
            rent(user, car, days, cost);
        }
    }

    private void rent(UserModel user, CarModel car, int days, BigDecimal cost){
        user.setRentedCars();
        super.getCars().getAvaliableCars().remove(car);
        RentCar rentCar = new RentCar(car, user, days, cost);
        super.getRentedCarsList().getRented().add(rentCar);
        super.getRentedCarsList().getCurrentlyRented().add(rentCar);
        System.out.println("Models rented");
    }

    private boolean getComfirmation(BigDecimal cost) {
        System.out.println("Rent will " + cost + ". Are you sure ? [yes/no]");
        String confirmation = scanner.nextLine();
        if(confirmation.equals("yes")){
            return true;
        }else if (confirmation.equals("no")){
            System.out.println("Rental aborted");
            return false;
        }else {
            System.out.println("Incorect entry..");
            return getComfirmation(cost);
        }
    }

    private int getDaysAmount(){
        System.out.println("For how many days?");
        String days = scanner.nextLine();
        if(isInteger(days)){
            int intDays = Integer.parseInt(days);
            if(intDays > 0){
                return intDays;
            }
        }
        System.out.println("Incorrect amount of days..");
        return getDaysAmount();
    }

    private CarModel getCar() {
        System.out.println("Cars in our rental:");
        LinkedList<CarModel> cars = (LinkedList<CarModel>) super.getCars().getAvaliableCars();
        new ListsDisplay<>(cars);
        System.out.println("Select car:");
        String index = scanner.nextLine();
        if(isCorrectIndex(index, cars.size())) {
            int intIndex = Integer.parseInt(index) - 1;
            return cars.get(intIndex);
        }else {
            System.out.println("Index invalide..");
            return getCar();
        }
    }

    private UserModel getUser() {
        LinkedList<UserModel> users = (LinkedList<UserModel>) super.getUsers().getActivatedUsers();
        System.out.println("Active users:");
        new ListsDisplay<>(users);
        System.out.println("Select user:");
        String index = scanner.nextLine();
        if(isCorrectIndex(index, users.size())) {
            int intIndex = Integer.parseInt(index) - 1;
            return users.get(intIndex);
        }else {
            System.out.println("Index invalide..");
            return getUser();
        }
    }
}
