package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalButtonUI;


/**
 * ButtonsPanel postavlja polja (JButtone) igre krizic kruzic
 * i doreduje njihovu funkcionalnost 
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class ButtonsPanel extends JPanel implements ActionListener{
	
	private JPanel okvir;

	
	private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private Font buttonFont;
    private int cnt = 1;
    private int drawCnt = 0;
    private String winner;
    
    private String plyOne;
    private String plyTwo;
    
    private ButtonsEventListener bueListener;
 

    
    
   
	
	public ButtonsPanel() {
    	
		createComponents();
		setFont();
		activateButtons();
		disableGame();
		

    }
	
	/**
	 * Metoda inicijalizira objekte i postavlja ih u okvir 
	 * 
	 */
    public void createComponents () {
    	
    	okvir = new JPanel(new GridLayout(3, 3));

    	button1 = new JButton();
    	button2 = new JButton();
    	button3 = new JButton();
    	button4 = new JButton();
    	button5 = new JButton();
    	button6 = new JButton();
    	button7 = new JButton();
    	button8 = new JButton();
		button9 = new JButton();
		
		okvir.add(button1);
		okvir.add(button2);
		okvir.add(button3);
		okvir.add(button4);
		okvir.add(button5);
		okvir.add(button6);
		okvir.add(button7);
		okvir.add(button8);
		okvir.add(button9);
		
		okvir.setPreferredSize(new Dimension(490, 490));
		
		add(okvir, BorderLayout.CENTER);

    }
    /**
     * Metoda postavlja velicinu Fonta za X i O
     */
    
    public void setFont() {
    	
    	buttonFont = new Font("Helvetica Neue", Font.PLAIN,120);
    	
    	button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);
    }
    
    
    /**
     * Metoda dodaje ActionListener-e na sve JButtone
     */
    public void activateButtons() {
    	
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);

    	
    }
    
    /**
     * Metoda postavlja text x ili o na JButtone
     * Nakon aktiviranja svakog JButton-a provjerava za pobjedu ili 
     * nerijeseni rezultat
     */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton buttonClicked = (JButton) e.getSource();
		
		if (cnt == 1) {
			
			buttonClicked.setText("X");
			cnt = 2;
			buttonClicked.setEnabled(false);
			drawCnt++;
			checkDraw();
			
			
			if (checkForWin() == true) {
				
				cnt = 2;
				winEngine();
				
				
			}
			
		} else if (cnt == 2){
			buttonClicked.setText("O");
			cnt = 1;
			buttonClicked.setEnabled(false);
			drawCnt++;
			checkDraw();

			
			if (checkForWin() == true) {
				
				cnt = 1;
				winEngine();
				
			
			}
		}
		
		
	}
	
	/**
	 * 
	 * @return vraca true ako nalde pobjednika
	 */
	
	public boolean checkForWin() {
		
		String prazno = "";
		
		if (button1.getText() ==  button2.getText() && button2.getText() == button3.getText() && button3.getText() != prazno) {
			
			winner = button3.getText();
			return true;
			
		} else if (button4.getText() ==  button5.getText() && button5.getText() == button6.getText() && button6.getText() != prazno) {
			winner = button6.getText();
			return true;
			
		} else if (button7.getText() ==  button8.getText() && button8.getText() == button9.getText() && button9.getText() != prazno) {
			
			winner = button9.getText();
			return true;
			
		} else if (button1.getText() ==  button4.getText() && button4.getText() == button7.getText() && button7.getText() != prazno) {
			
			winner = button7.getText();
			return true;
		} else if (button2.getText() ==  button5.getText() && button5.getText() == button8.getText() && button8.getText() != prazno) {
			
			winner = button8.getText();
			return true;
		} else if (button3.getText() ==  button6.getText() && button6.getText() == button9.getText() && button9.getText() != prazno) {
			
			winner = button9.getText();
			return true;
		} else if (button1.getText() ==  button5.getText() && button5.getText() == button9.getText() && button9.getText() != prazno) {
			
			winner = button9.getText();
			return true;
			

		} else if (button3.getText() ==  button5.getText() && button5.getText() == button7.getText() && button7.getText() != prazno) {
			
			winner = button7.getText();
			return true;
		
		} else {
			
			return false;
		}
		
	}
	
	/**
	 * Postavlja sve JButtone na prazan text i dopusta
	 * njhovo klikanje
	 */
	
	public void resetButtons() {
		
		button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        
        enableGame();
        
       
	}
	
	/**
	 * Postavlja mogucnost klikanja svih JButtona
	 */
	public void enableGame() {
		
		button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        
	}
	/**
	 * Oduzima mogucnost klikanja svih JButtona
	 */
	public void disableGame() {
		
		button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
	}
	/**
	 * Provjerava da li je igra nerijesena
	 */
	public void checkDraw() {
		
		if(drawCnt == 9) {
			
			resetButtons();
			drawCnt = 0;
			setWinner();
			cnt = 1;
			JOptionPane.showConfirmDialog(null,"Igrali ste neriješeno. Pretisnite Nova Igra da biste nastavili igru. \n" + plyOne + " igra prvi","Info", JOptionPane.DEFAULT_OPTION);
			disableGame();
		}
		
	}
	/**
	 * Postavlja pobjednika igre
	 */
	public void setWinner() {
		
		if (winner == "X") {
			
			winner = plyOne;
		} else if (winner == "O") {
			
			winner = plyTwo;
		} 
		
	}
	/**
	 * Ispisuje korisniku tko je pobjednik i prosljeduje
	 * ime pobjednika ButtonsEvent-u
	 * 
	 */
	public void winEngine() {
		
		resetButtons();
		drawCnt = 0;
		setWinner();
		
		String gubitnik = "";
		
		if (winner == plyOne) {
			gubitnik = plyTwo;
		} else {
			gubitnik = plyOne;
		}
		
		JOptionPane.showConfirmDialog(null,"Pobjednik je " + winner +  " .Pretisnite Nova Igra da biste nastavili sa igrom.\n" + gubitnik + " igra prvi/a." ,"Winner", JOptionPane.DEFAULT_OPTION);
		
		ButtonsEvent buttonsEvent = new ButtonsEvent(this);
		
		buttonsEvent.setWinnerName(winner);
		
		if (bueListener != null) {
			
			bueListener.buttonsEventOcured(buttonsEvent);
		}
		
		disableGame();


		
	}
	
	public void setButtonsEventListener(ButtonsEventListener btl) {
		
		this.bueListener = btl;
		
	}
	
	
	public void setPlyOne(String plyOne) {
		
		this.plyOne = plyOne;
		
	}



	public void setPlyTwo(String plyTwo) {
		
		this.plyTwo = plyTwo;
		
	}


}
