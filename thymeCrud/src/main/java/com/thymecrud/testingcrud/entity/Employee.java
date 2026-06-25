package com.thymecrud.testingcrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(schema = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "is required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "is_required")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    @Min(value = 18, message = "You can't work now, return when you have 18 years or later!")
    @Max(value = 65, message = "You work enough, it's moment to REST for you")
    private Integer age;

    @Column(name = "role")
    private String role;

    public Employee(String firstName, String lastName, String email, Integer age, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(age, employee.age) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, age, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
}
