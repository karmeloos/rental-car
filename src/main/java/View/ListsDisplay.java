package CarLists;

import Car.CarModel;

import java.util.LinkedList;
import java.util.List;

public class ListsDisplay<T> {
    private LinkedList<T> list;
    private int count;

    public ListsDisplay(LinkedList<T> list) {
        this.list = list;
    }

    public void displayList() {
        count = 1;
        list.forEach(l -> {
                    System.out.print((count++) + ". ");
                    System.out.println(l);
                });
    }

}
