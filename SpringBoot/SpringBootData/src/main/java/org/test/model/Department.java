package org.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;

	@Column(name = "dept_name")
	private String deptname;

	@JoinColumn(foreignKey = @ForeignKey(name = "FK_person"))
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Person> persons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
