package view;

import model.IMotionLess;

public enum ElementGrid implements IMotionLess {
    WALL, WALL1, WALL2, GROUND;

    public static ElementGrid getElementGridByPlayer(final int player) {
        if (player == 0) {
            return ElementGrid.WALL1;
        } else {
            return ElementGrid.WALL2;
        }
    }

}
