public class CarRepairService implements Repairable<Car> {
    @Override
    public void repair(Car car) {
        System.out.println("Ремонт автомобиля: " + car.getModel());
    }
}
