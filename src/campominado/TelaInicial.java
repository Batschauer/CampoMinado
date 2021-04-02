package campominado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaInicial implements ActionListener {

	JFrame frame;
	JMenuBar barra;
	JMenu inicio;
	JMenuItem novoJogo, facil, medio, dificil, historico, sobre, sair;  
	TelaSobre telaSobre;
	TelaHistorico telaHistorico;
	
	public TelaInicial () {
		
		frame = new JFrame("Campo Minado");
		frame.setVisible(true);
		frame.setSize(720, 310);
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == facil) {
			//implementar Novo Jogo Fácil
		} else if (e.getSource() == medio) {
			//implementar Novo Jogo Médio
		} else if (e.getSource() == dificil) {
			//implementar Novo Jogo Difícil
		} else if (e.getSource() == historico) {
			telaHistorico.setVisible(true);
		} else if (e.getSource() == sobre) {
			telaSobre.setVisible(true);
		} else if (e.getSource() == sair) {
			System.exit(0);
		}
		
	}
	
}
