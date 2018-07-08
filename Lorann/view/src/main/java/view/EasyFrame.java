package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;

import model.IGrid;

public class EasyFrame extends JFrame implements IEasyFrame, KeyListener {

    private static final long     serialVersionUID = 1L;
    public static final int       ZOOM             = 1;
    private final IEventPerformer eventPerformer;

    public EasyFrame(final String title, final EventPerformer eventPerformer,
            final TronGraphicsBuilder tronGraphicsBuilder, final IGrid grid, final Observable observable) {
        this.eventPerformer = eventPerformer;

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setVisible(true);

        final EasyPanel easyPanel = new EasyPanel(new TronGraphicsBuilder(grid));
        this.setContentPane(easyPanel);
        this.setBackground(Color.BLACK);
        this.setSize((grid.getWidth() * EasyFrame.ZOOM) + this.getInsets().left + this.getInsets().right,
                (grid.getHeight() * EasyFrame.ZOOM) + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        observable.addObserver(easyPanel);
    }

    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        this.eventPerformer.eventPerform(keyEvent);
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // TODO Auto-generated method stub

    }
}
