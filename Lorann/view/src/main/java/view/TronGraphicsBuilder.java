package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import model.IGrid;

public class TronGraphicsBuilder implements ITronGraphicsBuilder {
	private IGrid grid;
	
	TronGraphicsBuilder(final IGrid grid){
		this.grid = grid;
	}
	
	private void clearGraphics(final Graphics graphics) {
		graphics.clearRect(0, 0, this.grid.getWidth() * EasyFrame.ZOOM, this.grid.getHeight() * EasyFrame.ZOOM);
	}
	
	public void applyModelToGraphic(final Graphics graphics, ImageObserver observer) {
		this.clearGraphics(graphics);
	}
	
}