package campominado;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
	ArrayList<JButton> buttons;
	
	private ControleJogo jogo = null;
	
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
		
		buttons = new ArrayList<JButton>();
		
	}
	
	public void gerarBotoes(int dificuldade, ControleJogo jogo)
	{
		int nBotoes = 0;
		
		switch (dificuldade) {
		
		case ControleJogo.FACIL: nBotoes = ControleJogo.QTD_CAMPOS_FACIL; break;

		case ControleJogo.MEDIO: nBotoes = ControleJogo.QTD_CAMPOS_MEDIO; break;
			
		case ControleJogo.DIFICIL: nBotoes = ControleJogo.QTD_CAMPOS_DIFICIL; break;
		}
		
		JButton btn = null;
		
		for (int idx = 1; idx <= nBotoes; idx++) {
			
			btn = new JButton();
			btn.addActionListener(jogo);
			btn.setActionCommand(idx + "");
			
			buttons.add(btn);
			
			switch (dificuldade) {
			
			case ControleJogo.FACIL: panelFacil.add(btn); break;
			case ControleJogo.MEDIO: panelMedio.add(btn); break;
			case ControleJogo.DIFICIL: panelDificil.add(btn); break;
			
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		frame.getContentPane().removeAll();
		frame.repaint();
		panelFacil.removeAll();
		panelMedio.removeAll();
		panelDificil.removeAll();
		buttons.clear();
		
		frame.setSize(0,0);
		
		if (e.getSource() == facil) {
			
			frame.setSize(600, 600);
			
			jogo = new ControleJogo(this, ControleJogo.FACIL);
			
			gerarBotoes(ControleJogo.FACIL, jogo);
			
			frame.add(panelFacil);
			
			jogo.preencherCampo();

		} else if (e.getSource() == medio) {
			
			frame.setSize(800, 800);
			
			jogo = new ControleJogo(this, ControleJogo.MEDIO);
			
			gerarBotoes(ControleJogo.MEDIO, jogo);
			
			frame.add(panelMedio);
			
			jogo.preencherCampo();

		} else if (e.getSource() == dificil) {
			
			frame.setSize(1000, 1000);
			
			jogo = new ControleJogo(this, ControleJogo.DIFICIL);
			
			gerarBotoes(ControleJogo.DIFICIL, jogo);
			
			frame.add(panelDificil);
			
			jogo.preencherCampo();

		} else if (e.getSource() == historico) {
			telaHistorico.setVisible(true);
		} else if (e.getSource() == sobre) {
			telaSobre.setVisible(true);
		} else if (e.getSource() == sair) {
			System.exit(0);
		}
		
	}
	
}
