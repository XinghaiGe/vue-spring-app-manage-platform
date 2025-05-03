package com.gxh.app_back.controller;

import com.gxh.app_back.domain.AppCategory;
import com.gxh.app_back.service.AppCategoryService;
import com.gxh.app_back.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appCategory")
public class AppCategoryController {

    @Autowired
    AppCategoryService appCategoryService;

    @GetMapping("tree")
    public ResultVo getTree() {
        AppCategory appCategory = appCategoryService.getTree();
        return ResultVo.success("查询成功",appCategory );
    }
}
