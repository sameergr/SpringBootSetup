package org.test.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class HibernateConfiguration {

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
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setDriverClassName(DRIVER_CLASS);
		return dataSource;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", DIALECT);
		props.setProperty("hibernate.show_sql", SHOW_SQL);
		props.setProperty("hibernate.hbm2ddl.auto", HBM_2_DDL_AUTO);
		props.setProperty("hibernate.connection.autocommit", AUTO_COMMIT);
		return props;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	/*public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}*/

}
