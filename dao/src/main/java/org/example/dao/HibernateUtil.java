package org.example.dao;

import org.example.dao.schemas.Cat;
import org.example.dao.schemas.CatFriends;
import org.example.dao.schemas.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    static {
        try {
            // Создаем конфигурацию
            Configuration configuration = new Configuration();
            configuration.configure(); // Загружаем настройки из hibernate.cfg.xml

            // Создаем ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // Создаем SessionFactory из конфигурации и ServiceRegistry
            configuration.addAnnotatedClass(Cat.class);
            configuration.addAnnotatedClass(Owner.class);
            configuration.addAnnotatedClass(CatFriends.class);
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Логируем исключение, чтобы не пропустить его
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static <T> T executeTransaction(SessionFunction<T> function) {
        Transaction transaction = null;
        T result = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            try {
                result = function.apply(session);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e; // Пробрасываем исключение дальше
            }
        } catch (Exception e) {
            // Логирование ошибок, связанных с открытием или закрытием Session
            System.err.println("Error while managing session: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static void shutdown() {
        // Закрываем кэш и connection pool
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    @FunctionalInterface
    public interface SessionFunction<T> {
        T apply(Session session) throws Exception;
    }
}
