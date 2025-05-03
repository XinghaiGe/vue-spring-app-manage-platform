package com.gxh.app_back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxh.app_back.domain.AppInfo;
import com.gxh.app_back.domain.AppVersion;
import com.gxh.app_back.mapper.AppInfoMapper;
import com.gxh.app_back.mapper.AppVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class AppInfoService {
    @Autowired
    AppInfoMapper appInfoMapper;
    @Autowired
    AppVersionMapper appVersionMapper;

    public PageInfo getPage(AppInfo appInfo, Integer pageNum) {
        PageHelper.startPage(pageNum, 5, "id desc");
        List<AppInfo> list = appInfoMapper.selectBy(appInfo);
//        System.out.println("list"+ list);
//        if (pageNum <= 0) {
//            throw new RuntimeException("当前页不能小于等于0");
//        }
        return new PageInfo(list);
    }

    public void saveOrUpdate(AppInfo appInfo, MultipartFile logo) {
        if (appInfo.getId() == null) {
            appInfo.setCreationdate(new Date());
            appInfo.setDownloads(0L);
            appInfo.setStatus(1L); // 待审核状态
            System.out.println("devname:" + appInfo.getDevName());
            // todo 保存登陆者id
            // appInfo.setCreatedby();
            // appInfo.setDevid();

            appInfoMapper.insert(appInfo);
        } else {
            appInfo.setModifydate(new Date());

            appInfoMapper.updateByPrimaryKey(appInfo);
        }
    }

    public boolean validateApkname(String apkname, Long id) {

        // 排除情况
        if (id != null) {
            AppInfo appInfo1 = appInfoMapper.selectByPrimaryKey(id);
            if (appInfo1.getApkname().equals(apkname)) {
                return true;
            }
        }

        // 普通情况
        AppInfo appInfo = new AppInfo();
        appInfo.setApkname(apkname);
        List<AppInfo> list = appInfoMapper.selectBy(appInfo);

        if (list == null || list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public AppInfo getById(Long id) {
        return appInfoMapper.selectByPrimaryKey(id);
    }

    public AppInfo getAppWithVersion(Long appid) {
        AppInfo appInfo = appInfoMapper.selectByPrimaryKey(appid);
        appInfo.setVersions(appVersionMapper.selectByAppId(appid));
        return appInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public void del(Long id, String uploadPath) {
        // 删除app下的版本信息里的apk文件

        List<AppVersion> appVersions = appVersionMapper.selectByAppId(id);
        appVersions.forEach(appVersion -> {
            if (appVersion.getDownloadlink() != null) {
                File file = new File(uploadPath + appVersion.getDownloadlink());
                if (file.exists()) {
                    file.delete();
                }
                appVersionMapper.deleteByPrimaryKey(appVersion.getId());
            }
        });

        // 删除appinfo和logo
        AppInfo appInfo = appInfoMapper.selectByPrimaryKey(id);
        if (appInfo.getLogopicpath() != null) {
            File logo = new File(uploadPath + appInfo.getLogopicpath());
            if (logo.exists()) {
                logo.delete();
            }
        }
        appInfoMapper.deleteByPrimaryKey(id);
    }

    public void shenhe(Long appid, Integer opType) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(appid);
        if (opType == 1) {//通过
            appInfo.setStatus(2L);
            appInfoMapper.updateByPrimaryKey(appInfo);
        } else if (opType == 2) {//拒绝
            appInfo.setStatus(3L);
        } else {
            throw new RuntimeException("操作不合法");
        }
    }
}
