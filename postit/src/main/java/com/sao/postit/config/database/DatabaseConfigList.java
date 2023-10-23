package com.sao.postit.config.database;

import com.sao.postit.model.dto.Message;
import com.sao.postit.model.dto.Team;
import com.sao.postit.model.dto.User;
import org.hibernate.cfg.Configuration;

/**
 * @author saozd
 * @project com.sao.postit.config.database courseexample
 * 7.06.2023 Haz 2023
 */
public final class DatabaseConfigList {
    private DatabaseConfigList() {
    }

    public static Configuration getConfigList() {
        Configuration configuration = new Configuration();
        //ConfigurationList
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Team.class);
        configuration.addAnnotatedClass(Message.class);

        return configuration;
    }
}
