package Controllers;

import Models.UserModel;
import View.ListsDisplay;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserMenuController extends MainController{
    Scanner scanner = new Scanner(System.in);

 public void displayActivatedUsers(){
     System.out.println("Add details for new user:");
     ListsDisplay listsDisplay = new ListsDisplay((LinkedList) super.getUsers().getActivatedUsers());
     listsDisplay.displayList();
 }
 public void addNewUser(){
     String name = collectNotEmpty("Enter name:");
     String lastName = collectNotEmpty("Enter last name:");
     LocalDate birthDate;
     String pesel;
     do {
         pesel = getPesel();
         birthDate = getBirthDate(pesel);
     }while (!birthDate.equals(null));
     UserModel user = new UserModel(name,lastName,pesel,birthDate);
     super.getUsers().getDeactivatedUsers().add(user);
     System.out.println(user + " \n hes been added.");
 }
 private LocalDate getBirthDate(String pesel) {
     int year = Integer.parseInt(pesel.substring(0,2));
     int month = Integer.parseInt(pesel.substring(2,4));
     int day = Integer.parseInt(pesel.substring(4,6));
     LocalDate birthDate = null;
     if(month > 0 && month < 13){
         year += 1900;
     }else if(month > 20 && month < 33) {
         month -= 20;
         year += 2000;
     }else
         System.out.println("Incorrect date of birth..");
     try {
         birthDate = LocalDate.of(year,month,day);
     }catch (Exception e){
         System.out.println("Incorrect date..");
     }
     return birthDate;
 }
 private String getPesel(){
     System.out.println("Enter pesel:");
     String pesel = scanner.nextLine();
     if(Pattern.compile("\\d{11}").matcher(pesel).matches()){
        if(testPeselValidation(pesel)){
            return pesel;
        }
     }
     System.out.println("Incorrect PESEL..");
     return getPesel();
 }

    private boolean testPeselValidation(String pesel) {
        char[] test = pesel.toCharArray();
        int sum = 0;
        for (int i = 0; i < test.length; i++) {
            if (i == 1 || i == 5 || i == 9) {
                sum += ((int) test[i]) * 3;
            }else if (i == 2 || i ==6) {
                sum += ((int) test[i]) * 7;
            }else if (i == 3 || i == 7) {
                sum += ((int) test[i]) * 9;
            }else {
                sum += (int) test[i];
            }
        }
        return (sum % 10 == 0)? true:false;
    }
    public void activateUser() {
        System.out.println("Deactivated users: ");
        new ListsDisplay<UserModel>((LinkedList<UserModel>) super.getUsers().getDeactivatedUsers()).displayList();
        String index = scanner.nextLine();
        if (isCorrectIndex(index, super.getUsers().getDeactivatedUsers().size())) {
            int userIndex = Integer.parseInt(index) - 1;
            UserModel user = super.getUsers().getDeactivatedUsers().get(userIndex);
            super.getUsers().getActivatedUsers().add(user);
            super.getUsers().getDeactivatedUsers().remove(user);
            System.out.println(user);
            System.out.println("User activated.");
        }else {
            System.out.println("Incorrect index.. ");
            activateUser();
        }

    }
}
