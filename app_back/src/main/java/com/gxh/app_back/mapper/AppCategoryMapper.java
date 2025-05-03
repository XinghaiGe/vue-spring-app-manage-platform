package com.gxh.app_back.mapper;

import com.gxh.app_back.domain.AppCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author XinghaiGe
* @description 针对表【app_category(手游类别)】的数据库操作Mapper
* @createDate 2025-04-25 15:35:22
* @Entity generator.domain.AppCategory
*/
@Mapper
public interface AppCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);

    List<AppCategory> selectAll();
}
