package Controllers;

import Models.CarModel;
import View.ListsDisplay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class CarMenuController extends MainController {
    Scanner scanner = new Scanner(System.in);
    public void displayAvailableCars(){
        System.out.println("Cars in our rental:");
        ListsDisplay listsDisplay = new ListsDisplay((LinkedList) super.getCars().getAvaliableCars());
        listsDisplay.displayList();
    }
    public void editCarPrice(){
        int carIndex = collectIndex((LinkedList) super.getCars().getAvaliableCars());
        BigDecimal newPrice = new BigDecimal(collectValidPrice());
        CarModel car = super.getCars().getAvaliableCars().get(carIndex - 1);
        car.setDayCost(newPrice);
        System.out.println("Cost udated");
    }
    private int collectIndex(LinkedList list) {
        System.out.println("Which car would you like to edit price for?");
        displayAvailableCars();
        String index = scanner.nextLine();
        if (isCorrectIndex(index, list.size())) {
            return Integer.parseInt(index);
        }else {
            System.out.println("Choose correct index..");
            editCarPrice();
        }
        return 0;
    }
    private double collectValidPrice() {
        System.out.println("Enter new price:");
        String price = scanner.nextLine();
        if (isCorrectPrice(price)) {
            return Double.parseDouble(price);
        }else {
            System.out.println("New price is incorrect..");
            return collectValidPrice();
        }
    }

    public void addCar(){
        if (super.getCars().getAllCars().size() <= 100) {
            System.out.println("Specify data for new car:");
            String brand = collectNotEmpty("Specify brand: ");
            String model = collectNotEmpty("Specify model: ");
            int mileAge = getCorrectMilage();
            LocalDate date = getProductionDate();
            BigDecimal price =  getDayCost();
            CarModel newCar = new CarModel(brand,model,mileAge,date,price);
            super.getCars().getAllCars().add(newCar);
            super.getCars().getAvaliableCars().add(newCar);
            System.out.println("Car: " + newCar);
            System.out.println("  . .    was added.");
        }else {
            System.out.println("You can't add more than 100 cars..");
        }

    }

    private int getCorrectMilage() {
        System.out.println("Specify mileage:");
        String milage = scanner.nextLine();
        if (isInteger(milage)){
            int newMilage = Integer.parseInt(milage);
            if (newMilage > 0) {
                return newMilage;
            }
        }
        System.out.println("Invalid milage..");
        return getCorrectMilage();
    }
    private LocalDate getProductionDate() {
        System.out.println("Specify year of production(in format yyyy-mm-dd):");
        String date = scanner.nextLine();
        try {
            return LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("Invalid date..");
            return getProductionDate();
        }
    }
    private BigDecimal getDayCost(){
        System.out.println("Specify price per day:");
        String cost = scanner.nextLine();
        if (isDouble(cost)){
            double newCost = Double.parseDouble(cost);
            if (newCost > 0){
                return new BigDecimal(newCost);
            }
        }
        System.out.println("Invalid cost..");
        return getDayCost();
    }
    private boolean isCorrectPrice(String price) {
        if (isDouble(price)) {
            if (Double.parseDouble(price) > 0.0) {
                return true;
            }
        }
        return false;
    }
    private boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}