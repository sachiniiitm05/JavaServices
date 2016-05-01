package com.lessonslab.cxfrestservice.dao;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.lessonslab.cxfrestservice.model.Employee;

@Component
//@Configuration
public class EmployeeDao {
	
	@Autowired
	private Properties appProperties;

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
}
