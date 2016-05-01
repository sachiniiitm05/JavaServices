package com.lessonslab.cxfrestservice.dao;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.lessonslab.cxfrestservice.model.Employee;

@Component
@Transactional(isolation=Isolation.READ_UNCOMMITTED)
public class EmployeeDao extends BaseDAOImpl{
	
	@Autowired
	private Properties appProperties;
	
	private EmployeeRSExracter employeeRSExracter;

	public Employee getEmployeeDetails(String employeeId) {
		
		System.out.println("Name from property : " + appProperties.getProperty("name"));
		Employee emp = new Employee();
		emp.setDateOfJoining("01-02-2001");
		emp.setDepartment("Sales");
		emp.setEmail("test@example.com");
		emp.setEmployeeId("675436");
		emp.setFirstName("John");
		emp.setLastName("Smith");
		return emp;
	}
	
	public List<Employee> getEmployeeList(){
		JdbcTemplate template = this.getJdbcTemplate("US", 1);		
		return template.query("select * from Empaloyee", employeeRSExracter);
	}
	
	
}
