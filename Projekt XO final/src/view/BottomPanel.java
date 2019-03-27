package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * BottomPanel je dio MainFramea koji sadrzi objekte za odabir dva igraca (JList)
 * i pocetak igre (JButton).
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class BottomPanel extends JPanel{
	
	private JList list;
	private JLabel playerOne;
	private JLabel playerTwo;
	private JTextField plyOneField;
	private JTextField plyTwoField;
	private JButton startGame;
	private static int cnt = 0;
	private int textFieldCnt = 1;
	private DefaultListModel listModel;
	private GameEventListener gmeListener;
	
	
	public BottomPanel() {
		// TODO Auto-generated constructor stub
		
//		Dimension dim = getPreferredSize();
		setPreferredSize(new Dimension(750, 280));
		
		createComponents();
		setBorders();
		bottomLayout();
		activateComponents();
		
	}
	
	
	/**
	 * Metoda inicijalizira objekte i postavlja ih u okvir 
	 * 
	 */
	private void createComponents() {
		
		list = new JList<>();
		listModel = new DefaultListModel();
		list.setModel(listModel);
		list.setBorder(BorderFactory.createEtchedBorder());
		list.setVisibleRowCount(6);
		
		playerOne = new JLabel("Player one: (X)");
		playerTwo = new JLabel("Player two: (O)");
		plyOneField = new JTextField(15);
		plyTwoField = new JTextField(15);
		plyOneField.setText("");
		plyTwoField.setText("");
		
		startGame = new JButton("Nova Igra");
		startGame.setEnabled(false);
		
	}
	
	/**
	 * Metoda za postavljanje okvira s naslovom
	 */
	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Chose a player:");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}
	
	
	/**
	 * Metoda rasporeduje elemente u BottomPanel-u
	 * 
	 */
	private void bottomLayout() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 0.25;


		gbc.gridy = 0;
		gbc.gridwidth = 2;	
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), gbc);
		
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.CENTER;
		
		gbc.gridx = 0;
		gbc.gridy = 1;

		gbc.anchor = GridBagConstraints.CENTER;
		add(playerOne, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		add(plyOneField, gbc);

		
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		add(playerTwo, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		add(plyTwoField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;	
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.PAGE_START;
		add(startGame, gbc);
	}
	
	
	/**
	 * Metoda postavlja ActionListener-e i na JButton i na JListu
	 * JList odabire dvoje igraca
	 * JButton pokrece igru 
	 */
	public void activateComponents() {
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getValueIsAdjusting()) {
					
					if(textFieldCnt == 1) {
						
						plyOneField.setText(list.getSelectedValue().toString());
						textFieldCnt = 2;
					} else if (textFieldCnt == 2){
						plyTwoField.setText(list.getSelectedValue().toString());
						textFieldCnt = 1;
					}
					
					checkGameStart();
					
				}
				
			}
		});
		
		
		startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//System.out.println(plyOneField.getText());
				//System.out.println(plyTwoField.getText());
				String plyOneName = plyOneField.getText();
				String plyTwoName = plyTwoField.getText();
				
				GameEvent gme = new GameEvent(this);
				
				gme.setPlyOneName(plyOneName);
				gme.setPlyTwoName(plyTwoName);
				
				if(gmeListener != null) {
					
					gmeListener.gameEventOccured(gme);
				}
				
			}
		});
	}
	
	
	public void setGameEventListener(GameEventListener gmeList) {
		this.gmeListener = gmeList;
	}


	public JTextField getPlyOneField() {
		return plyOneField;
	}


	public void setPlyOneField(JTextField plyOneField) {
		this.plyOneField = plyOneField;
	}


	public JTextField getPlyTwoField() {
		return plyTwoField;
	}


	public void setPlyTwoField(JTextField plyTwoField) {
		this.plyTwoField = plyTwoField;
	}
	
	
	/**
	 * Metoda za dodavanje igraca na listu
	 * @param playerName ime igraca
	 */
	public void fillPlayerList(String playerName) {
		
		listModel.add(cnt, playerName);
		cnt++;
		
	}
	
	/**
	 * 
	 * Metoda aktivira JButton Nova igra ako
	 * plyOneField i plyTwoField nisu prazni Stringovi
	 */
	
	public void checkGameStart() {
		
		if (plyTwoField.getText().isEmpty()) {
			startGame.setEnabled(false);
		} else {
			startGame.setEnabled(true);
		}
	}
	
	
}
