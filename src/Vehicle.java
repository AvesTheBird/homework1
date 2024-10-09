public abstract class Vehicle {
    protected String model;
    protected int speed;

    public Vehicle(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public abstract void displayInfo();

    public void currentSpeed() {
        System.out.println("Current speed: " + speed + " km/h");
    }
}
