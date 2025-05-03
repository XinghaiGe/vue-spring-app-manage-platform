package com.gxh.app_back.intercept;

import com.alibaba.fastjson.JSON;
import com.gxh.app_back.utils.JwtUtils;
import com.gxh.app_back.vo.ResultVo;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查前端token
        String token = request.getHeader("token");
        // 有无token，或token不合法
        if (!StringUtils.hasText(token)) {
            PrintWriter writer = response.getWriter();
            // todo 解决乱码
            response.setContentType("application/json;charset=UTF-8");
            writer.write(JSON.toJSONString(ResultVo.reject("token不存在")));
            writer.close();
            writer.flush();
            return false;
        }

        try {
            JwtUtils.getUserName(token);
            return true;
        } catch (Exception e) {
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(ResultVo.reject(e.getMessage())));
            writer.close();
            writer.flush();
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
