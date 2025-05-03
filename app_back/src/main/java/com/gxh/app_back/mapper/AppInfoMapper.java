package com.gxh.app_back.mapper;

import com.gxh.app_back.domain.AppInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author XinghaiGe
* @description 针对表【app_info】的数据库操作Mapper
* @createDate 2025-04-25 15:35:22
* @Entity generator.domain.AppInfo
*/
@Mapper
public interface AppInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    List<AppInfo> selectBy(AppInfo appInfo);
}
