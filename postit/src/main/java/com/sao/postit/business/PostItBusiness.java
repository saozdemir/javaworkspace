package com.sao.postit.business;

import com.sao.postit.config.database.DatabaseService;
import com.sao.postit.model.dto.Team;

import java.util.Collection;
import java.util.List;

/**
 * @author saozd
 * @project com.sao.postit.business courseexample
 * 7.06.2023 Haz 2023
 */
public class PostItBusiness implements IPostItBusiness {

    @Override
    public List getTeamList() {
        DatabaseService service = new DatabaseService();
        return service.queryList(Team.class, new Team());
    }
}
