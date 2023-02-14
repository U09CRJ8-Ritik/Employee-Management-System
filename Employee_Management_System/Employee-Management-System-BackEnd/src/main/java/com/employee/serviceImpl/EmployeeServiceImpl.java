package com.employee.serviceImpl;

import com.employee.entity.Employee;
import com.employee.exceptions.DataNegativeException;
import com.employee.exceptions.DateOfBirthInNegativeException;
import com.employee.exceptions.InvalidDateException;
import com.employee.exceptions.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {

        employeeStatus(employee);
        return repository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with given id : " + id + " Not Found"));
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee updatedEmployee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with given id : " + id + " Not Found"));

        updatedEmployee.setName(employee.getName());
        updatedEmployee.setDesignation(employee.getDesignation());
        updatedEmployee.setDateOfBirth(employee.getDateOfBirth());
        updatedEmployee.setDateOfJoining(employee.getDateOfJoining());

        employeeStatus(updatedEmployee);
        return repository.save(updatedEmployee);

    }

    @Override
    public void deleteEmployee(Integer id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with given id : " + id + " Not Found"));
        repository.deleteById(id);
    }

    public void employeeStatus(Employee employee) {
        LocalDate localDate = LocalDate.now();
        LocalDate dateOfJoining = employee.getDateOfJoining();
        LocalDate dateOfBirth = employee.getDateOfBirth();

        Duration differenceInDaysOfBirth = Duration.between(dateOfBirth.atStartOfDay(), dateOfJoining.atStartOfDay());
        Long daysOfBirth = differenceInDaysOfBirth.toDays();

        if (daysOfBirth < 0) {
            throw new DateOfBirthInNegativeException("Date of Joining should not be before than Date of Birth");
        }

        Duration differenceInDaysOfJoining = Duration.between(dateOfJoining.atStartOfDay(), localDate.atStartOfDay());

        Long days = differenceInDaysOfJoining.toDays();

        float years = (float) days / 365;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        float yearsOfExperience = Float.valueOf(decimalFormat.format(years));

        if (yearsOfExperience < 0) {
            throw new DataNegativeException("Date of Joining must not be greater than today's Date");
        } else if (yearsOfExperience > 60) {
            throw new InvalidDateException("Invalid Date of Joining");
        } else {
            employee.setYearsOfExperience(yearsOfExperience);
        }

    }
}
