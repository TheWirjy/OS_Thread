package osThread;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameMain extends JFrame {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameMain() {
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry() {
		// JComponent : Instanciation
		panelMain = new JPanelMain();
		panelMain2 = new JPanelMain2();
		// Layout : Specification
		{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
		}

		// JComponent : add
		add(panelMain2, BorderLayout.CENTER);

	}

	private void control() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void appearance() {
		setSize(600, 900);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelMain panelMain;
	private JPanelMain2 panelMain2;
}