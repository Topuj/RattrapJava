package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IGrid {

    public int getWidth();

    public int getHeight();

    public void setWidth(int width);

    public void setHeight(int height);

    public IMotionLess getMatrixXY(int x, int y);

    public void setMatrixXY(final IMotionLess motionLess, final int x, final int y);

    public ArrayList<ILightCycle> getLightCycles();

    ILightCycle getLightCycleByPlayer(int player);

    public void setLightCyclesHaveMoved();

    public void addWall(final int player);

    public void addLightCycle(final ILightCycle lightCycle);

    public void setResult(final int player, final long time) throws SQLException;
}
