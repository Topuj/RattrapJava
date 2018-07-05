package model;

import java.awt.Color;

public interface ILightCycle {

    public Boolean getAlive();

    public Color getColor();

    public void die();

    public void move();

    public int getDirection();

    public void setDirection(int direction);

    public IPosition getPosition();

    public void setPosition(IPosition position);

    public boolean isPlayer(final int player);

    public IGrid getGrid();

    public void setGrid(IGrid grid);

}
