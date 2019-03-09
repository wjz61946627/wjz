package nwsuaf.service.impl;

import nwsuaf.dao.AyRoleDao;
import nwsuaf.dao.AyUserDao;
import nwsuaf.model.AyRole;
import nwsuaf.model.AyUser;
import nwsuaf.service.AyRoleService;
import nwsuaf.service.AyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyRoleServiceImpl implements AyRoleService{

    @Resource
    private AyRoleDao ayRoleDao;

    public AyRole findById(String id) {
        return ayRoleDao.findById(id);
    }
}
