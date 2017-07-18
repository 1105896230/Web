package com.fmt.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 否命题 on 2017/7/14.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest,
                                         javax.servlet.http.HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
//        发生异常的地方sevice 方法
        //可以记录到日志
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error","发生错误");
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
