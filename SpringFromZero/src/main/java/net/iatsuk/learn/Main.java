package net.iatsuk.learn;

import org.springframework.beans.factory.BeanFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, URISyntaxException,
            InstantiationException, IllegalAccessException {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("net.iatsuk.learn");

        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);

        beanFactory.injectBeanNames();
        PromotionsService promotionsService = (PromotionsService) beanFactory.getBean("promotionsService");
        System.out.println(promotionsService.getBeanName());
    }
}
