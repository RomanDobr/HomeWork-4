package src.ex1;

public class CarWash {
    private Car car;

    private int countCars;

    public void doWash() {
        car.setClean(true);
    }


    public int doCostOfWashing (Car car) {
        if ((car.getLength() > 6) && (car.getHeight() > 2.5) && (car.getWidth() > 2)) {
            return 4_000;
        }
        return 2_000;
    }

    public int doCostOfWashingAll (int countCars, Car car) {
        return doCostOfWashing(car) * countCars;
    }
}
