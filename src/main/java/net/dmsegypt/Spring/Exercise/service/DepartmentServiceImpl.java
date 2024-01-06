package net.dmsegypt.Spring.Exercise.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.dmsegypt.Spring.Exercise.dao.DepartmentRepository;
import net.dmsegypt.Spring.Exercise.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class DepartmentServiceImpl implements DepartmentService {

    public final DepartmentRepository departmentRepository;

    @Override
    public boolean isDuplicateDepartment(Department department) {
        return departmentRepository.existsById(department.getCode());
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
