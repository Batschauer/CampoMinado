package campominado;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class HistoricoDAO {

	public void AdicionarHistorico(Historico historico)
	{
		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(historico);

		session.getTransaction().commit();
		session.close();
	}
	
	public List<Historico> BuscarHistoricos(int index, Historico historico)
	{
		String sql = "select * from Historico";
		
		if (index != 0 && historico != null)
		{
			sql += " where";
			
			if (index != 0)
				sql += " id=?";
			
			if (historico != null)
				sql += " dificuldade=?";
		}
		
		sql += ";";
		
		Hibernate hibernate = new Hibernate();
		
		Session session = hibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query SQLQuery = session.createSQLQuery(sql);
		
		if (index != 0)
			SQLQuery.setParameter(0, index);
		if (historico != null)
			SQLQuery.setParameter(1, historico.getDificuldade());
		
		List resultList = SQLQuery.getResultList();
		
		session.getTransaction().commit();
		session.close();

		return (List<Historico>) resultList;
	}	
}