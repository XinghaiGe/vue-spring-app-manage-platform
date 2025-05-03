package com.gxh.app_back.mapper;

import com.gxh.app_back.domain.DevUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author XinghaiGe
* @description 针对表【dev_user】的数据库操作Mapper
* @createDate 2025-04-25 15:35:22
* @Entity generator.domain.DevUser
*/
@Mapper
public interface DevUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    DevUser selectByUserName(String username);
}
