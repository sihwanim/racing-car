package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Cars;
import util.generator.NameGenerator;
import util.generator.TrialNumberGenerator;
import util.validator.TrailNumberValidator;
import view.InputView;
import view.OutputView;

public class Controller {
	private Cars cars;
	private int trialNumber;

	public void run(){
		initialize();
		OutputView.printMessage();
		moveCarByTrialNumber();
		OutputView.printWinner(cars.findWinners());
	}

	private void initialize(){
		cars = new Cars(getCars());
		trialNumber = getTrialNumber();
	}

	private List<Car> getCars(){
		List<Car> car = new ArrayList<>();
		try{
			List<String> names = NameGenerator.generatorCarsName(InputView.getCarNames());
			addNewCars(car, names);
			return car;
		} catch (IllegalArgumentException e){
			return getCars();
		}
	}

	private void addNewCars(List<Car> cars, List<String> names){
		for(String name : names){
			cars.add(new Car(name));
		}
	}

	private int getTrialNumber(){
		String input = InputView.getTrialNumber();
		try{
			return TrialNumberGenerator.generateTrialNumber(input);
		} catch (IllegalArgumentException e){
			return getTrialNumber();
		}
	}

	private void moveCarByTrialNumber(){
		for(int i = 0; i < trialNumber; i++){
			cars.go();
			OutputView.printCarPosition(cars.getCars());
		}
	}
}
