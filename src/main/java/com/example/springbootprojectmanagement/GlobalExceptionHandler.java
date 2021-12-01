package com.example.springbootprojectmanagement;

import com.example.springbootprojectmanagement.exceptions.ParamsException;
import com.example.springbootprojectmanagement.model.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.AccessDeniedException;


/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin]
 * @ClassName: [GlobalExceptionHandler]
 * @Description:
 * @Author: [ZengQi]
 * @CreateDate: [2021-07-30  21:44]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-07-30  21:44]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */

// 未加入视图异常
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamsException.class)
    @ResponseBody
    public RespBean paramsExceptionHandler(ParamsException e) {
        return RespBean.error(e.getMsg());
    }


    @ExceptionHandler(AccessDeniedException.class)
    public String accessDeniedException(AccessDeniedException e) {
        return "403";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespBean exceptionHandler(Exception e) {
        return RespBean.error(e.getMessage());
    }

}
