package com.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 2, max = 20, message = "Min Length is 2 and Max Length is 20")
    @NotBlank(message = "Name Field should not be blank")
    private String name;
    @NotBlank(message = "Designation Field should not be blank")
    private String designation;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private float yearsOfExperience;

}
