package mvc_hiber_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("mvc_hiber_aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyConfig {
}
