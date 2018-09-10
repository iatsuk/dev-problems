package net.iatsuk.learn;

import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PostConstructPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        try {
            for (Method method : bean.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(PostConstruct.class)) {
                    method.invoke(bean);
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.out.println(String.format("Error '%s' for bean '%s' in '%s'", e.getMessage(), bean, this.getClass().getName()));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }
}
