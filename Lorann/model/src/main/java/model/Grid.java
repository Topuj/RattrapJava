package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.dao.TronDAO;

public class Grid extends Observable implements IGrid {
    private int                          width;
    private int                          height;
    private final IMotionLess[][]        matrix;
    private final ArrayList<ILightCycle> lightCycles;

    public Grid(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.lightCycles = new ArrayList<ILightCycle>();
        this.matrix = new IMotionLess[width][height];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if ((x == 0) || (x == (this.width - 1)) || (y == 0) || (y == (this.height - 1))) {
                    this.setMatrixXY(ElementGrid.WALL, x, y);
                } else {
                    this.setMatrixXY(ElementGrid.GROUND, x, y);
                }
            }
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public IMotionLess getMatrixXY(final int x, final int y) {
        return this.matrix[x][y];
    }

    @Override
    public void setMatrixXY(final IMotionLess motionLess, final int x, final int y) {
        this.matrix[x][y] = motionLess;
    }

    @Override
    public void setWidth(final int width) {
        this.width = width;

    }

    @Override
    public void setHeight(final int height) {
        this.height = height;

    }

    @Override
    public ArrayList<ILightCycle> getLightCycles() {
        return this.lightCycles;
    }

    @Override
    public ILightCycle getLightCycleByPlayer(final int player) {
        for (final ILightCycle lightCycle : this.lightCycles) {
            if (lightCycle.isPlayer(player)) {
                return lightCycle;
            }
        }
        return null;
    }

    @Override
    public void addWall(final int player) {
        this.setMatrixXY(ElementGrid.getElementGridByPlayer(player),
                this.getLightCycleByPlayer(player).getPosition().getX(),
                this.getLightCycleByPlayer(player).getPosition().getY());

    }

    @Override
    public void setLightCyclesHaveMoved() {
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void addLightCycle(final ILightCycle lightCycle) {
        this.lightCycles.add(lightCycle);
        lightCycle.setGrid(this);
    }

    @Override
    public void setResult(final int player, final long time) throws SQLException {
        TronDAO.setResult(player, time);
    }

}
