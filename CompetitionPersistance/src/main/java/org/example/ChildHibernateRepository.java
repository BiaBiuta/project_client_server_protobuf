package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Properties;

public class ChildHibernateRepository implements IChildRepository{

    private JdbcUtils jdbcUtils;

    private static final Logger logger= LogManager.getLogger();
    public ChildHibernateRepository(Properties props){
        logger.info("Initializing ChildRepository with properties: {}",props);
        jdbcUtils = new JdbcUtils(props);
    }

    @Override
    public Child update(Child entityForUpdate) {
        return null;
    }

    @Override
    public Child findByName(String name) {
        return null;
    }

    @Override
    public Child findOne(Integer integer) {
        return null;
    }

    @Override
    public Iterable<Child> findAll() {
        try( Session session=HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Child  ", Child.class).getResultList();
        }
    }

    @Override
    public Child save(Child entityForAdd) {
        HibernateUtils.getSessionFactory().inTransaction(session -> {
            session.persist(entityForAdd);
            System.out.println("Child added");
            System.out.println(entityForAdd.getId());
        });
        return entityForAdd;
    }
}
