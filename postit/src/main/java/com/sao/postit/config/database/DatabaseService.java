package com.sao.postit.config.database;

import com.sao.postit.model.dto.Team;
import com.sao.postit.model.dto.User;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozd
 * @project com.sao.postit.config.database courseexample
 * 3.06.2023 Haz 2023
 */
public class DatabaseService<T> {
    private Session session = null;
    private Transaction transaction = null;

    public DatabaseService() {
        BasicConfigurator.configure();
    }

    private void createService() {
        session = DatabaseSession.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public boolean insertObject(Object object) {
        try {
            createService();
            //session.merge(object);
            session.save(object);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean updateObject(T object, Long criteriaId) {
        try {
            createService();
//            Class<?> clazz = object.getClass();
//            Object query = queryObject((Class<T>) clazz, criteriaId);
            //session.update(object);
            session.update(object);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteObject(T object) {

    }

//    public T queryObject(Class<T> clazz, T criteria) {
//        createService();
//        T result = session.get(clazz, criteria);
//        return result;
//    }

    public T queryObject(Class<T> clazz, Long criteriaId) {
        try {
            createService();
            T result = session.get(clazz, criteriaId);
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<T> queryList(Class<T> clazz, T criteria) {
        List results = null;

        try {
            createService();
            Query<T> query = (Query<T>) session.createQuery("FROM " + clazz.getSimpleName(), clazz);
            results = query.getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return results != null ? results : new ArrayList<>();
    }
}
