package com.bootStart2.dao;

import com.bootStart2.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query= entityManager.createQuery(
                "SELECT user from User user", User.class);
        return query.getResultList();
    }

    @Override
    public User getOneUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getOneUser(id));
    }

    public void update(int id, User user) {
        User userForUpdate = getOneUser(id);
        userForUpdate.setName(user.getName());
        userForUpdate.setSurName(user.getSurName());
        userForUpdate.setAge(user.getAge());
        userForUpdate.setDepartment(user.getDepartment());
        add(userForUpdate);
    }
}
