package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface ITronGraphicsBuilder {
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer);
}
