package org.test.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.model.Department;
import org.test.service.DepartmentHibernateService;

@RestController
@RequestMapping("/hibernate")
public class HibernateController {
	
	@Autowired
	DepartmentHibernateService hibernateService;

	@RequestMapping(value = "/findallDept", method = RequestMethod.GET)
	public Iterable<Object> findAllDepartment(){
		return hibernateService.departmentList();
	}
	
	@RequestMapping(value = "/saveDept", method = RequestMethod.GET)
	public ResponseEntity<Department> saveDepartment(Department department){
		return new ResponseEntity<Department>(hibernateService.saveDepartment(department), HttpStatus.OK);
	}
	
}
