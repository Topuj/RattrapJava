package controller;

import java.sql.SQLException;

import model.IGrid;
import model.ILightCycle;
import view.IUserOrder;
import view.IView;

public class TronController implements IOrderPerformer, IController {
    private static int  TIME_SLEEP = 30;
    private final IGrid grid;
    private boolean     isGameOver = false;
    private IView       view;

    public TronController(final IGrid grid) {
        this.grid = grid;
    }

    @Override
    public void orderPerform(final IUserOrder userOrder) {
        if (userOrder != null) {
            final ILightCycle lightcycle = this.grid.getLightCycleByPlayer(userOrder.getPlayer());
            if (lightcycle != null) {
                int direction;
                switch (userOrder.getOrder()) {
                case RIGHT:
                    direction = (lightcycle.setDirection(
                            ((this.grid.getLightCycleByPlayer(userOrder.getPlayer()).getDirection() + 1) + 4) % 4));
                    break;
                case LEFT:
                    direction = (lightcycle.setDirection(
                            ((this.grid.getLightCycleByPlayer(userOrder.getPlayer()).getDirection() - 1) + 4) % 4));
                    break;
                case NOP:
                default:
                    direction = lightcycle
                            .setDirection(this.grid.getLightCycleByPlayer(userOrder.getPlayer()).getDirection());
                    break;

                }

                lightcycle.setDirection(direction);
            }
        }
    }

    @Override
    public void checkCollision() {
        for (int player = 0; player < 2; player++) {
            if (this.grid.getMatrixXY(this.grid.getLightCycleByPlayer(player).getPosition().getX(),
                    this.grid.getLightCycleByPlayer(player).getPosition().getY()).isWall()) {
                this.grid.getLightCycleByPlayer(player).die();
                this.isGameOver = true;
            }
        }
    }

    @Override
    public void play() throws SQLException {
        final long begin = System.currentTimeMillis();
        this.gameLoop();
        if (!this.grid.getLightCycleByPlayer(0).isAlive() && !this.grid.getLightCycleByPlayer(1).isAlive()) {
            this.view.displayMessage("Tie !!! Replay");
            this.grid.setResult(0, (System.currentTimeMillis() - begin) / 1000);
        } else if (!this.grid.getLightCycleByPlayer(0).isAlive()) {
            this.view.displayMessage("Player 2 wins");
            this.grid.setResult(2, (System.currentTimeMillis() - begin) / 1000);
        } else if (!this.grid.getLightCycleByPlayer(1).isAlive()) {
            this.view.displayMessage("Player 1 wins");
            this.grid.setResult(1, (System.currentTimeMillis() - begin) / 1000);
        }
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
            this.checkCollision();
            this.grid.addWall(0);
            this.grid.addWall(1);
            for (final ILightCycle lightCycle : this.grid.getLightCycles()) {
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
