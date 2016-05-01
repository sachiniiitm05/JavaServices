package com.lessonslab.cxfrestservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.lessonslab.cxfrestservice.model.Employee;

@Component
public class EmployeeRSExracter implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		while (rs.next()){
			Employee emp = new Employee();
			emp.setDateOfJoining("01-02-2001");
			emp.setDepartment("Sales");
			emp.setEmail("test@example.com");
			emp.setEmployeeId("675436");
			emp.setFirstName("John");
			emp.setLastName("Smith");
			empList.add(emp);
		}
		
		return empList;
	}

}
