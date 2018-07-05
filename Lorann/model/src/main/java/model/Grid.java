package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import view.ElementGrid;

public class Grid extends Observable implements IGrid {
    private int                          width;
    private int                          height;
    private IMotionLess[][]              matrix;
    private final ArrayList<ILightCycle> lightCycles;

    public Grid(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.lightCycles = new ArrayList<ILightCycle>();
        // TODO Auto-generated constructor stub
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
    public ArrayList<ILightCycle> getLightCycle() {
        return this.lightCycles;
    }

    @Override
    public Example getExampleById(final int id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Example getExampleByName(final String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Example> getAllExamples() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ILightCycle getLightCycleByPlayer(final int player) {
        for (final ILightCycle lightCycle : this.lightCycles) {
            if (lightCycle.isPlayer(player)) {

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

}
