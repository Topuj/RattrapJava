package model;

import java.awt.Color;

public class LightCycle implements ILightCycle {
    private Boolean     alive;
    private final Color color;
    private IPosition   position;
    private IGrid       grid;
    private int         direction;
    private final int   player;

    public LightCycle(final int direction, final IPosition position, final Color color, final int player) {
        this.direction = direction;
        this.color = color;
        this.position = position;
        this.alive = true;
        this.player = player;
    }

    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void die() {
        this.alive = false;
    }

    @Override
    public void move() {
        switch (this.direction) {
        case 0:
            this.moveUp();
            break;
        case 1:
            this.moveRight();
            break;
        case 2:
            this.moveDown();
            break;
        case 3:
            this.moveLeft();
            break;
        default:
            break;
        }

    }

    private void moveUp() {
        this.position.setY(this.position.getY() - 1);
        // TODO Auto-generated method stub

    }

    private void moveDown() {
        this.position.setY(this.position.getY() + 1);
        // TODO Auto-generated method stub

    }

    private void moveRight() {
        this.position.setX(this.position.getX() + 1);
        // TODO Auto-generated method stub

    }

    private void moveLeft() {
        this.position.setX(this.position.getX() - 1);
        // TODO Auto-generated method stub

    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    @Override
    public int setDirection(final int direction) {
        return this.direction = direction;

    }

    @Override
    public IPosition getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final IPosition position) {
        this.position = position;

    }

    @Override
    public boolean isPlayer(final int player) {
        return this.player == player;
    }

    @Override
    public IGrid getGrid() {
        return this.grid;
    }

    @Override
    public void setGrid(final IGrid grid) {
        this.grid = grid;
    }

}
