package view;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper.Range;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;
import model.Player;


/**
 * ScoreBoard prikazuje sortiranu rang listu Playera po broju pobjeda
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class ScoreBoard  extends JDialog implements ActionListener{
	
	private JTextArea rangLista;
	private JButton osvjezi;
	private Controller cnt;
	

	/**
	 * Konstruktor postavlja velicinu okvira, LayoutManagera
	 * i aktivira sve komponente
	 */
	public ScoreBoard(JFrame parent) {
		// TODO Auto-generated constructor stub
		
		super(parent, "Rang Lista", false);
		setLayout(new BorderLayout());
		setVisible(true);
		setLocation(150,250);
		setSize(400, 400);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		//setLocationRelativeTo(null);
		
		createComponents();
		layoutComp();
		activateComp();
		
		
	}
	/**
	 * Inicijalizira komponente
	 */
	public void createComponents() {
		
		rangLista = new JTextArea();
		rangLista.setTabSize(25);
		osvjezi = new JButton("Refresh");
	}
	
	/**
	 * odreduje lokaciju svh komponenti 
	 */
	public void layoutComp() {
		
		add(new JScrollPane(rangLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		
		add(osvjezi, BorderLayout.SOUTH);
	}
	
	/**
	 * metoda za punjenje JTextArea sa tekstom iz liste tipa Player
	 * @param plyList lista tipa Player
	 * @param jtf JTextArea
	 */
	public void fillScoreBoard(Player[] plyList) {
		
		int cnt = 1;
		
		for (Player player : plyList) {
			rangLista.append(cnt +". Igrac: " +player.getName() + "\tBroj pobjeda: " + player.getNumOfWins() + "\n");
			cnt++;
		}
	}
	
	
	/**
	 * 
	 * Metoda sortira listu svih igraca prema broju pobjeda 
	 * @param arp lista svih igraca
	 * @return sortirana lista
	 */
	
	public Player[] sortDatabaseArray(ArrayList<Player> arp) {
		
		Player[] array = arp.toArray(new Player[arp.size()]);
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 1; j < array.length; j++) {
				
				if(array[i].getNumOfWins() < array[j].getNumOfWins()) {
					
					Player a = array[j];
					array[j] = array[i];
					array[i] = a;

				}
			}
		}
		
		return array;
	}
	
	public void activateComp() {
		
		osvjezi.addActionListener(this);
	}
	
	/**
	 * Daje funkcionalnost
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == osvjezi) {
			
			clearAllText(rangLista);
			
			Player[] players = sortDatabaseArray(cnt.getDatabase());
			fillScoreBoard(players);
			
		}
		
	}
	/**
	 * Briše sav tekst sa JTextArea
	 * @param jTextArea
	 */
	public void clearAllText(JTextArea jTextArea) {
		
			jTextArea.setText("");
	}
	
	
	public void setControler(Controller cnt) {
		this.cnt = cnt;
	}
	
	
	
	

}
