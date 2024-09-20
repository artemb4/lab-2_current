package org.example.dao;

import org.example.dao.schemas.Cat;
import org.hibernate.query.Query;

import java.util.List;

public class CatDao implements CatDaoInterface {
    @Override
    public void persist(Cat cat) {
        HibernateUtil.executeTransaction(session -> {
            session.save(cat);
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public void update(Cat cat) {
        HibernateUtil.executeTransaction(session -> {
            session.update(cat);
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public Cat findById(int id) {
        return HibernateUtil.executeTransaction(session -> {
            return session.get(Cat.class, id); // Возвращаем объект Cat
        });
    }

    @Override
    public void delete(int id) {
        HibernateUtil.executeTransaction(session -> {
            Cat cat = findById(id);
            if (cat != null) {
                session.delete(cat);
            }
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public List<Cat> findAll() {
        return HibernateUtil.executeTransaction(session -> {
            Query<Cat> query = session.createQuery("from Cat", Cat.class);
            return query.list();
        });
    }

    @Override
    public void clear() {
        HibernateUtil.executeTransaction(session -> {
            Query query = session.createQuery("delete from Cat");
            int result = query.executeUpdate();
            return null;
        });
    }
}
