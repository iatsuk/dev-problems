package net.iatsuk.learn;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PromotionsService implements BeanNameAware {
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
}
