package src.ex1;

public abstract class Car {
    private boolean isClean;
    private double width;
    private double height;
    private double length;

    public Car(boolean isClean, double length, double height, double width) {
        this.isClean = isClean;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isClean=" + isClean +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
