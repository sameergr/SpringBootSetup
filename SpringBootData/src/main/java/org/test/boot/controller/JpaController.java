package org.test.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.boot.exception.CustomSqlException;
import org.test.model.Department;
import org.test.service.DepartmentJpaService;

@RestController
@RequestMapping(value = "/jpa")
public class JpaController {

	@Autowired
	protected DepartmentJpaService jpaService;
	
	@ModelAttribute("departmentListModel")
	public List<Department> getDummyDepartment(){
		return jpaService.getList();
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ResponseEntity<Department> saveDepartment(){
		return new ResponseEntity<Department>(jpaService.saveDepartment(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ResponseEntity<Long> updateDepartment(){
		return new ResponseEntity<Long>(jpaService.updateDepartment(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Map<String, String> deleteDepartment() throws CustomSqlException{
		jpaService.deleteDepartmentById(1L);
		Map<String, String> response = new HashMap<>();
		response.put("response", "success");
		throw new CustomSqlException();
	}
	
	@RequestMapping(value = "/delete/model", method = RequestMethod.GET)
	public Map<String, String> deleteDepartmentModel(){
		jpaService.deleteDepartmentByModel();
		Map<String, String> response = new HashMap<>();
		response.put("response", "success");
		return response;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> departmentList(@ModelAttribute("departmentListModel") List<Department> departmentListModel){
		return new ResponseEntity<List<Department>>(jpaService.getList(), HttpStatus.OK);
	}
	
}
