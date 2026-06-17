package com.util.DAO;

import com.util.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* Implementation of EmployeeDAO interface using JPA EntityManager for database operations.
* This class provides methods to find all employees, find an employee by code, save an employee, and delete an employee by code.
* Thi implementation is for all methods in EmployeeDAO interface and must near at DB level.
* Not implement @Transactional at DAO Layer.
* */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("From Employee", Employee.class);

        return query.getResultList();
    }

    /*
    * UUID is private so implemented a method to find employee by code.
    * This method will be used in deleteByCode and update methods.
    */
    @Override
    public Employee findByCode(long code) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "FROM Employee WHERE employeeCode = :code", Employee.class
        );
        query.setParameter("code", code);

        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteByCode(long code) {
        Employee employee = findByCode(code);
        if(employee != null){
            entityManager.remove(employee);
        }
    }

    /*
    * The save method is used just to save a new employee because for updating uses the UUID match, but we never pass this.
    * In the update method, we first find the existing employee by code,
    * then update the fields that are not null in the input employee object,
    * and finally merge the updated employee back to the database.
    */
    @Override
    public Employee update(Employee employee){
        return entityManager.merge(employee);
    }
}
