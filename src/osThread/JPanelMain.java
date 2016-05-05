
package osThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
		JPanel contentPane = new JPanel();

		// Layout : Specification
			{
			BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
			contentPane.setLayout(layout);
			}

		// JComponent : add
			contentPane.add(btnRun);
			contentPane.add(calcul1);
			contentPane.add(calcul2);
			add(contentPane);
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
