
package osThread;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelMain2 extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMain2()
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
		btnRun = new JButton("Run");
		label1 = new JLabel("THREAD 1");
		label2 = new JLabel("THREAD 2");
		label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Box VBox = Box.createVerticalBox();
		Box HBox = Box.createHorizontalBox();
		HBox.add(label1);
		HBox.add(Box.createHorizontalStrut(10));
		HBox.add(label2);
		VBox.add(btnRun);
		VBox.add(HBox);

		JPanel contentPane = new JPanel();

		// Layout : Specification
			{
			BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
			contentPane.setLayout(layout);
			setLayout(new FlowLayout());
			}

		// JComponent : add
		contentPane.add(VBox);
		add(contentPane);
		}

	private void control()
		{
		th1 = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				// TODO Auto-generated method stub
				somme += 5;
				}
			});

		th2 = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				// TODO Auto-generated method stub
				}
			});

		btnRun.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Auto-generated method stub
				start();
				}
			});
		}

	private void appearance()
		{
		// rien
		}

	private void start()
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Thread th1, th2;
	private JButton btnRun;
	private JLabel label1, label2;
	private int somme = 0;
	}
