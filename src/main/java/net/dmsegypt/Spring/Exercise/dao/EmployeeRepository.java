package net.dmsegypt.Spring.Exercise.dao;

import net.dmsegypt.Spring.Exercise.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByNameContainingIgnoreCase(String name);

}
