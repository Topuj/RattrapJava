package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class EasyPanel extends JPanel implements Observer {
    private static final long          serialVersionUID = 3987064896591403626L;
    private final ITronGraphicsBuilder graphicsBuilder;

    public EasyPanel(final ITronGraphicsBuilder graphicsBuilder) {
        this.graphicsBuilder = graphicsBuilder;
    }

    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        this.graphicsBuilder.applyModelToGraphic(graphics, this);
    }

}