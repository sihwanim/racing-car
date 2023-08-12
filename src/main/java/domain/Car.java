package domain;

import java.util.Random;
import util.RandomUtil;

public class Car {
	private Name name;
	private Position position;
	private static final int INIT_POSITION = 0;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position(INIT_POSITION);
	}

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}

	public String getName() {
		return this.name.getName();
	}

	public int getPosition() {
		return this.position.getPosition();
	}

	public void goForward() {
		RandomUtil randomUtil = new RandomUtil();
		int randomNumber = randomUtil.createRandomNumber();
		this.position = position.changePosition(randomNumber);
	}

	public boolean isSamePosition(int maxPosition) {
		return this.position.equals(new Position(maxPosition));
	}
}
