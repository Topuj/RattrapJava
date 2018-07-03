package controller;

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
            final ILightCycle lightCycle = this.grid.getMobileByPlayer(userOrder.getPlayer());
            if (lightCycle != null) {
                Direction direction;
                switch (userOrder.getOrder()) {
                case RIGHT:
                    direction = (Direction.RIGHT.ordinal() + 1) % 4;
                    break;
                case LEFT:
                    direction = (Direction.LEFT.ordinal() - 1) % 4;
                    break;
                case NOP:
                default:
                    direction = this.grid.getMobileByPlayer(userOrder.getPlayer()).getDirection();
                    break;
                }
            }
        }
    }

    public void play() {
        this.gameLoop();
        this.view.displayMessage("Game Over");
        this.view.closeAll();
    }

    public void gameLoop() {
        while (!this.isGameOver) {
            try {
                Thread.sleep(TronController.TIME_SLEEP);
            } catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
