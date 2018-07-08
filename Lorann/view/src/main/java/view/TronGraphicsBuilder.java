package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import model.IGrid;
import model.ILightCycle;

public class TronGraphicsBuilder implements ITronGraphicsBuilder {
    private final IGrid grid;

    TronGraphicsBuilder(final IGrid grid) {
        this.grid = grid;
    }

    public void drawAllLightCycle(final Graphics graphics) {
        for (final ILightCycle lightCycle : this.grid.getLightCycles()) {
            this.drawLightCycle(graphics, lightCycle);
        }
    }

    public void drawBorderWall(final Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, 399, 599);

    }

    public void drawLightCycle(final Graphics graphics, final ILightCycle lightCycle) {
        graphics.setColor(lightCycle.getColor());
        graphics.fillRect(lightCycle.getPosition().getX() * EasyFrame.ZOOM,
                lightCycle.getPosition().getY() * EasyFrame.ZOOM, EasyFrame.ZOOM, EasyFrame.ZOOM);
    }

    @Override
    public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
        this.drawAllLightCycle(graphics);
        this.drawBorderWall(graphics);
    }
}