package iuh.fit.se.tuan6.config;

import iuh.fit.se.tuan6.entities.Address;
import iuh.fit.se.tuan6.entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address1() {
        Address address = new Address();
        address.setCity("Hanoi");
        address.setState("Ha Noi");
        address.setCountry("Vietnam");
        return address;
    }

    @Bean
    public Address address2() {
        Address address = new Address();
        address.setCity("Ho Chi Minh");
        address.setState("Ho Chi Minh");
        address.setCountry("Vietnam");
        return address;
    }

    @Bean
    public Employee employee1() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nguyen Van E");
        employee.setAddress(address1());
        return employee;
    }

    @Bean
    public Employee employee2() {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("Nguyen Van F");
        employee.setAddress(address2());
        return employee;
    }
}