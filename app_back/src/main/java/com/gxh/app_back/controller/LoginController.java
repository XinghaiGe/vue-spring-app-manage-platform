package com.gxh.app_back.controller;

import com.gxh.app_back.dto.LoginDto;
import com.gxh.app_back.service.LoginService;
import com.gxh.app_back.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResultVo login(@RequestBody LoginDto loginDto) {
        String token = loginService.login(loginDto);
        return ResultVo.success("登录成功",token);
    }
}
