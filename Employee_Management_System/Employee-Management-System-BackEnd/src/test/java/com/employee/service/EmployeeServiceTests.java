package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.serviceImpl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    public void setup() {
        employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2022, 9, 13))
                .yearsOfExperience(0.4f)
                .build();
    }

    @Test
    public void getEmployeeByIdTests() {

        given(employeeRepository.findById(1)).willReturn(Optional.of(employee));

        Employee savedEmployee = employeeService.getEmployeeById(employee.getId());

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee).isEqualTo(employee);

    }

    @Test
    public void getAllEmployeesTests() {
        Employee employee1 = Employee.builder()
                .id(2)
                .name("Ankit")
                .designation("QA")
                .dateOfBirth(LocalDate.of(1999, 5, 6))
                .dateOfJoining(LocalDate.of(2021, 8, 1))
                .yearsOfExperience(1.5f)
                .build();

        List<Employee> list = List.of(employee, employee1);

        given(employeeRepository.findAll()).willReturn(list);

        List<Employee> employeeList = employeeService.getAllEmployees();


        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
        assertThat(list).isEqualTo(employeeList);
    }

    @Test
    public void addEmployeeTests() {

        given(employeeRepository.save(employee)).willReturn(employee);

        Employee addedEmployee = employeeService.addEmployee(employee);

        assertThat(addedEmployee).isNotNull();
        assertThat(addedEmployee).isEqualTo(employee);
    }



}
