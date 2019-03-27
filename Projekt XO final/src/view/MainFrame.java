package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import model.Player;

/**
 * MainFrame pozicionira sve klase u glavnom prozoru.
 * Preko MainFramea se odvija komunikacija izmedu ostalih klasa
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */


public class MainFrame extends JFrame{
	
	private ButtonsPanel btPanel;
	private MenuBar menuBar;
	private BottomPanel bottomPanel;
	private Controller controller;
	
	
	
	/**
	 * Konstruktor odreduje velicinu prozora i postavlja sve
	 * elemente 
	 */
	public MainFrame() {
		
		super("Križić kružić game");
		
		setLayout(new BorderLayout());

		setSize(750, 850);
		setLocationRelativeTo(null);
		setVisible(true); 
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createComponents();
		activateComponents();
		add(btPanel, BorderLayout.CENTER);
		add(menuBar, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		
	}
	
	/**
	 * Metoda inicijalizira sve objekte koji se nalaze u glavnom prozoru
	 */
	public void createComponents() {
		
		btPanel = new ButtonsPanel();
		menuBar = new MenuBar();
		bottomPanel = new BottomPanel();
		controller = new Controller();
		
		menuBar.setMainFrame(MainFrame.this);
		
		menuBar.setControler(controller);
		
		
	
	}
	
	/**
	 * Metoda postavlja slusace na objekte MainFrame-a
	 * i dodjeljuje im funkcionalnost komuniciranja sa bazom podataka
	 */
	
	public void activateComponents() {
		
		menuBar.setMenuBarListener(new NewPlayerListener() {
			
			@Override
			public void newPlayerEventOcured(NewPlayerEvent npe) {
				// TODO Auto-generated method stub
				
				controller.addPlayer(npe);
				ArrayList<Player> plyDatabaseList= controller.getDatabase();
				
//				for (Player player : plyDatabaseList) {
//					System.out.println(player.getName() + " id: " + player.getId());
//				}
				
				//System.out.println(plyDatabaseList.get(controller.databaseSize()-1).getName());
				bottomPanel.fillPlayerList(plyDatabaseList.get(controller.databaseSize()-1).getName());
			}
		});
			
			
		bottomPanel.setGameEventListener(new GameEventListener() {
			
			@Override
			public void gameEventOccured(GameEvent gme) {
				// TODO Auto-generated method stub
				
				
				btPanel.setPlyOne(gme.getPlyOneName());
				btPanel.setPlyTwo(gme.getPlyTwoName());
				btPanel.enableGame();
		
//				
			}
		});
		
		
		btPanel.setButtonsEventListener(new ButtonsEventListener() {
			
			@Override
			public void buttonsEventOcured(ButtonsEvent bue) {
				// TODO Auto-generated method stub
				
				ArrayList<Player> plyDataList = controller.getDatabase();
				int addwin = 1;
				
				for (Player player : plyDataList) {
					
					
					
					if (player.getName().equals(bue.getWinnerName())) {
						
						player.setNumOfWins(addwin);
						
						
					}
	
				}
				
			}
		});
		
		
		
	}
}
