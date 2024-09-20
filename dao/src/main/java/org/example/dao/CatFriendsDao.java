package org.example.dao;

import org.example.dao.schemas.Cat;
import org.example.dao.schemas.CatFriends;
import org.example.dao.schemas.CatFriendsId;
import org.hibernate.query.Query;

import java.util.List;

public class CatFriendsDao implements CatFriendsInterface {
    @Override
    public void persist(CatFriends catFriends) {
        HibernateUtil.executeTransaction(session -> {
            session.save(catFriends);
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public void update(CatFriends catFriends) {
        HibernateUtil.executeTransaction(session -> {
            session.update(catFriends);
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public List<Cat> findById(int catId) {
        return HibernateUtil.executeTransaction(session -> {
            Query<Integer> friendIdQuery = session.createQuery("select cf.id.friendCatId from CatFriends cf where cf.id.catId = :catId", Integer.class);
            friendIdQuery.setParameter("catId", catId);
            List<Integer> friendCatIds = friendIdQuery.list();

            // Запрос для получения объектов котов по их идентификаторам
            if (friendCatIds.isEmpty()) {
                return List.of(); // Если нет друзей, возвращаем пустой список
            }

            Query<Cat> catQuery = session.createQuery("from Cat c where c.id in :friendCatIds", Cat.class);
            catQuery.setParameter("friendCatIds", friendCatIds);
            return catQuery.list();
        });
    }

    @Override
    public void delete(CatFriendsId catFriendsId) {
        HibernateUtil.executeTransaction(session -> {
            CatFriends catFriends = session.get(CatFriends.class, catFriendsId);
            if (catFriends != null) {
                session.delete(catFriends);
            }
            return null; // Поскольку мы не ожидаем результата, возвращаем null
        });
    }

    @Override
    public void clear() {
        HibernateUtil.executeTransaction(session -> {
            Query query = session.createQuery("delete from CatFriends");
            int result = query.executeUpdate();
            return null;
        });
    }
}
