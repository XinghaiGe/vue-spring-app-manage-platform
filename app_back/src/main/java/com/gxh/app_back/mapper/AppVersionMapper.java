package com.gxh.app_back.mapper;

import com.gxh.app_back.domain.AppVersion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author XinghaiGe
* @description 针对表【app_version】的数据库操作Mapper
* @createDate 2025-04-25 15:35:22
* @Entity generator.domain.AppVersion
*/
@Mapper
public interface AppVersionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    List<AppVersion> selectByAppId(Long appid);
}
