package io.hitesh.service;

import io.hitesh.model.Employee;
import io.hitesh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Optional<Employee> getEmployeeById(Long empployeeId) {
		return repository.findById(empployeeId);
	}

	public List<Employee> getEmployee() {
		return repository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public void deleteEmployee(Employee employee) {
		repository.delete(employee);
	}
}
