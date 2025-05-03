package com.gxh.app_back.exception;

import com.gxh.app_back.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo error(Exception e) {
        e.printStackTrace();
        return ResultVo.error(e.getMessage());
    }
}
