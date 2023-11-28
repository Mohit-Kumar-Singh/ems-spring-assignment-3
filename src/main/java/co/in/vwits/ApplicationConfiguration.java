package co.in.vwits;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "co.in.vwits")
@EnableTransactionManagement
public class ApplicationConfiguration {
	
	@Bean ///this annotataion helps to register instance of class to spring 
	public LocalEntityManagerFactoryBean get() {
		LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
		factory.setPersistenceUnitName("empapp");
		return factory;
	}
	
	//following bean is responsible for managing transaction using spring frame work
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(get().getObject());
		return tx;
	}
	
}
