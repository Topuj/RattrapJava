package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ExampleDAO;

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

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
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
}
