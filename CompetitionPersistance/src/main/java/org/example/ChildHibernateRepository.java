package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Objects;
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
        HibernateUtils.getSessionFactory().inTransaction(session -> {
            if (!Objects.isNull(session.find(Child.class, entityForUpdate.getId()))) {
                //System.out.println("Am dat update la "+entityForUpdate.getId());
                logger.info("Am dat update la {}", entityForUpdate.getId());
                session.merge(entityForUpdate);
                session.flush();
            }
        });
        return entityForUpdate;
    }

    @Override
    public Child findByName(String name) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createSelectionQuery("from Child where name=:nameM ", Child.class)
                    .setParameter("nameM", name)
                    .getSingleResultOrNull();
        }
    }

    @Override
    public Child findOne(Integer integer) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createSelectionQuery("from Child where id=:idM ", Child.class)
                    .setParameter("idM", integer)
                    .getSingleResultOrNull();
        }
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
            logger.info("Child added with id {}", entityForAdd.getId());
        });
        return entityForAdd;
    }
}
