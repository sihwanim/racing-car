package model;

import java.util.ArrayList;
import java.util.List;
import util.validator.RandomGoForward;

public class Cars {
	private final List<Car> cars;

	 public Cars(List<Car> cars){
	 	this.cars = cars;
	 }

	 public void go(){
	 	for(Car c : cars){
	 		c.go(RandomGoForward.goFoward());
		}
	 }

	public List<Car> getCars() {
		return cars;
	}

	public List<String> findWinners(){
	 	List<String> winners = new ArrayList<>();
	 	int fartherest = getFartherestPosition();

	 	for(Car c : cars){
	 		if(c.getPosition() == fartherest)
	 			winners.add(c.getName());
		}
	 	return winners;
	}

	public int getFartherestPosition(){
	 	return cars.stream()
			.map(Car::getPosition)
			.max(Integer::compare)
			.orElse(-1);
	}
}
