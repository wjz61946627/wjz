package nwsuaf.service.impl;

import nwsuaf.dao.TeamDao;
import nwsuaf.model.Team;
import nwsuaf.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Resource
    private TeamDao teamDao;

    public int teamInsert(Team team){
        return teamDao.teamInsert(team);
    }

    public int teamDelete(int teamId){
        return teamDao.teamDelete(teamId);
    }

    public int teamUpdate(Team team){
        return teamDao.teamUpdate(team);
    }

    public List<Team> teamFindByTeamId(int teamId){
        return teamDao.teamFindByTeamId(teamId);
    }

    public List<Team> teamFindById(int id){
        return teamDao.teamFindById(id);
    }

    public List<Team> teamFindByProId(int proId){
        return teamDao.teamFindByProId(proId);
    }
}
