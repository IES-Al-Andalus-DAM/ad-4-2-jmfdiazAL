package chinookHib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class ChinookHib {

	public static void main(String[] args) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    System.out.println("Comienzo de Hibernate!");

	    List<Object[]> results = session.createSQLQuery("SELECT * FROM Genre").list();
	    for (Object[] obj : results) {
	        System.out.println(obj[0	].toString()+"\t"+obj[1].toString());
	    }
	    
	    NativeQuery query = session.createSQLQuery("SELECT * FROM Customer WHERE CustomerId = :customerId");
	    query.setParameter("customerId", 40);
	    results = query.list();
	    for (Object[] obj : results) {
	        System.out.println(obj[1].toString()+"\t"+obj[2].toString());
	    } 
	    
	    session.save(new Artist("Manolo Escobar"));
	    session.save(new Artist("Otro artista"));
	    
	    session.getTransaction().commit();
	    session.close();
	}

}
