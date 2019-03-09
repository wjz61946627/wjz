package nwsuaf.service;

import nwsuaf.model.AyUserAddress;

/**
 * 描述：地址服务接口
 * @author Ay
 * @create 2018/05/01
 **/
public interface AyUserAddressService {

    AyUserAddress findById(Integer id);
}
