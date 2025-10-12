package iuh.fit.se.tuan6.main;

import iuh.fit.se.tuan6.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans.xml");
        Employee employee1 = context.getBean("employee", Employee.class);
        Employee employee2 = context.getBean("employee2", Employee.class);
        System.out.println("Employee 1: " + employee1);
        System.out.println("Employee 2: " + employee2);
    }
}