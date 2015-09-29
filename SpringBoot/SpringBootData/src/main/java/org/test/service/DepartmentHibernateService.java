package org.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.test.boot.exception.CustomSqlException;
import org.test.hibernate.repositories.DepartmentRepository;
import org.test.model.Department;

@Service("departmentService")
public class DepartmentHibernateService {

	@Autowired
	protected DepartmentRepository repository;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public Department saveDepartment(Department department){
		department.setVersion(1L);
		return repository.save(department);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public void updateDepartment(Department department){
		department.setVersion(1L);
		repository.save(department);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public void deleteDepartment(Department department){
		department.setVersion(1L);
		repository.delete(department);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public Iterable<Object> departmentList(){
		return repository.findAll();
	}
}
