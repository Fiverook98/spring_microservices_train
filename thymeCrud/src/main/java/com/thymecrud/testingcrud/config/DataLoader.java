package com.thymecrud.testingcrud.config;

import com.thymecrud.testingcrud.entity.Employee;
import com.thymecrud.testingcrud.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataLoader {

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
