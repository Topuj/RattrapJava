package model;

import java.awt.Color;

public class LightCycle implements ILightCycle {
    private final IGrid    grid;
    private Boolean        alive;
    private final Color    color;
    private final Position position;
    private Direction      direction;

    LightCycle(final IGrid grid, final Position position, final Color color) {
        this.grid = grid;
        this.color = color;
        this.position = position;
        this.alive = true;

    }

    @Override
    public IGrid getGrid() {
        return this.grid;
    }

    @Override
    public Boolean getAlive() {
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
        case UP:
            this.moveUp();
            break;
        case RIGHT:
            this.moveRight();
            break;
        case DOWN:
            this.moveDown();
            break;
        case LEFT:
            this.moveLeft();
            break;
        default:
            break;
        }

    }

    @Override
    public void moveUp() {
        this.position.setY(this.position.getY() + 1);
        // TODO Auto-generated method stub

    }

    @Override
    public void moveDown() {
        this.position.setY(this.position.getY() - 1);
        // TODO Auto-generated method stub

    }

    @Override
    public void moveRight() {
        this.position.setX(this.position.getX() + 1);
        // TODO Auto-generated method stub

    }

    @Override
    public void moveLeft() {
        this.position.setX(this.position.getX() - 1);
        // TODO Auto-generated method stub

    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(final Direction direction) {
        // TODO Auto-generated method stub

    }

}
