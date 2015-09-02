package org.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.test.boot.exception.CustomSqlException;
import org.test.boot.template.DepartmentTemplate;
import org.test.jpa.repositories.DepartmentJpaRepository;
import org.test.model.Department;

@Service("departmentJpaService")
public class DepartmentJpaService {
	
	@Autowired
	protected DepartmentJpaRepository jpaRepository;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public List<Department> getList(){
		return jpaRepository.findAll();
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public Department saveDepartment(){
		return jpaRepository.save(DepartmentTemplate.populateDepartment());
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public Long updateDepartment(){
		return jpaRepository.save(DepartmentTemplate.populateDepartment()).getId();
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public void deleteDepartmentByModel(){
		jpaRepository.delete(DepartmentTemplate.populateDepartment());
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomSqlException.class)
	public void deleteDepartmentById(Long id){
		jpaRepository.delete(id);
	}

}
