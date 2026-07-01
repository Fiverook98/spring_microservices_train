package com.thymecrud.testingcrud.controller;

import com.thymecrud.testingcrud.entity.Employee;
import com.thymecrud.testingcrud.service.EmployeeService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/temp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String listOfEmployees(Model model) {
        List<Employee> employees = employeeService.employeesToList();
        model.addAttribute("employees", employees);
        return "employees-table";
    }

    @GetMapping("/formNewEmployee")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "form-new-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result){
        if(result.hasErrors()) return "form-new-employee";
        employeeService.insertEmployee(employee);
        return "redirect:/temp/employees";
    }

    @GetMapping("/formUpdateEmployee")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employeeToModify = employeeService.employeeById(id);
        model.addAttribute("employee", employeeToModify);
        return "form-update-employee";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/temp/employees";
    }

}
