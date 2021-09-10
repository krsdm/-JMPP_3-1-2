package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Animal animal = applicationContext.getBean(Animal.class);
        animal.getCat().sayHi();

        SinglObject object1 = SinglObject.getSinglObject();
        SinglObject object2 = SinglObject.getSinglObject();
        System.out.println(object1 == object2);
    }
}
