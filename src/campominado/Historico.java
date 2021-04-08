package campominado;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "historico" )
public class Historico {

	int id;
    Date data;
    Time duracao;
    String dificuldade;

    public Historico () {}
    
    public Historico (int id, Date data, Time duracao, String dificuldade) {
        super();
        this.id = id;
        this.data = data;
        this.duracao = duracao;
        this.dificuldade = dificuldade;
    }

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Time getDuracao() {
		return duracao;
	}
	public void setDuracao(Time duracao) {
		this.duracao = duracao;
	}

	public String getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
    
}