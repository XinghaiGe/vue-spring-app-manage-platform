package com.gxh.app_back.mapper;

import com.gxh.app_back.domain.BackendUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author XinghaiGe
* @description 针对表【backend_user】的数据库操作Mapper
* @createDate 2025-04-25 15:35:22
* @Entity generator.domain.BackendUser
*/
@Mapper
public interface BackendUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);

    BackendUser selectByUserName(String username);
}
