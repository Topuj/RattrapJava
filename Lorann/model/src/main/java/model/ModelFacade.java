package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IGrid {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    @Override
    public ILightCycle getLightCycleByPlayer(final int player) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setWidth(final int width) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHeight(final int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public IMotionLess getMatrixXY(final int x, final int y) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setMatrixXY(final IMotionLess motionLess, final int x, final int y) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<ILightCycle> getLightCycles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLightCyclesHaveMoved() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addWall(final int player) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addLightCycle(final ILightCycle lightCycle) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setResult(final int player, final long time) throws SQLException {
        // TODO Auto-generated method stub

    }
}
