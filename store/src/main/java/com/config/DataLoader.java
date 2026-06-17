package com.config;

import com.util.entity.Employee;
import com.util.entity.Product;
import com.util.repo.EmployeeRepository;
import com.util.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadProducts(ProductRepository repository, ObjectMapper mapper){
        return args -> {
            if(repository.count() > 0){
                return;
            }

            ClassPathResource resource = new ClassPathResource("entity/product.json");

            try (InputStream inputStream = resource.getInputStream()){
                List<Product> products = mapper.readValue(inputStream, new TypeReference<List<Product>>() {});
                repository.saveAll(products);
            }

        };
    }

    @Bean
    CommandLineRunner loadEmployees(EmployeeRepository repository, ObjectMapper mapper){
        return args -> {
            if(repository.count() > 0){
                return;
            }

            ClassPathResource resource = new ClassPathResource("entity/employee.json");

            try (InputStream inputStream = resource.getInputStream()){
                List<Employee> employees = mapper.readValue(inputStream, new TypeReference<List<Employee>>() {});
                repository.saveAll(employees);
            }

        };
    }
}
