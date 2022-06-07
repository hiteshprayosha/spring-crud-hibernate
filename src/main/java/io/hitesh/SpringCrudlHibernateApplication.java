package io.hitesh;

import io.hitesh.model.Employee;
import io.hitesh.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class SpringCrudlHibernateApplication {

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudlHibernateApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup(){
		queryAllEmployee();
		createEmployee();
		queryAllEmployee();
	}

	private void createEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Smith");
		employee.setEmail("h.smith@email.com");
		log.info("Saving new employee...");
		this.repository.save(employee);
	}

	private void queryAllEmployee() {
		List<Employee> allEmployee = this.repository.findAll();
		log.info("Number of employees: {}", allEmployee.size());
	}

}
