package com.ys.inventory.system.log.aspect;


import com.ys.inventory.common.configurer.oauth2.UserDetailsVO;
import com.ys.inventory.common.utils.SecurityUtil;
import com.ys.inventory.common.utils.UUIDUtil;
import com.ys.inventory.system.log.annotation.LogAction;
import com.ys.inventory.system.log.annotation.LogModule;
import com.ys.inventory.system.log.service.LogService;
import com.ys.inventory.system.log.vo.LogInsertVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.net.InetAddress;

/**
 * @author gp
 * @version 2018/06/20
 */
@Slf4j
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    LogService service;

    private long beforeTime;

    private long afterTime;

    @Pointcut("execution(* com.ys.inventory..*Controller.*(..))")
    public void controllerMethodPointcut(){}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("controllerMethodPointcut()")
    public void beforePointCut(JoinPoint joinPoint){
        beforeTime = System.currentTimeMillis();
    }

    /**
     * 后置通知，记录用户在Controller操作记录
     * @param joinPoint
     */
    @After("controllerMethodPointcut()")
    public void afterPointCut(JoinPoint joinPoint) {
        try {
            Class<? extends Object> targetClass = joinPoint.getTarget().getClass();
            MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
            Method method = joinPointObject.getMethod();
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ip = inetAddress.getHostAddress();

            LogInsertVO vo = new LogInsertVO();
            vo.setId(UUIDUtil.getUUID());

            LogModule fd = null;
            LogAction md = null;
            if(targetClass.isAnnotationPresent(LogModule.class)){
                fd = targetClass.getAnnotation(LogModule.class);
            }
            if(method.isAnnotationPresent(LogAction.class)){
                md = method.getAnnotation(LogAction.class);
            }
            if(fd!=null){
                vo.setModuleName(fd.moduleName());
            }
            if(md!=null){
                vo.setContent(md.value());
            }
            UserDetailsVO user = SecurityUtil.getUser();
            vo.setUserId(user.getId());
            if(StringUtils.contains(user.getUsername(),",")){
                vo.setOperator(StringUtils.substringAfter(user.getUsername(),","));
            }else{
                vo.setOperator(user.getUsername());
            }
            vo.setIp(ip);
            vo.setCreateUser(user.getId());

            afterTime = System.currentTimeMillis();
            float consumeTime = (afterTime - beforeTime) / 1000f;
            // 执行方法耗时时间
            vo.setConsumeTime(consumeTime);
            service.insert(vo);
        } catch (Exception e) {
            // 记录本地异常日志
            log.warn("日志记录异常信息：", e);
        }
    }
}
