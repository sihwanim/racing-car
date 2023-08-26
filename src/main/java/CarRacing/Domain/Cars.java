package CarRacing.Domain;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

}
