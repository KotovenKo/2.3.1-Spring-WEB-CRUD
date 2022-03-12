package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.Service.CarService;
import web.config.HibernateConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

    }
}
