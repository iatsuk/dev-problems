package net.iatsuk.learn;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class TracePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("---TracePostProcessor Before " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("---TracePostProcessor After " + beanName);
        return bean;
    }
}
