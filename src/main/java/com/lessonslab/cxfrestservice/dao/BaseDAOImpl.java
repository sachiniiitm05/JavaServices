package com.lessonslab.cxfrestservice.dao;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

@Component
@Configuration
public abstract class BaseDAOImpl {
	
	@Autowired
	private Properties appProperties;
	
	public String getProerty(String key) {
		return appProperties.getProperty(key);
	}
	
	public JdbcTemplate getJdbcTemplate(String countryCd, int storeNbr){
		JdbcTemplate jdbcTemplate = null;
		
		try {
			Class.forName("com.informix.jdbc.IfxDriver");
			
			SingleConnectionDataSource ds = new SingleConnectionDataSource(
					String.format(getProerty("url"), countryCd, storeNbr),
					getProerty("userName"), getProerty("password"), false);
			jdbcTemplate = new JdbcTemplate(ds);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jdbcTemplate;
	}

}
