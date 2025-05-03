package com.gxh.app_back.controller;

import com.github.pagehelper.PageInfo;
import com.gxh.app_back.domain.AppInfo;
import com.gxh.app_back.service.AppInfoService;
import com.gxh.app_back.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/appInfo")
public class AppInfoController {

    @Autowired
    AppInfoService appInfoService;

    @Value("${upload.path}")
    String uploadPath;

    @GetMapping("/shenhe")
    public ResultVo shenhe(Long appid,Integer opType) {
        try {
            appInfoService.shenhe(appid, opType);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error("操作失败");
        }
        return ResultVo.success("操作成功",null);
    }

    @DeleteMapping("/{id}")
    public ResultVo del(@PathVariable Long id) {
        appInfoService.del(id, uploadPath);
        return ResultVo.success("删除成功", null);
    }

    // 查询app基本信息的同时把该app的版本都返回
    @GetMapping("/appWithVersion/{appid}")
    public ResultVo appWithVersion(@PathVariable Long appid) {
        AppInfo appInfo = appInfoService.getAppWithVersion(appid);
        return ResultVo.success("", appInfo);
    }

    // 上传logo图片
    @PostMapping("/upLogo/{id}")
    public ResultVo upLogo(@PathVariable Long id, MultipartFile logo) {
        if (logo != null && !logo.isEmpty()) {
            // 说明前端传了文件
            String originalFilename = logo.getOriginalFilename();

            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            if (logo.getSize() > 1024 * 1024) {
                return ResultVo.error("文件过大，请上传不要超过1M");
            } else if (
                    suffix.equalsIgnoreCase(".jpg") ||
                            suffix.equalsIgnoreCase(".jpeg") ||
                            suffix.equalsIgnoreCase(".gif") ||
                            suffix.equalsIgnoreCase(".png")
            ) {
                // 上传文件
                File savePath = new File(uploadPath);
                if (!savePath.exists()) {
                    savePath.mkdirs();
                }

                // 文件重命名
                String newName = UUID.randomUUID().toString().replace("-", "");
                File saveFile = new File(uploadPath + newName + suffix);
                try {
                    logo.transferTo(saveFile);
                    // 文件上传成功

                    // 文件名保存到数据库
                    AppInfo appInfo = appInfoService.getById(id);

                    appInfo.setLogopicpath(newName + suffix);
// todo logo
                    appInfoService.saveOrUpdate(appInfo,null);

                    return ResultVo.success("上传logo成功", null);

                } catch (IOException e) {
                    throw new RuntimeException("文件上传异常");
                }
            } else {
                return ResultVo.error("文件格式不对，必须是图片");
            }
        }
        return ResultVo.error("请上传logo");
    }

    // 校验apkname不能重复
    @GetMapping("/validate")
    public ResultVo validateApkname(@RequestParam(required = true) String apkname, @RequestParam(required = false) Long id) {
        boolean flag = appInfoService.validateApkname(apkname, id);
        return ResultVo.success(null, flag);
    }

    // 分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody AppInfo appInfo, @RequestParam(defaultValue = "1") Integer pageNum) {
        // 数据 list total pages
        PageInfo pageInfo = appInfoService.getPage(appInfo, pageNum);

        // Integer a =  Integer.parseInt("www");

        return ResultVo.success("查询成功", pageInfo);
    }

    // 修改接口
    @PostMapping("/add")
    public ResultVo add(@RequestBody AppInfo appInfo, MultipartFile logo) {
        appInfoService.saveOrUpdate(appInfo,logo);
        return ResultVo.success("操作成功", null);
    }

    // 上下架
    @PutMapping("/upOrDown/{id}")
    public ResultVo upOrDown(@PathVariable Long id) {
        AppInfo appInfo = appInfoService.getById(id);
        if (appInfo.getStatus() == 4L) {
            appInfo.setStatus(5L);
        } else if (appInfo.getStatus() == 5L) {
            appInfo.setStatus(4L);
        }
//        todo logo
        appInfoService.saveOrUpdate(appInfo,null);
        return ResultVo.success("", null);
    }
}
