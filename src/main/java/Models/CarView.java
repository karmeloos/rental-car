package Car;

public class CarView {
    private CarModel car;

    public CarView(CarModel car) {
        this.car = car;
    }
    public void display() {
        System.out.println(car);
    }
}
