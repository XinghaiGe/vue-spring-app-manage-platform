package com.gxh.app_back.service;

import com.gxh.app_back.domain.BackendUser;
import com.gxh.app_back.domain.DevUser;
import com.gxh.app_back.dto.LoginDto;
import com.gxh.app_back.mapper.BackendUserMapper;
import com.gxh.app_back.mapper.DevUserMapper;
import com.gxh.app_back.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    DevUserMapper devUserMapper;

    @Autowired
    BackendUserMapper backendUserMapper;

    public String login(LoginDto loginDto) {
        System.out.println(loginDto);
        if (loginDto.getUserType().equals("admin")) {
            // 判断账号密码正确
            BackendUser admin = backendUserMapper.selectByUserName(loginDto.getUsername());
            if (admin == null) {
                throw new RuntimeException("该账号不存在");
            }

            if (!admin.getUserpassword().equals(loginDto.getPassword())) {
                throw new RuntimeException("密码错误");
            }
            // 账号密码都正确，颁发token
            String token = JwtUtils.getToken(loginDto.getUsername());
            return token;

        } else if (loginDto.getUserType().equals("dev")) {

            // 判断账号密码正确
            DevUser devUser = devUserMapper.selectByUserName(loginDto.getUsername());
            if (devUser == null) {
                throw new RuntimeException("该账号不存在");
            }

            if (!devUser.getDevpassword().equals(loginDto.getPassword())) {
                throw new RuntimeException("密码错误");
            }
            // 账号密码都正确，颁发token
            String token = JwtUtils.getToken(loginDto.getUsername());
            return token;

        } else {
            throw new RuntimeException("非法操作");
        }
    }
}

