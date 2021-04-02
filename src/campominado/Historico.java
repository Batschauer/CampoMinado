package campominado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "historico" )
public class Historico {

	int id;
    String data;
    String duracao;
    String dificuldade;

    public Historico () {}
    
    public Historico (int id, String data, String duracao, String dificuldade) {
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
    
}


/*
(avaliar melhor classe) data
(avaliar melhor classe) duracao
(criar um enum dificuldade) dificuldade

--> Criar construtores (gets e sets) das outras classes depois de definir o tipo */