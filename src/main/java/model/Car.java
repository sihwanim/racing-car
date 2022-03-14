package model;

import util.validator.NameValidator;

public class Car {
	private final String name;
	private int position;

	public Car(String name){
		NameValidator.validateName(name);
		this.name = name;
	}

	public void go(boolean canGo){
		if(canGo){
			this.position++;
		}
	}

	public int getPosition(){
		return position;
	}

	public String getName() {
		return name;
	}

	public boolean isSamePosition(int position){
		return this.position == position;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
