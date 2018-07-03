package model;

import java.awt.Color;

public interface ILightCycle {

    public IGrid getGrid();

    public Boolean getAlive();

    public Color getColor();

    public void die();

    public void move();

    public void moveUp();

    public void moveDown();

    public void moveRight();

    public void moveLeft();

    public Direction getDirection();

    public void setDirection(Direction direction);

}
