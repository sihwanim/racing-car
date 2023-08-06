package domain;

import java.util.Random;

public class Car {
	private static Name name;
	private static Position position;
	private static final int INIT_POSITION = 0;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position(INIT_POSITION);
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position.getPosition();
	}

	public void goForward() {
		position = position.changePosition();
	}

	public boolean isSamePosition(int maxPosition) {
		return this.position.equals(maxPosition);
	}
}
