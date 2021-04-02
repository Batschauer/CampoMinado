package campominado;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaHistorico extends JFrame implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	JPanel panelNorth, panelSouth;
	JComboBox<String>comboBox;
	JLabel label;
	JButton buttonOk;
	
	public TelaHistorico() {
		
		setTitle("Hist�rico");
		setSize(280, 330);
		panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		label = new JLabel("N�vel: ");
		panelNorth.add(label);
		
		String[] hist = {"F�cil", "M�dio", "Dif�cil"};
		
		comboBox = new JComboBox<String>(hist);
		comboBox.addActionListener(this);
		panelNorth.add(comboBox);
		
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(this);
		panelSouth.add(buttonOk);
		
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("Ok")) {
			//implementar
		}
		
		JComboBox cb = (JComboBox)e.getSource();
        String selecionado = (String)cb.getSelectedItem();
        
        if(selecionado == "F�cil") {
        	//implementar
        } else if (selecionado == "M�dio") {
        	//implementar
        } else if (selecionado == "Dif�cil") {
        	//implementar
        }
		
	}

}