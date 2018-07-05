package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IGrid {

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleById(int id) throws SQLException;

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleByName(String name) throws SQLException;

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    List<Example> getAllExamples() throws SQLException;

    public int getWidth();

    public int getHeight();

    public void setWidth(int width);

    public void setHeight(int height);

    public IMotionLess getMatrixXY(int x, int y);

    public void setMatrixXY(final IMotionLess motionLess, final int x, final int y);

    public ArrayList<ILightCycle> getLightCycle();

    ILightCycle getLightCycleByPlayer(int player);

    public void setLightCyclesHaveMoved();

    public void addWall(final int player);

    public void addLightCycle(final ILightCycle lightCycle);
}
