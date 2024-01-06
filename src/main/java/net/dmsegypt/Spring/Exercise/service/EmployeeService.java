package net.dmsegypt.Spring.Exercise.service;

import net.dmsegypt.Spring.Exercise.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    boolean isDuplicateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee) ;

    List<Employee> searchEmployee(String name);

}
