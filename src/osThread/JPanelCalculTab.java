
package osThread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JPanelCalculTab extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCalculTab(int nbThread)
		{
		progressBar = new JProgressBar[nbThread];
		th = new Thread[nbThread];
		this.nbThread = nbThread;
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
		lblResult = new JLabel("0 ms");
		for(int i = 0; i < nbThread; i++)
			{
			progressBar[i] = new JProgressBar();
			}

			setLayout(null);

		// JComponent : add
		add(btnRun);
		for(int i = 0; i < nbThread; i++)
			{
			add(progressBar[i]);
			}
		add(lblResult);
		}

	private void control()
		{
		for(int i = 0; i < nbThread; i++)
			{
			progressBar[i].setValue(0);
			progressBar[i].setMaximum(100);
			progressBar[i].setStringPainted(true);
			}

		btnRun.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Auto-generated method stub
				calcul();
				}
			});
		}

	private void appearance()
		{
		int width = 180 / nbThread - ((nbThread-1) * 10) / nbThread;
		Dimension size = new Dimension(width, 20);
		for(int i = 0; i < nbThread; i++)
			{
			progressBar[i].setSize(size);
			progressBar[i].setPreferredSize(size);
			progressBar[i].setMaximumSize(size);
			progressBar[i].setMinimumSize(size);
			progressBar[i].setLocation( i *width + (i+1) * 10, 40);
			}

			size = new Dimension(180, 20);
			lblResult.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			lblResult.setText(nbThread + " thread(s): ");
			lblResult.setSize(size);
			lblResult.setPreferredSize(size);
			lblResult.setMinimumSize(size);
			lblResult.setLocation(10,  10);

			btnRun.setSize(size);
			btnRun.setPreferredSize(size);
			btnRun.setMinimumSize(size);
			btnRun.setLocation(10,  70);

		}

	private Runnable calculThread(JProgressBar bar, int b1, int b2, int ratio)
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				int cpt = 1;
				for(int i = b1; i < b2; i++)
					{
					bar.setValue(cpt++ * ratio);
					try
						{
						Thread.sleep(100);
						}
					catch (InterruptedException e)
						{
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
				}
			};
		}

	public void calcul()
		{
		new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				int nbCases = N / nbThread;
				int ratio = 100 / nbCases;
				long time = System.currentTimeMillis();
				try
					{
					for(int i = 0; i < nbThread; i++)
						{
						progressBar[i].setValue(0);
						th[i] = new Thread(calculThread(progressBar[i], i * nbCases, (i + 1) * nbCases, ratio));
						th[i].start();
						}
					for(int i = 0; i < nbThread; i++)
						{
						th[i].join();
						}
					}
				catch (InterruptedException e)
					{
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				time = System.currentTimeMillis() - time;
				lblResult.setText(nbThread + " thread(s): " + time + "ms");
				}
			}).start();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton btnRun;
	private JProgressBar[] progressBar;
	private JLabel lblResult;
	private int nbThread;
	private final int N = 10;
	private Thread[] th;
	}
