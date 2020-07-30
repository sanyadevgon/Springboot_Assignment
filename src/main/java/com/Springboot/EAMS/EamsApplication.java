package com.Springboot.EAMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebSecurity
@EnableCaching
public class EamsApplication {

	//private static final Logger logger = LoggerFactory.getLogger(EamsApplication.class);
	public static void main(String[] args) {
		//logger.info("this is a info message ");
		/*logger.warn("this is a warn message");
		logger.error("this is a error message");*/
		SpringApplication.run(EamsApplication.class, args);
	}


	/*public  void run(String... args) throws Exception {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1992, 7, 21);
		Employee em = new Employee("sanya", "devgon", 9323, 's', 8798
				*//*dateofBirth.getTime()*//*);


		// Save Parent Reference (which will save the child as well)
		employee_repo.save(em);
	}*/
}