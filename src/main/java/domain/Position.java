package domain;

import java.util.Random;

public class Position {

	private final int position;
	private static final int CHANGE_POSITION_NUMBER = 4;

	public Position(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public Position changePosition(int randomNumber) {
		int newPosition = position;
		if (randomNumber >= CHANGE_POSITION_NUMBER) {
			newPosition += 1;
		}

		return new Position(newPosition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Position position1 = (Position) obj;
		return position == position1.position;
	}
}
