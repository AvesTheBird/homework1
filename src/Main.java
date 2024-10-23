public class main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 0, 100);
        Motorcycle moto1 = new Motorcycle("Harley", 0, false);

        car1.displayInfo();
        car1.accelerate();
        car1.brake();

        moto1.displayInfo();
        moto1.accelerate(); // шлем не надет, поэтому ускорение невозможно
        moto1.accelerate(); // ускорение, если шлем надет

        System.out.println("Всего автомобилей: " + Car.getTotalCars());
        System.out.println("Всего мотоциклов: " + Motorcycle.getTotalMotorcycles());
    }
}
