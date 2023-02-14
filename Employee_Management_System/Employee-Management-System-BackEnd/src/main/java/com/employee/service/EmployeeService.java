package com.employee.service;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee updateEmployee(Integer id, Employee employee);

    void deleteEmployee(Integer id);

}
