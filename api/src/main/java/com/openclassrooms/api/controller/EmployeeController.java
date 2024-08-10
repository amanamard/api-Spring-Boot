package com.openclassrooms.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") final Long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") final Long id){
        Employee updatedEmployee = employeeService.saveEmployee(employee);
        return updatedEmployee;
    }
    
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id){
        employeeService.deleteEmployee(id);
    }
}
