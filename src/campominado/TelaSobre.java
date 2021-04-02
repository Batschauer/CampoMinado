package campominado;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaSobre extends JFrame implements ActionListener {

	JLabel titulo, imagem, descricao;
	ImageIcon icon;
	JButton buttonFechar;
	JPanel panel;
	
	public TelaSobre() {
		setTitle("Sobre");
		setSize(600, 360);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel(new GridLayout(10,1));
		
		icon = new ImageIcon("img/sobre.png");		
		panel.add(titulo = new JLabel("Campo Minado"));
		panel.add(imagem = new JLabel(icon));
		
		panel.add(new JLabel("A área de jogo consiste num campo de quadrados retangular."));
		panel.add(new JLabel("Cada quadrado pode ser revelado clicando sobre ele, se o quadrado clicado contiver uma mina, então o jogo acaba."));
		panel.add(new JLabel("Se, por outro lado, o quadrado não contiver uma mina, uma de duas coisas poderá acontecer:"));
		
		panel.add(new JLabel("1. Um número aparece, indicando a quantidade de quadrados adjacentes que contêm minas;"));
		panel.add(new JLabel("2. Nenhum número aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio já que não podem conter minas;"));
		panel.add(new JLabel("O jogo é ganho quando todos os os quadrados que não têm minas são revelados."));
		
		buttonFechar = new JButton("Fechar");
		buttonFechar.addActionListener(this);
		
		add(panel, BorderLayout.CENTER);
		add(buttonFechar, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}	
}
