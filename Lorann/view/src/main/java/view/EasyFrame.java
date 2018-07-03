package view;

import java.util.Observable;

import javax.swing.JFrame;
import model.IGrid;

public class EasyFrame extends JFrame implements IEasyFrame {
	
	private static final long serialVersionUID = 1L;
	public static final int		ZOOM				= 7;
	private Observable observable;

	public EasyFrame(final String title, final EventPerformer eventPerformer, final TronGraphicsBuilder tronGraphicsBuilder, final IGrid grid, final Observable observable) {

		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setObservable(observable);

		final EasyPanel easyPanel = new EasyPanel(new TronGraphicsBuilder(grid));
		this.setContentPane(easyPanel);
		this.setSize((grid.getWidth() * ZOOM) + this.getInsets().left + this.getInsets().right,
				(grid.getHeight() * ZOOM) + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		getObservable().addObserver(easyPanel);
	}

	public Observable getObservable() {
		return observable;
	}

	public void setObservable(Observable observable) {
		this.observable = observable;
	}
}
