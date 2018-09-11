package net.iatsuk.learn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException, IOException, URISyntaxException {
        try (BeanFactory beanFactory = new BeanFactory()) {
            beanFactory.addPostProcessor(new TracePostProcessor());
            beanFactory.addPostProcessor(new PostConstructPostProcessor());
            beanFactory.instantiate("net.iatsuk.learn");

            ProductService productService = (ProductService) beanFactory.getBean("productService");
            System.out.println(productService);

            beanFactory.populateProperties();
            PromotionsService promotionsService = productService.getPromotionsService();
            System.out.println(promotionsService);

            beanFactory.injectBeanNames();
            System.out.println(promotionsService.getBeanName());
            beanFactory.injectBeanFactories();
            System.out.println(beanFactory == productService.getBeanFactory());

            beanFactory.initializeBeans();
        }

        ApplicationContext context = new ApplicationContext("net.iatsuk.learn");
        context.close();
    }
}
