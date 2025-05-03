package com.gxh.app_back.service;

import com.gxh.app_back.domain.AppVersion;
import com.gxh.app_back.mapper.AppVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppVersionService {

    @Autowired
    AppVersionMapper appVersionMapper;

    public void save(AppVersion appVersion) {

        appVersionMapper.insert(appVersion);

    }
}
