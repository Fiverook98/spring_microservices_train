package com.thymecrud.testingcrud.repo;

import com.thymecrud.testingcrud.entity.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
