package com.service;

import com.util.DAO.EmployeeDAO;
import com.util.entity.Employee;
import com.util.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
This is the Service implementation layer. In this file we will implement the methods defined in EmployeeService interface.
This layer is responsible for handling the business logic of the application.
It will call the methods defined in EmployeeDAO to perform database operations.
We will also use @Transactional annotation to manage transactions at this layer.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;
//    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(UUID uuid) {
        Optional<Employee> result = repository.findById(uuid);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Employee not found with id: " + uuid);
        }

    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);

    }

    /*
    * The logic of control semantic for PATCH insert in Service
    */
//    @Transactional
//    @Override
//    public Employee update(UUID uuid, Employee employee) {
//        Employee existing = findById(uuid);
//        if (existing == null) return null;
//        // Update only the fields that are not null and not blank in the input employee object
//        if (
//                employee.getFirstName() != null &&
//                        !employee.getFirstName().isBlank() &&
//                        !existing.getFirstName().equals(employee.getFirstName())
//        )
//            existing.setFirstName(employee.getFirstName());
//
//        if (    employee.getLastName() != null &&
//                !employee.getLastName().isBlank() &&
//                !existing.getLastName().equals(employee.getLastName())
//        )
//            existing.setLastName(employee.getLastName());
//
//        if (
//                employee.getEmail() != null &&
//                        !employee.getEmail().isBlank() &&
//                        !existing.getEmail().equals(employee.getEmail())
//        )
//            existing.setEmail(employee.getEmail());
//        return repository.update(existing);
//    }
}
