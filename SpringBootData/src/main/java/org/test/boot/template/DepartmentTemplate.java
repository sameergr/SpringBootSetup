package org.test.boot.template;

import java.util.ArrayList;
import java.util.List;

import org.test.model.Department;
import org.test.model.Person;

public class DepartmentTemplate {
	
	public static Department populateDepartment(){
		List<Person> persons = new ArrayList<Person>();
		Person p = new Person();
		p.setName("Person Test");
		p.setAddress("person address");
		persons.add(p);
		
		Department department = new Department();
		department.setDeptname("Dept Name");
		department.setPersons(persons);
		return department;
	}

}
