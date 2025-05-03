package com.gxh.app_back.service;

import com.gxh.app_back.domain.AppCategory;
import com.gxh.app_back.mapper.AppCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppCategoryService {

    @Autowired
    AppCategoryMapper appCategoryMapper;

    public AppCategory getTree() {

        // 查出所有的分类
        List<AppCategory> list = appCategoryMapper.selectAll();

        // 最终是要组装出一个大树
        AppCategory tree = new AppCategory();

        for (AppCategory appCategory : list) {
            // 找到入口
            if (appCategory.getParentid() == null) {
                // 找孩子
                tree = findChildren(appCategory, list);
            }
        }

        return tree;
    }

    private AppCategory findChildren(AppCategory appCategory, List<AppCategory> list) {
        // 递归算法找孩子节点
        appCategory.setChildren(new ArrayList<>());

        for (AppCategory category : list) {
            if (category.getParentid() == appCategory.getId()) { // 如果你爹是我
                appCategory.getChildren().add(category); // 那么我是你爹
                findChildren(category, list);
            }
        }

        return appCategory;

    }
}
