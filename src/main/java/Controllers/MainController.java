import Lists.CarLists;
import Lists.UserLists;

import java.util.Scanner;

public class MainController {
    private CarLists cars = new CarLists();
    private CarMenuController carMenuController = new CarMenuController();
    private UserLists users = new UserLists();
    private UserMenuController userMenuController = new UserMenuController();
    private Scanner scanner = new Scanner(System.in);

    public CarLists getCars() {
        return cars;
    }

    public UserLists getUsers() {
        return users;
    }

    public void menuController(int number) {
        switch (number) {
            case 1: carMenuController.displayAvailableCars();
            break;
            case 2: carMenuController.editCarPrice();
            break;
            case 3: carMenuController.addCar();
            break;
            case 4: userMenuController.displayActivatedUsers();
            break;
            case 5: userMenuController.addNewUser();
            break;
            case 6: userMenuController.activateUser();
            break;
            case 7:
        }
    }
    public String collectNotEmpty(String title){
        System.out.println(title);
        String string = scanner.nextLine();
        if (string.isEmpty()){
            System.out.println("This field can't be empty..");
            return collectNotEmpty(title);
        }
        return string;
    }
    public boolean isCorrectIndex(String index, int size){
        if(isInteger(index)) {
            int intIndex = Integer.parseInt(index);
            if(intIndex > 0 && intIndex <= size) {
                return true;
            }
        }
        return false;
    }
    public boolean isInteger(String number){
        try{
            Integer.parseInt(number);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
