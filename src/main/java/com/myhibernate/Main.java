package com.myhibernate;

import com.myhibernate.dao.DAO;
import com.myhibernate.dao.daoimpl.DeveloperDAOImpl;
import com.myhibernate.dao.daoimpl.SkillDAOImpl;
import com.myhibernate.model.Developer;
import com.myhibernate.model.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            DAO<Skill, Long> skillDAO = new SkillDAOImpl(sessionFactory);
            DAO<Developer, Long> developerDAO = new DeveloperDAOImpl(sessionFactory);
            System.out.println(developerDAO.read(1L));
        }
    }
}
