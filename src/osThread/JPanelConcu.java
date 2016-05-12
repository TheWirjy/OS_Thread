
package osThread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPanelConcu extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelConcu()
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
		Dimension dim = new Dimension(200, 350);
		textArea1 = new JTextArea("AVEC MUTEX");
		textArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textArea1.setEditable(false);
		textArea1.setPreferredSize(dim);
		textArea1.setSize(dim);
		textArea1.setMinimumSize(dim);
		textArea1.setLocation(10, 10);

		dim = new Dimension(200, 20);
		btnRun.setSize(dim);
		btnRun.setPreferredSize(dim);
		btnRun.setMinimumSize(dim);
		btnRun.setLocation(10, 370);
		setLayout(null);

		add(textArea1);
		add(btnRun);
		}

	private void control()
		{
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
		textArea1.setText("AVEC MUTEX");
		th1 = new Thread(runConcu("Thread1"));
		th2 = new Thread(runConcu("Thread2"));
		th1.start();
		th2.start();
		try
			{
			th1.join();
			th2.join();
			}
		catch (InterruptedException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	private Runnable runConcu(String name)
		{
		return new Runnable()
			{
			@Override
			public void run()
				{
				for(int i = 0; i < 10; i++)
					{
					_mutex.lock();
					textArea1.append("\n somme :" + somme + " par : " + name);
					somme += 1;
					System.out.println("somme :" + somme + " par : " + name);
					_mutex.unlock();
					}
				}
			};

		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Thread th1, th2;
	private JButton btnRun;
	private int somme = 0;
	private JTextArea textArea1;
	private final Lock _mutex = new ReentrantLock(true);
	}
