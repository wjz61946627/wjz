package nwsuaf.service.impl;

import nwsuaf.dao.UserMoodPraiseRelDao;
import nwsuaf.model.UserMoodPraiseRel;
import nwsuaf.service.UserMoodPraiseRelService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 描述：用户说说点赞关联服务类
 * @author Ay
 * @date  2018/1/6.
 */
@Service
public class UserMoodPraiseRelServiceImpl implements UserMoodPraiseRelService {

    @Resource
    private UserMoodPraiseRelDao userMoodPraiseRelDao;

    public boolean save(UserMoodPraiseRel userMoodPraiseRel) {
        return userMoodPraiseRelDao.save(userMoodPraiseRel);
    }
}
