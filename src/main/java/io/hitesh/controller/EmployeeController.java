package io.hitesh.controller;

import io.hitesh.exception.ResourceNotFoundException;
import io.hitesh.model.Employee;
import io.hitesh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	// get employee
	@GetMapping("employees")
	public List<Employee> getAllEmployee() {
		return this.repository.findAll();
	}

	// get employee by id
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		Employee employee = repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}


	// save employee
	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee){
		return this.repository.save(employee);
	}

	// update employee
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee not found for this id :: " + employeeId));

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		return ResponseEntity.ok(this.repository.save(employee));
	}

	// delete employee
	@DeleteMapping("employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		Employee employee = repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee not found for this id :: " + employeeId));
		this.repository.delete(employee);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
