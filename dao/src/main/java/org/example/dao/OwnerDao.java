package org.example.dao;

import org.example.dao.schemas.Cat;
import org.example.dao.schemas.Owner;
import org.hibernate.query.Query;

import java.util.List;

public class OwnerDao implements OwnerDaoInterface {

    @Override
    public void persist(Owner owner) {
        HibernateUtil.executeTransaction(session -> {
            session.save(owner);
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public void update(Owner owner) {
        HibernateUtil.executeTransaction(session -> {
            session.update(owner);
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public Owner findById(int id) {
        return HibernateUtil.executeTransaction(session -> session.get(Owner.class, id));
    }

    @Override
    public void delete(int id) {
        HibernateUtil.executeTransaction(session -> {
            Owner owner = findById(id);
            if (owner != null) {
                session.delete(owner);
            }
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public List<Cat> findCats(int id) {
        return HibernateUtil.executeTransaction(session -> {
            Query<Cat> query = session.createQuery("from Cat where owner.id = :id", Cat.class);
            return query.list();
        });
    }

    @Override
    public void clear() {
        HibernateUtil.executeTransaction(session -> {
            Query query = session.createQuery("delete from Owner");
            int result = query.executeUpdate();
            return null;
        });
    }
}
