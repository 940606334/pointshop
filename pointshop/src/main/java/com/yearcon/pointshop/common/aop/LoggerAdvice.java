package com.yearcon.pointshop.common.aop;

import com.yearcon.pointshop.common.anno.LoggerManage;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Line;
import java.time.LocalDateTime;

/**
 * 记录controller日志
 *
 * @author itguang
 * @create 2018-01-23 9:18
 **/

@Aspect
@Component
@Slf4j
public class LoggerAdvice {


    @Before("within(com.yearcon.pointshop.moudles..*)&& @annotation(loggerManage)")
    public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        log.info( "==>执行【" + loggerManage.logDescription() + "】开始");
        log.info(joinPoint.getSignature().toString());

        log.info(parseParames(joinPoint.getArgs()));

    }

    @AfterReturning("within(com.yearcon.pointshop.moudles..*) && @annotation(loggerManage)")
    public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        log.info("执行 【" + loggerManage.logDescription() + "】 结束");
    }

    @AfterThrowing(pointcut = "within(com.yearcon.pointshop.moudles..*) && @annotation(loggerManage)", throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception ex) {
        log.error(" ****************执行 【" + loggerManage.logDescription() + "】  异常 ****************", ex);
    }


    private String parseParames(Object[] parames) {

        if (null == parames || parames.length <= 0) {
            return "";

        }
        StringBuffer param = new StringBuffer("传入参数 # 个:【 ");
        int i = 0;
        for (Object obj : parames) {
            i++;
            if (i == 1) {
                param.append(obj.toString());
                continue;
            }
            param.append(" ,").append(obj.toString());
        }
        return param.append(" 】").toString().replace("#", String.valueOf(i));
    }


}
