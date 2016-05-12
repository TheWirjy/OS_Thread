
package osThread;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMain extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMain()
		{
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

	private void geometry()
		{
		// JComponent : Instanciation
		btnRun = new JButton("Run all");
		calcul1 = new JPanelCalculTab(1);
		calcul2 = new JPanelCalculTab(2);

		Dimension dim = new Dimension(200, 100);
		calcul1.setSize(dim);
		calcul1.setPreferredSize(dim);
		calcul1.setMinimumSize(dim);
		calcul1.setLocation(10, 10);

		calcul2.setSize(dim);
		calcul2.setPreferredSize(dim);
		calcul2.setMinimumSize(dim);
		calcul2.setLocation(10, 120);

		dim = new Dimension(180, 20);
		btnRun.setSize(dim);
		btnRun.setPreferredSize(dim);
		btnRun.setMinimumSize(dim);
		btnRun.setLocation(20, 230);

		setLayout(null);

		add(btnRun);
		add(calcul1);
		add(calcul2);
		}

	private void control()
		{
		btnRun.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Auto-generated method stub
				calcul1.calcul();
				calcul2.calcul();
				}
			});
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelCalculTab calcul1;
	private JPanelCalculTab calcul2;
	private JButton btnRun;
	}
