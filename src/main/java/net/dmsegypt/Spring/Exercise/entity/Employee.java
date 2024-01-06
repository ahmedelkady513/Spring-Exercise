package net.dmsegypt.Spring.Exercise.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.executable.ValidateOnExecution;
import jakarta.validation.valueextraction.ExtractedValue;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "employee")
@Entity
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "code", nullable = false , length = 10)
    @NotBlank(message = "Code Can't Be Empty")
    private String code;
    @Column(name = "name", nullable = false , length = 30)
    @NotBlank(message = "Name Can't Be Empty")
    private String name;
    @Column(name = "dob")
    private LocalDate dateOfBirth;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "salary" , nullable = false)
    @DecimalMin(value = "0.0" , message = "Salary Must Be 0 Or Positive Number")
    @NotNull(message = "Salary Can't Be Empty")
    private double salary;
    @ManyToOne
    @JoinColumn(name = "department" , nullable = false)
    @NotNull(message = "Department Must Be Selected")
    private Department department;


}
