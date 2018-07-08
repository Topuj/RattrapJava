package controller;

import java.sql.SQLException;

import model.IGrid;
import view.IUserOrder;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView view;

    /** The model. */
    private final IGrid grid;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IGrid grid) {
        super();
        this.view = view;
        this.grid = grid;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IGrid getGrid() {
        return this.grid;
    }

    @Override
    public void orderPerform(final IUserOrder userOrder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void play() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void gameLoop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setView(final IView view) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkCollision() {
        // TODO Auto-generated method stub

    }
}
