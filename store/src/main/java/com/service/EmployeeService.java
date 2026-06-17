package com.service;

import com.util.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(UUID uuid);

    Employee save(Employee employee);

    void deleteById(UUID uuid);

//    Employee update(UUID uuid, Employee employee);
}
