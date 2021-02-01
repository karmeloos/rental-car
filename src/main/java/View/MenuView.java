package Menu;

public class MenuView {
    private String[] menu = {
            "List available cars",
            "Edit rental price",
            "Add new car",
            "List active users",
            "Add user",
            "Activate a user",
            "Rent a car",
            "List all rented cars",
            "Return a car",
            "Display monthly report",
            "Display yearly report",
            "Exit"
    };

    public void displayMenu(){
        System.out.println("Welcome to car rental:");
        int n = 1;
        for (String s :
                menu) {
            System.out.println((n++) + ". " + s );
        }
        System.out.println("Choose your option:");
    }

}
