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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TelaHistorico extends JFrame implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	JPanel panelNorth, panelSouth;
	JComboBox<String>comboBox;
	JLabel label;
	JButton buttonOk;
	JTable tableHistorico;
	
	public TelaHistorico() {
		
		setTitle("Histórico");
		setSize(280, 330);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		label = new JLabel("Nível: ");
		panelNorth.add(label);
		
		String[] hist = {"Fácil", "Médio", "Difícil"};
		
		comboBox = new JComboBox<String>(hist);
		comboBox.addActionListener(this);
		panelNorth.add(comboBox);
		
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(this);
		panelSouth.add(buttonOk);
		
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
	
		TableModel dataModel = (TableModel) new AbstractTableModel() {
			
			@Override
			public int getColumnCount () {
				return 2;
			}

			@Override
			public int getRowCount() {
				return 1;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				//implementar
				return null;
			}
			
			
		};
		
		tableHistorico = new JTable(dataModel);
		JScrollPane jp = new JScrollPane(tableHistorico);
		
		add(jp, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("Ok")) {
			this.dispose();
		}
		
        if(comboBox.getSelectedItem() == "Fácil") {
        	//implementar
        } else if (comboBox.getSelectedItem() == "Médio") {
        	//implementar
        } else if (comboBox.getSelectedItem() == "Difícil") {
        	//implementar
        }
		
	}

}