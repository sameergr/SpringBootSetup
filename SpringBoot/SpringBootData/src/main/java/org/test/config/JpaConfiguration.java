package org.test.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfiguration {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	@Qualifier("getHibernateProperties")
	Properties properties;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USERNAME;
	
	@Value("${spring.datasource.password}")
	private String DB_PASSWORD;
	
	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER_CLASS;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String DIALECT;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String HBM_2_DDL_AUTO;
	
	@Value("${spring.jpa.show-sql}")
	private String SHOW_SQL;
	
	@Value("${spring.datasource.auto-commit}")
	private String AUTO_COMMIT; 
	
	@Value("${spring.packages-to-scan}")
	private String PACKAGES_TO_SCAN;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean  emf = new LocalContainerEntityManagerFactoryBean ();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setDataSource(datasource);
		emf.setJpaProperties(properties);
		emf.setPackagesToScan(PACKAGES_TO_SCAN);
		return emf;
	}
	
}
