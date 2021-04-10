package campominado;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TelaHistorico extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel panelNorth, panelSouth;
	JComboBox<String> comboBox;
	JLabel label;
	JButton buttonOk;
	HistoricoDAO controle;

	String lastSelectedItem = new String();

	HistoricosTableModel tableModel;

	public TelaHistorico() {

		setTitle("Histórico");
		setSize(280, 330);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		label = new JLabel("Nível: ");
		panelNorth.add(label);

		String[] hist = { "Fácil", "Médio", "Difícil" };

		comboBox = new JComboBox<String>(hist);
		comboBox.addActionListener(this);
		panelNorth.add(comboBox);

		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(this);
		panelSouth.add(buttonOk);

		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);

		controle = new HistoricoDAO();

		tableModel = new HistoricosTableModel();
		JTable tableHistorico = new JTable(tableModel);
		JScrollPane jp = new JScrollPane(tableHistorico);

		add(jp, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Ok")) {
			this.dispose();
		}

		String selectedItem = comboBox.getSelectedItem().toString();

		if (lastSelectedItem == selectedItem)
			return;
		
		lastSelectedItem = selectedItem;
		
		Historico historico = new Historico();
		List<Historico> historicos = null;

		if (selectedItem == "Fácil") {
			historico.setDificuldade("Facil");
			historicos = controle.BuscarHistoricos(0, historico);
		} else if (selectedItem == "Médio") {
			historico.setDificuldade("Medio");
			historicos = controle.BuscarHistoricos(0, historico);
		} else if (selectedItem == "Difícil") {
			historico.setDificuldade("Dificil");
			historicos = controle.BuscarHistoricos(0, historico);
		}

		historicos = controle.BuscarHistoricos(0, historico);

		tableModel.setHistoricos(historicos);
	}

}