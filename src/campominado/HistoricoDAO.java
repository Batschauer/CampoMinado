package campominado;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HistoricoDAO {

	public void AdicionarHistorico(Historico historico) {
		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(historico);

		session.getTransaction().commit();
		session.close();
	}

	public List<Historico> BuscarHistoricos(int index, Historico historico) {
		String sql = "select * from Historico";

		if (index != 0 || historico != null) {
			sql += " where";

			if (index != 0)
				sql += " id=:id";

			if (historico != null)
				sql += " dificuldade=:diff";
		}

		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();
		session.beginTransaction();

		Query SQLQuery = session.createSQLQuery(sql);
		if (index != 0)
			SQLQuery.setParameter("id", historico.getId());
		
		if (historico != null)
			SQLQuery.setParameter("diff", historico.getDificuldade());

		ArrayList<Historico> historicos = new ArrayList<Historico>();

		List<Object[]> resultList = SQLQuery.getResultList();
		for (Object[] object : resultList) {

			Object[] aux = object;
			Historico his = new Historico();

			his.setId((Integer) aux[0]);
			his.setData((Date) aux[1]);
			his.setDuracao((Time) aux[2]);
			his.setDificuldade((String) aux[3]);
			historicos.add(his);
		}

		session.getTransaction().commit();
		session.close();

		return historicos;
	}
}