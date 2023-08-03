package domain;

public class Car {
	private static Name name;
	private static Position position;

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}
}
