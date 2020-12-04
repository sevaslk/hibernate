package com.myhibernate.dao.daoimpl;

import com.myhibernate.dao.SkillDAO;
import com.myhibernate.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SkillDAOImpl implements SkillDAO {
    private final SessionFactory sessionFactory;

    public SkillDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        }

    }

    @Override
    public Skill read(Long ID) {
        try (Session session = sessionFactory.openSession()) {
            Skill resultSkill = session.get(Skill.class, ID);
            return resultSkill != null ? resultSkill : new Skill();
        }
    }

    @Override
    public void update(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(skill);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(skill);
            session.getTransaction().commit();
        }
    }

    public List<Skill> readAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.createSQLQuery("SELECT name FROM skill").list();
        }
    }

}
