package main;

import java.awt.Color;
import java.sql.SQLException;

import controller.TronController;
import model.Grid;
import model.LightCycle;
import model.Position;
import view.TronView;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {
    private final static int width  = 400;
    private final static int height = 600;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws SQLException {
        final Grid grid = new Grid(Main.width, Main.height);
        grid.addLightCycle(new LightCycle(2, new Position(50, 50), Color.GREEN, 0));
        grid.addLightCycle(new LightCycle(2, new Position(100, 200), Color.MAGENTA, 1));
        final TronController controller = new TronController(grid);
        controller.setView(new TronView(controller, grid, grid));
        controller.play();
    }

}
