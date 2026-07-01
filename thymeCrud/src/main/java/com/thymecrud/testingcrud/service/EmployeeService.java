package com.thymecrud.testingcrud.service;

import com.thymecrud.testingcrud.entity.Employee;
import com.thymecrud.testingcrud.repo.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> employeesToList(){
        return employeeRepository.findAll();
    }

    public Employee employeeById(int id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee insertEmployee(Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    public Employee modifyEmployee(int id, Employee dataToEmployee){
        Employee employeeToModify = employeeById(id);
        if (dataToEmployee.getFirstName() != null && dataToEmployee.getFirstName().isEmpty()) employeeToModify.setFirstName(dataToEmployee.getFirstName());
        if (dataToEmployee.getLastName() != null && dataToEmployee.getLastName().isEmpty()) employeeToModify.setLastName(dataToEmployee.getLastName());
        if (dataToEmployee.getEmail() != null && dataToEmployee.getEmail().isEmpty()) employeeToModify.setEmail(dataToEmployee.getEmail());
        if (dataToEmployee.getAge() != null) employeeToModify.setAge(dataToEmployee.getAge());
        return employeeRepository.save(employeeToModify);
    }

    public void deleteEmployeeById(int id){
        employeeRepository.delete(employeeById(id));
    }
}
