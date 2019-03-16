package nwsuaf.service;

import nwsuaf.model.Team;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface TeamService {
    public int teamInsert(Team team);

    public int teamDelete(int teamId);

    public int teamUpdate(Team team);

    public List<Team> teamFindByTeamId(int teamId);

    public List<Team> teamFindById(int id);

    public List<Team> teamFindByProId(int proId);
}
