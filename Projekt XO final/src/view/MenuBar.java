package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import model.Player;

/**
 * MenuBar je dio MainFramea koji sadrzi JButtone i odreduje im finkcionalnost
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */


public class MenuBar extends JPanel{
	
	private JPanel menuOkvir;
	
	private JButton rangLista;
	private JButton newPlayer;
	
	private MainFrame main;
	private NewPlayerListener npe;
	private NewPlayerFrame newPlayerFrame;
	private ScoreBoard rangOkvir;
	
	private Controller controller;
	
	
	
	public MenuBar() {
		
		createComponents();
		activateComponents();
		
	}
	
	/**
	 * Metoda inicijalizira JButtone i postavlja ih u okvir 
	 * 
	 */
	public void createComponents() {
		
		menuOkvir = new JPanel(new FlowLayout());
		
		rangLista = new JButton("Rang Lista");
		newPlayer = new JButton("Novi Igrac");
		
		
		menuOkvir.add(rangLista);
		menuOkvir.add(newPlayer);
		
		menuOkvir.setPreferredSize(new Dimension(850, 30));
		add(menuOkvir, BorderLayout.NORTH);
	}
	
	/**
	 * Metoda postavlja ActionListener-e i na JButtone 
	 * JButton Novi igrac inicijalizira novi okvir za unos novog igraca.
	 * JButton Rang Lista prikazuje sortiranu listu igraca po broju pobjeda
	 */
	
	public void activateComponents() {
		
		newPlayer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				newPlayerFrame =  new NewPlayerFrame(main);
				
				newPlayerFrame.setNewPlayerListener(npe);
				
			}
		});
		
		
		rangLista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Player> plyDatabaseList = controller.getDatabase();
				//Player[] sortDatabase = sortDatabaseArray(plyDatabaseList);
				
				// inicijaliziram Okvir Rang liste
				rangOkvir  = new ScoreBoard(main);
				
				rangOkvir.setControler(controller);
				
				//sortiram listu iz baze podataka
				Player[] ply = rangOkvir.sortDatabaseArray(plyDatabaseList);
				// punim JTextArea sa Playerima
				rangOkvir.fillScoreBoard(ply);
				

//				
//				String rangLista = "";
//				
//				
//				for (Player player : sortDatabase) {
//					rangLista  = rangLista + "Igrac: " +player.getName() + "          Broj pobjeda: " + player.getNumOfWins() + "\n";
//				}		
//				
//				if(rangLista.length() != 0) {
//					
//					JOptionPane.showConfirmDialog(null, rangLista, "Rang Lista", JOptionPane.PLAIN_MESSAGE);
//					
//				} else {
//					
//					JOptionPane.showConfirmDialog(null, "Ne postoji registriran igrac.\nRegitrirajte igraca pritiskom na gumb Novi igrac! ", "Info", JOptionPane.PLAIN_MESSAGE);
//				}
			}
		});
		
			
		
	}
	
	
	
	public void setMainFrame(MainFrame mf) {
		
		this.main= mf;
	}
	
	public void setMenuBarListener(NewPlayerListener npe) {
		
		this.npe = npe;
		
	}
	
	public void setControler(Controller cnt) {
		
		this.controller = cnt;
	}

	
	
	


		
}
