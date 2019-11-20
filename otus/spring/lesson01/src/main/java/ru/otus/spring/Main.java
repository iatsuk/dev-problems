package ru.otus.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.domain.Person;
import ru.otus.spring.service.TestService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        TestService service = context.getBean(TestService.class);
        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName());
    }
}
