
package osThread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.LEFT);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

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
		int width = 200 / nbThread;
		Dimension size = new Dimension(width, 30);
		for(int i = 0; i < nbThread; i++)
			{
			progressBar[i].setSize(size);
			progressBar[i].setPreferredSize(size);
			progressBar[i].setMaximumSize(size);
			progressBar[i].setMinimumSize(size);
			}
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
				lblResult.setText(time + "ms");
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
