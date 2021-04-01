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

	JLabel titulo, imagem, txt1, txt2, txt3, txt4, txt5, txt6;
	ImageIcon icon;
	JButton buttonFechar;
	JPanel panel, teste;
	
	public TelaSobre() {
		setTitle("Sobre");
		setSize(600, 360);
		
		panel = new JPanel(new GridLayout(1,10));
		
		icon = new ImageIcon("img/sobre.jpg");
		
		titulo = new JLabel("Campo Minado");		
		imagem = new JLabel(icon);
		
		//arrumar a descri��o pq assim ta dando ruim
		
		txt1 = new JLabel("A �rea de jogo consiste num campo de quadrados retangular.");
		txt2 = new JLabel("Cada quadrado pode ser revelado clicando sobre ele, se o quadrado clicado contiver uma mina, ent�o o jogo acaba.");
		txt3 = new JLabel("Se, por outro lado, o quadrado n�o contiver uma mina, uma de duas coisas poder� acontecer:");
		txt4 = new JLabel("1. Um n�mero aparece, indicando a quantidade de quadrados adjacentes que cont�m minas;");
		txt5 = new JLabel("2. Nenhum n�mero aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio j� que n�o podem conter minas;");
		txt6 = new JLabel("O jogo � ganho quando todos os os quadrados que n�o t�m minas s�o revelados.");
		
		teste = new JPanel(new GridLayout(1,6));
		
		panel.add(txt1);
		panel.add(txt2);
		panel.add(txt3); 
		panel.add(txt4);
		panel.add(txt5);
		panel.add(txt6);
		
		panel.add(teste);
		
		buttonFechar = new JButton("Fechar");
		buttonFechar.addActionListener(this);
		
		add(titulo);
		add(imagem);
		add(panel, BorderLayout.CENTER);
		add(buttonFechar, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}	
}
