package com.gxh.app_back;

import com.gxh.app_back.domain.AppCategory;
import com.gxh.app_back.mapper.AppCategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppBackApplicationTests {

    @Autowired
    AppCategoryMapper appCategoryMapper;

    @Test
    void contextLoads() {
        AppCategory appCategory = appCategoryMapper.selectByPrimaryKey(2L);
        System.out.println(appCategory);
        System.out.println(appCategory.getCategoryname());
    }

}
