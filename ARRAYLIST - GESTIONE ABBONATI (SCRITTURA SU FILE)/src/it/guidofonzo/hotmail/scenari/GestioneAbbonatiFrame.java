package it.guidofonzo.hotmail.scenari;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.guidofonzo.hotmail.classi.GestoreAbbonati;

public class GestioneAbbonatiFrame extends JFrame {

	public GestioneAbbonatiFrame(GestoreAbbonati ge) {
		
		textpanel = new JPanel();
		textpanel.setLayout(new FlowLayout());
		textpanel.setBackground(Color.blue);
		
		


		JLabel nomeL= new JLabel("inseire nome");
		JTextField nomeT = new JTextField(10);
		JButton buttonNome = new JButton("FILTRA PER NOME");

		textpanel.add(nomeL);
		textpanel.add(nomeT);
		textpanel.add(buttonNome);
		
		
		JLabel cognomeL= new JLabel("inseire Cognome");
		JTextField cognomeT = new JTextField(10);
		JButton buttoncognome = new JButton("FILTRA PER COGNOME");

		textpanel.add(cognomeL);
		textpanel.add(cognomeT);
		textpanel.add(buttoncognome);
		
		JLabel ResidenzaL= new JLabel("inseire Residenza");
		JTextField residenzaT = new JTextField(10);
		JButton buttonresidenza = new JButton("FILTRA PER RESIDENZA");

		textpanel.add(ResidenzaL);
		textpanel.add(residenzaT);
		textpanel.add(buttonresidenza);
		
		JLabel sessoL= new JLabel("inseire sesso");
		JTextField sessoT = new JTextField(10);
		JButton buttonsesso = new JButton("FILTRA PER SESSO");

		textpanel.add(sessoL);
		textpanel.add(sessoT);
		textpanel.add(buttonsesso);
		
		JTextArea textArea = new JTextArea(30,50);
	              
		
		class clicklistner implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = nomeT.getText();

				GestoreAbbonati g1 = ge.filterByNome(nome);
				
				if(g1!=null) {
					textArea.setText(g1.toString());
					
				}
				
			}
		}
		
		class clicklistnerCognome implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String cognome= cognomeT.getText();

				GestoreAbbonati g2 = ge.filterBycognome(cognome);
				
				if(g2!=null) {
					textArea.setText(g2.toString());
				}
				
			}
		}
		
		
		class clicklistnerResidenza implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String residenza= residenzaT.getText();

				GestoreAbbonati g3 = ge.filterBycognome(residenza);
				
				if(g3!=null) {
					textArea.setText(g3.toString());
				}
				
			}
		}
		class clicklistnerSesso implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String sesso= sessoT.getText();

				GestoreAbbonati g4 = ge.filterBySesso(sesso);
				
				if(g4!=null) {
					textArea.setText(g4.toString());
				}
				
			}
		}
		
		
		
		buttonNome.addActionListener(new clicklistner());
		buttoncognome.addActionListener(new clicklistnerCognome());
		buttonresidenza.addActionListener(new clicklistnerResidenza());
		buttonsesso.addActionListener(new clicklistnerSesso());


		
		this.setLayout(new BorderLayout());
		this.add(textpanel,BorderLayout.CENTER);
		this.add(textArea,BorderLayout.AFTER_LAST_LINE);
		
	}
	private JPanel textpanel;
	private GestoreAbbonati g;
}
