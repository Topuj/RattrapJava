package controller;

import java.util.ArrayList;

import model.Direction;
import model.IGrid;
import model.ILightCycle;
import view.IUserOrder;
import view.IView;

public class TronController implements IOrderPerformer, IController {
    private static int    TIME_SLEEP = 30;
    private final IGrid   grid;
    private final boolean isGameOver = false;
    private IView         view;

    public TronController(final IGrid grid) {
        this.grid = grid;
    }

    @Override
    public void orderPerform(final IUserOrder userOrder) {
        if (userOrder != null) {
            final ILightCycle lightCycle = this.grid.getLightCycleByPlayer(userOrder.getPlayer());
            if (lightCycle != null) {
                int direction;
                switch (userOrder.getOrder()) {
                case RIGHT:
                    direction = (Direction.RIGHT.ordinal() + 1) % 4;
                    break;
                case LEFT:
                    direction = (Direction.LEFT.ordinal() - 1) % 4;
                    break;
                case NOP:
                default:
                    direction = this.grid.getLightCycleByPlayer(userOrder.getPlayer()).getDirection();
                    break;
                }
                lightCycle.setDirection(direction);

            }
        }
    }

    @Override
    public void play() {
        this.gameLoop();
        this.view.displayMessage("Game Over");
        this.view.closeAll();
    }

    @Override
    public void gameLoop() {
        while (!this.isGameOver) {
            try {
                Thread.sleep(TronController.TIME_SLEEP);
            } catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            final ArrayList<ILightCycle> initialLightCycles = new ArrayList<ILightCycle>();
            for (final ILightCycle lightCycle : this.grid.getLightCycle()) {
                initialLightCycles.add(lightCycle);
                this.grid.addWall(0);
                this.grid.addWall(1);
            }
            for (final ILightCycle lightCycle : initialLightCycles) {
                lightCycle.move();
            }
            this.grid.setLightCyclesHaveMoved();
        }
    }

    @Override
    public void setView(final IView view) {
        this.view = view;
    }
}
