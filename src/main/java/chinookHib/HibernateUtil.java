package chinookHib;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    // Código estático, se ejecuta una sóla vez como en el patrón Singleton
    static {
        try {
            // Creamos el SessionFactory desde el archivo estándar de configuración (hibernate.cfg.xml)
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception.
            System.err.println("Error en la inicialización de SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}