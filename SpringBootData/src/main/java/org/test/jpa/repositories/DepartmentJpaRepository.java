package org.test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.model.Department;

public interface DepartmentJpaRepository extends JpaRepository<Department, Long>{
	
}
