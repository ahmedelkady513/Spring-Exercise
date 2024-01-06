package net.dmsegypt.Spring.Exercise.dao;

import net.dmsegypt.Spring.Exercise.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
