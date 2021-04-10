package campominado;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class HistoricosTableModel extends AbstractTableModel {

	private List<Historico> historicos;
	private String[] columns = new String[] { "Data", "Duração" };

	public HistoricosTableModel() {
		this.historicos = new ArrayList<Historico>();
	}

	public HistoricosTableModel(List<Historico> historicos) {
		this.historicos = historicos;
	}

	@Override
	public int getRowCount() {
		return historicos.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      Historico historico = historicos.get(rowIndex);

     switch (columnIndex) {
         case 0:
        	 historico.setData((Date) aValue);
         case 1:
        	 historico.setDuracao((Time) aValue);

         default:
             System.err.println("Índice da coluna inválido");
     }
     
     fireTableCellUpdated(rowIndex, columnIndex);
     
     }
	
	public void setValueAt(Historico aValue, int rowIndex) {
		Historico historico = historicos.get(rowIndex);

		historico.setData(aValue.getData());
		historico.setDuracao(aValue.getDuracao());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Historico historicoSelecionado = historicos.get(rowIndex);
		
		String valueObject = null;
		
		switch (columnIndex) {
			case 0: {
				valueObject = historicoSelecionado.getData().toString();
			}
			break;
			
			case 1: {
				valueObject = historicoSelecionado.getDuracao().toString();
			}
			break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}

		return valueObject;
	}
	
	@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
	
	public void addHistorico(Historico historico) {
		historicos.add(historico);

        int lastIndex = getRowCount() - 1;

        fireTableRowsInserted(lastIndex, lastIndex);
    }
	
	public void clear() {
		historicos.clear();
		
        fireTableDataChanged();
    }
	
	public void setHistoricos(List<Historico> historicos)
	{
		this.historicos = historicos;
		
		fireTableDataChanged();
	}
}
