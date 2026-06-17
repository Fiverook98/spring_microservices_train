package com.util.DAO;

import com.util.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByCode(long code);

    Employee save(Employee employee);

    void deleteByCode(long code);

    Employee update(Employee employee);
}
