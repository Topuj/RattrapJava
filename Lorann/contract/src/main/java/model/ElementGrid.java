package model;

public enum ElementGrid implements IMotionLess {
    WALL, WALL1, WALL2, GROUND;

    public static ElementGrid getElementGridByPlayer(final int player) {
        if (player == 0) {
            return ElementGrid.WALL1;
        } else if (player == 1) {
            return ElementGrid.WALL2;
        } else {
            return ElementGrid.WALL;
        }
    }

    @Override
    public boolean isWall() {
        return (this == WALL) || (this == WALL1) || (this == WALL2);
    }

}
