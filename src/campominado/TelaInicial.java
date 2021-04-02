package campominado;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaInicial implements ActionListener {

	JFrame frame;
	JMenuBar barra;
	JMenu inicio;
	JMenuItem novoJogo, facil, medio, dificil, historico, sobre, sair;  
	TelaSobre telaSobre;
	TelaHistorico telaHistorico;
	JPanel panelFacil, panelMedio, panelDificil;
	JButton button;
	
	public TelaInicial () {
		
		frame = new JFrame("Campo Minado");
		frame.setVisible(true);
		frame.setSize(620, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		barra = new JMenuBar();
		inicio = new JMenu("Início");
		
		novoJogo = new JMenu("Novo Jogo");
		inicio.add(novoJogo);
		
		facil = new JMenuItem("Fácil");
		facil.addActionListener(this);
		novoJogo.add(facil);
		
		medio = new JMenuItem("Médio");
		medio.addActionListener(this);
		novoJogo.add(medio);
		
		dificil = new JMenuItem("Difícil");
		dificil.addActionListener(this);
		novoJogo.add(dificil);
		
		historico = new JMenuItem("Historico");
		inicio.add(historico);
		
		sobre = new JMenuItem("Sobre");
		inicio.add(sobre);
		
		sair = new JMenuItem("Sair");
		inicio.add(sair);

		historico.addActionListener(this);
		sobre.addActionListener(this);
		sair.addActionListener(this);
		
		barra.add(inicio);
		frame.setJMenuBar(barra);
		
		telaSobre = new TelaSobre();
		telaHistorico = new TelaHistorico();
		
		panelFacil = new JPanel(new GridLayout (8, 10));
		panelMedio = new JPanel(new GridLayout (12, 14));
		panelDificil = new JPanel(new GridLayout (16, 18));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		frame.getContentPane().removeAll();
		frame.repaint();
		panelFacil.removeAll();
		panelMedio.removeAll();
		panelDificil.removeAll();
		
		if (e.getSource() == facil) {
			frame.setSize(400, 400);
			for (int i=1; i<=80; i++) {
				button = new JButton(i + "");
				panelFacil.add(button);
			}
			frame.add(panelFacil);

		} else if (e.getSource() == medio) {
			frame.setSize(600, 600);
			for (int i=1; i<=168; i++) {
				button = new JButton(i + "");
				panelMedio.add(button);
			}
			frame.add(panelMedio);

		} else if (e.getSource() == dificil) {
			frame.setSize(850, 850);
			for (int i=1; i<=288; i++) {
				button = new JButton(i + "");
				panelDificil.add(button);
			}
			frame.add(panelDificil);

		} else if (e.getSource() == historico) {
			telaHistorico.setVisible(true);
		} else if (e.getSource() == sobre) {
			telaSobre.setVisible(true);
		} else if (e.getSource() == sair) {
			System.exit(0);
		}
		
	}
	
}
