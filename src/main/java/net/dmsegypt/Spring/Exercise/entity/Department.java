package net.dmsegypt.Spring.Exercise.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Table(name = "department")
@Entity
@Getter
@Setter
public class Department {

    @Id
    @NotBlank(message = "Department Code is required")
    @Column(name = "code",nullable = false , length = 10)
    private String code;
    @NotBlank(message = "Department Name is required")
    @Column(name = "name",nullable = false, length = 30)
    private String name;
    @Column(name = "description", nullable = true,length = 100)
    private String description;

}
