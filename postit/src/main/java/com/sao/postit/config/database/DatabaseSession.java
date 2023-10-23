package com.sao.postit.config.database;

import com.sao.postit.model.dto.Team;
import com.sao.postit.model.dto.Message;
import com.sao.postit.model.dto.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


/**
 * @author saozd
 * @project com.sao.postit.config.database courseexample
 * 3.06.2023 Haz 2023
 */
public class DatabaseSession {
    private static final SessionFactory sessionFactory = createSessionFactory();
    private static final Logger logger = Logger.getLogger(DatabaseSession.class);

    private static SessionFactory createSessionFactory() {
        try {
//            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(User.class);
//            configuration.addAnnotatedClass(Team.class);
//            configuration.addAnnotatedClass(Message.class);
            Configuration configuration = DatabaseConfigList.getConfigList();

            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            System.out.println("Session Factory Exception");
            logger.error("Session Factory", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
