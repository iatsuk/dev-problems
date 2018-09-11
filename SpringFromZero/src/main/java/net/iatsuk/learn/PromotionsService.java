package net.iatsuk.learn;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PromotionsService implements BeanNameAware, ApplicationListener<ContextClosedEvent> {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @PostConstruct
    void postConstruct() {
        System.out.println("Promotion Service was created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Promotion Service was destroyed");
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(">> ContextClosedEvent");
    }
}
