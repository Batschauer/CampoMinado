package campominado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class TelaSobre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel imagem;
	ImageIcon icon;
	JButton buttonFechar;
	JPanel panel;
	
	public TelaSobre() {
		setTitle("Sobre");
		setSize(530, 570);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel(new GridLayout(1,1));
		
		icon = new ImageIcon("img/sobre.png");	//para deixar igual o do professor alterar o sobre para cm
		panel.add(imagem = new JLabel(icon));
		
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
