package it.guidofonzo.hotmail.scenari;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.guidofonzo.hotmail.classi.CorriereEspresso;

public class CorriereEspressoGraphic extends JFrame{

	private static final int TWIDTH=10;
	
	public CorriereEspressoGraphic(CorriereEspresso c) {
		textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		
		JTextField nomeT=new JTextField(TWIDTH);
		JLabel nomeL = new JLabel("inserisci nome");
		JButton button = new JButton("Cerca Per nome ");
		
		textPanel.add(nomeL);
		textPanel.add(nomeT);
		textPanel.add(button);
		
		
	
		JTextField cognomeT =new JTextField(TWIDTH);
		JLabel cognomeL = new JLabel("inserisci cognome ");
		JButton button1 = new JButton("Cerca per Cognome ");
		
		textPanel.add(cognomeL);
		textPanel.add(cognomeT);
		textPanel.add(button1);
		
		
		JTextArea area = new JTextArea(30,50);
		
		class clickListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = nomeT.getText();
				CorriereEspresso c1 = c.filterByNome(nome);
				if(c1!=null) { 
					area.setText(c1.toString());
				}
			    String cognome=cognomeT.getText();
			    CorriereEspresso c2 =c.filterByCogNome(cognome);
			    
			    if(c2!=null) {
			    	area.setText(c2.toString());
			    
				}
				
			}
				
		}
		button.addActionListener(new clickListener());
		button1.addActionListener(new clickListener());
		this.setLayout(new BorderLayout());
		this.add(textPanel, BorderLayout.CENTER);
		this.add(area, BorderLayout.AFTER_LAST_LINE);
		
		
	}
	
	
	
	
	
	
	private JPanel textPanel;
	private CorriereEspresso c;
	
}

