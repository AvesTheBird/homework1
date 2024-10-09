import java.util.ArrayList;
import java.util.List;

public class TransportStorage<T extends Vehicle> {
    private List<T> storage;

    public TransportStorage() {
        this.storage = new ArrayList<>();
    }

    public void add(T vehicle) {
        storage.add(vehicle);
    }

    public void displayAll() {
        for (T vehicle : storage) {
            vehicle.displayInfo();
        }
    }
}
