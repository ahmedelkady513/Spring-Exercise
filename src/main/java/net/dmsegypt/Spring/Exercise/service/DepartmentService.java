package net.dmsegypt.Spring.Exercise.service;

import lombok.RequiredArgsConstructor;
import net.dmsegypt.Spring.Exercise.dao.DepartmentRepository;
import net.dmsegypt.Spring.Exercise.entity.Department;

import java.util.List;

public interface DepartmentService {

     boolean isDuplicateDepartment(Department department);
     void saveDepartment(Department department);

     List<Department> getAllDepartments();
}
