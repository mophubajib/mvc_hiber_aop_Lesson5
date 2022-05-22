package mvc_hiber_aop.aspect.poincut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConfigPointcut {

    @Pointcut("execution(* mvc_hiber_aop.service.EmployeeService.*(..))")
    public void employeeService() {
    }
}