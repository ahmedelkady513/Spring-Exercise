package net.dmsegypt.Spring.Exercise.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.dmsegypt.Spring.Exercise.dao.EmployeeRepository;
import net.dmsegypt.Spring.Exercise.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class EmployeeServiceImpl implements EmployeeService{

    public final EmployeeRepository employeeRepository;
    public boolean isDuplicateEmployee(Employee employee) {
        return employeeRepository.existsById(employee.getCode());
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> searchEmployee(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
