package com.gxh.app_back.mapper;

import com.gxh.app_back.domain.DataDictionary;
import org.apache.ibatis.annotations.Mapper;

/**
* @author XinghaiGe
* @description 针对表【data_dictionary】的数据库操作Mapper
* @createDate 2025-04-25 15:35:22
* @Entity generator.domain.DataDictionary
*/
@Mapper
public interface DataDictionaryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

}
