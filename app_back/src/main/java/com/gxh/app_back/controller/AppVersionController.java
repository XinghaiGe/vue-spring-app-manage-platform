package com.gxh.app_back.controller;

import com.gxh.app_back.domain.AppVersion;
import com.gxh.app_back.service.AppVersionService;
import com.gxh.app_back.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/version")
public class AppVersionController {

    @Autowired
    AppVersionService appVersionService;

    @Value("${upload.path}")
    String uploadPath;

    // apk上传
    @PostMapping
    public ResultVo add(AppVersion appVersion, MultipartFile apkFile) {

        if (apkFile != null && !apkFile.isEmpty()) {
            // 说明前端传了文件
            String originalFilename = apkFile.getOriginalFilename();

            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            if (apkFile.getSize() > 10 * 1024 * 1024) {

                return ResultVo.error("文件过大，请上传不要超过10M");

            } else if (suffix.equalsIgnoreCase(".apk")) {

                // 上传文件
                File savePath = new File(uploadPath);
                if (!savePath.exists()) {
                    savePath.mkdirs();
                }

                // 文件重命名
                String newName = UUID.randomUUID().toString().replace("-", "");
                File saveFile = new File(uploadPath + newName + suffix);
                try {
                    apkFile.transferTo(saveFile);
                    // 文件上传成功

                    // 文件名保存到数据库
                    appVersion.setDownloadlink(newName + suffix);
                    appVersion.setCreationdate(new Date());
                    appVersion.setPublishstatus(3L); // 预发布

                    appVersionService.save(appVersion);

                    return ResultVo.success("上传apk成功", null);

                } catch (IOException e) {
                    throw new RuntimeException("文件上传异常");
                }
            } else {
                return ResultVo.error("文件格式不对，必须是apk");
            }
        } else {
            return ResultVo.error("请上传apk");
        }
    }

}
