package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * NewPlayerFrame je JDialog sa kojim korisnik unosi ime svakog novog igraca. 
 * To ime se sprema u klasi NewPlayerEvent  
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 */

public class NewPlayerFrame extends JDialog{
	
	private JLabel labelPlyName;
	private JTextField fieldPlyName;
	private JButton plyRegister;
	
	private NewPlayerListener npl;
	
	
	/**
	 * Konstruktor odreduje velicinu prozora i postavlja sve
	 * elemente 
	 */
	public NewPlayerFrame(JFrame parent) {
		// TODO Auto-generated constructor stub
		super(parent, "Unesite ime novog igraca", false);
		
		setLayout(new GridBagLayout());
		createComponents();
		layoutComp();
		activateFrame();
		
		setVisible(true);
		setSize(265,145);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	
	/**
	 * Metoda inicijalizira objekte u NewPlayerFrame-u
	 * 
	 */
	private void createComponents() {
		
		
		labelPlyName = new JLabel("Name: ");
		fieldPlyName = new JTextField(10);
		plyRegister = new JButton("Register player");
			
	}
	
	/**
	 * Metoda rasporeduje elemente u NewPlayerFrame-u
	 * 
	 */
	
	private void layoutComp() {

		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();

		g.weightx = 1;
		g.weighty = 0.25;

		g.gridx = 0;
		g.gridy = 0;
		g.anchor = GridBagConstraints.LINE_END;
		add(labelPlyName, g);

		g.gridx = 2;
		g.gridy = 0;
		g.anchor = GridBagConstraints.LINE_START;
		add(fieldPlyName, g);

		g.gridx = 2;
		g.gridy = 2;
		g.anchor = GridBagConstraints.LINE_START;
		add(plyRegister, g);

	}
	
	/**
	 * Metoda postavlja ActionListener na JButton u NewPlayerFrame-u
	 * i dodjeljuje mu funkcionalnost prosljedivanja imena u NewPlayerEvent-u
	 */
	
	private void activateFrame() {
		
		plyRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String plyname = fieldPlyName.getText();
				
				if(plyname.isEmpty() == false) {
					
					NewPlayerEvent npe = new NewPlayerEvent(this);
					npe.setName(plyname);
					
					if(npl != null) {
						
						npl.newPlayerEventOcured(npe);
					}
				}
				
				
				setVisible(false);

			}
		});
	}
	
	public void setNewPlayerListener(NewPlayerListener npl) {
		
		this.npl = npl;
	}


	
}
