package CarRacing.Domain;

import CarRacing.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }


}
