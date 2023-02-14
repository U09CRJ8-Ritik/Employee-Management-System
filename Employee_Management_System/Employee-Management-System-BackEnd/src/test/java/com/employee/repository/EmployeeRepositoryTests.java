package com.employee.repository;

import com.employee.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @DisplayName("JUnit Test for save Employee Operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

        // given - precondition or setUp
        Employee employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2021, 9, 13))
                .yearsOfExperience(1.4f)
                .build();

        // when-action or behaviour we are going to Test
        Employee savedEmployee = employeeRepository.save(employee);

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    // JUnit test for get All Employees Operation
    @Test
    @DisplayName("JUnit test for get All Employees Operation")
    public void givenEmployeesList_whenFindAll_thenEmployeesList() {

        // given - precondition or setUp
        Employee employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2021, 9, 13))
                .yearsOfExperience(1.4f)
                .build();

        Employee employee1 = Employee.builder()
                .id(2)
                .name("Ankit")
                .designation("QA")
                .dateOfBirth(LocalDate.of(1999, 5, 6))
                .dateOfJoining(LocalDate.of(2021, 8, 1))
                .yearsOfExperience(1.5f)
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);


        // when-action or behaviour we are going to Test
        List<Employee> employeeList = employeeRepository.findAll();


        //then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    // Junit test for get Employee By Id
    @Test
    @DisplayName("Junit test for get Employee By Id")
    public void givenEmployeeId_whenFindById_thenReturnEmployee() {

        // given - precondition or setUp
        Employee employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2021, 9, 13))
                .yearsOfExperience(1.4f)
                .build();
        employeeRepository.save(employee);


        // when-action or behaviour we are going to Test
        Employee employeeDb = employeeRepository.findById(employee.getId()).get();


        //then - verify the output
        assertThat(employeeDb).isNotNull();

    }

    // Junit test for get Employee by designation
    @Test
    @DisplayName("Junit test for get Employee by designation")
    public void givenEmployeeDesignation_whenFindByDesignation_thenReturnEmployee() {

        // given - precondition or setUp
        Employee employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2021, 9, 13))
                .yearsOfExperience(1.4f)
                .build();
        employeeRepository.save(employee);

        // when-action or behaviour we are going to Test
        Employee employeeDb = employeeRepository.findByDesignation(employee.getDesignation()).get();


        //then - verify the output
        assertThat(employeeDb).isNotNull();


    }

    // Junit test for update Employee
    @Test
    @DisplayName("Junit test for update Employee")
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdateEmployee() {

        // given - precondition or setUp
        Employee employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2021, 9, 13))
                .yearsOfExperience(1.4f)
                .build();
        employeeRepository.save(employee);


        // when-action or behaviour we are going to Test
        Employee savedEmployee = employeeRepository.findByDesignation(employee.getDesignation()).get();
        savedEmployee.setDesignation("SDE");
        savedEmployee.setDateOfBirth(LocalDate.of(1999, 11, 11));
        Employee employeeDb = employeeRepository.save(savedEmployee);

        //then - verify the output
        assertThat(employeeDb.getDesignation()).isEqualTo("SDE");
        assertThat(employeeDb.getDateOfBirth()).isEqualTo(LocalDate.of(1999, 11, 11));

    }

    // Junit test for delete Employee
    @Test
    @DisplayName("Junit test for delete Employee")
    public void givenEmployeeObject_whenDeleteEmployee_thenRemoveEmployee() {

        // given - precondition or setUp
        Employee employee = Employee.builder()
                .id(1)
                .name("Ritik")
                .designation("SE")
                .dateOfBirth(LocalDate.of(1999, 7, 10))
                .dateOfJoining(LocalDate.of(2021, 9, 13))
                .yearsOfExperience(1.4f)
                .build();
        employeeRepository.save(employee);


        // when-action or behaviour we are going to Test
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());


        //then - verify the output
        assertThat(optionalEmployee).isEmpty();


    }


}
