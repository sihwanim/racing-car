package domain;

import domain.Engine;

public class SteadyEngine implements Engine {
    @Override
    public boolean canMove() {
        return true;
    }
}
