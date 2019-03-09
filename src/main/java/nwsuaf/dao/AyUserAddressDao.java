package nwsuaf.dao;

import nwsuaf.model.AyUser;
import nwsuaf.model.AyUserAddress;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AyUserAddressDao {

    AyUserAddress findById(Integer id);
}
