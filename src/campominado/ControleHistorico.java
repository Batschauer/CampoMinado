package campominado;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;

public class ControleHistorico {
	
	private Historico historico;
	
	private Time hInicio;
	
	public ControleHistorico(String dificuldade) {
		historico = new Historico();
		
		historico.setDificuldade(dificuldade);
	}
	
	@SuppressWarnings("deprecation")
	public void iniciar(){
		LocalDateTime now = LocalDateTime.now();
		
		hInicio = new Time(now.getHour(), now.getMinute(), now.getSecond());
	}
	
	@SuppressWarnings("deprecation")
	public void finalizar(){
		LocalDateTime now = LocalDateTime.now();
		
		Time hFim = new Time(now.getHour(), now.getMinute(), now.getSecond());
		
		long difference_In_Time = (hFim.getTime() - hInicio.getTime());

		Time timediff = new Time(difference_In_Time);
		
		historico.setDuracao(timediff);
		historico.setData(new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth()));
	}
	
	public void salvar()
	{
		HistoricoDAO banco = new HistoricoDAO();
		banco.AdicionarHistorico(historico);
	}
}
