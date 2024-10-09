public class Car extends Vehicle implements Acceleratable, Brakable {
    private int fuelLevel;
    private static int totalCars;

    public Car(String model, int speed, int fuelLevel) {
        super(model, speed);
        this.fuelLevel = fuelLevel;
        totalCars++;
    }

    @Override
    public void accelerate() {
        if (fuelLevel > 0) {
            speed += 10;
            fuelLevel -= 5;
            System.out.println(model + " ускоряется. Текущая скорость: " + speed + " км/ч.");
        } else {
            System.out.println("Недостаточно топлива для ускорения.");
        }
    }

    @Override
    public void brake() {
        if (speed > 0) {
            speed -= 10;
            System.out.println(model + " тормозит. Текущая скорость: " + speed + " км/ч.");
        } else {
            System.out.println(model + " уже остановлен.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Модель: " + model + ", Скорость: " + speed + " км/ч, Топливо: " + fuelLevel);
    }

    public static int getTotalCars() {
        return totalCars;
    }
}
