package src.ex1;

public class PassengerCar extends Car {
    private boolean hasCruiseControl;

    public PassengerCar(boolean isClean, double length, double height, double width) {
        super(isClean, length, height, width);
    }

    public void setHasCruiseControl(boolean hasCruiseControl) {
        this.hasCruiseControl = hasCruiseControl;
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "hasCruiseControl=" + hasCruiseControl +
                '}' + super.toString();
    }
}
