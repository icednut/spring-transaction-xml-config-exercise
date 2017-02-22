package io.icednut.exercise.infra;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-20
 */
@Aspect
@Component
public class ServiceTransactionAspect {

    @Around("execution(public * io.icednut.exercise.api.support..get*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getSimpleName());

        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
    }

//    @Pointcut("within(io.icednut.exercise.api.support.*)")
//    public void methodsToBeProfiled() {
//    }
}
