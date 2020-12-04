package com.myhibernate.dao.daoimpl;

import com.myhibernate.dao.DeveloperDAO;
import com.myhibernate.model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DeveloperDAOImpl implements DeveloperDAO {
    private final SessionFactory sessionFactory;

    public DeveloperDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Developer read(Long ID) {
        try (Session session = sessionFactory.openSession()) {
            Developer resultDeveloper = session.get(Developer.class, ID);
            return resultDeveloper != null ? resultDeveloper : new Developer();
        }
    }

    @Override
    public void update(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(developer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(developer);
            session.getTransaction().commit();
        }
    }

    public List<Developer> readAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.createSQLQuery("SELECT name FROM developer").list();
        }
    }

}
