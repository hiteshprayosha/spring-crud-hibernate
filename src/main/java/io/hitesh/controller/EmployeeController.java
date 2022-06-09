package io.hitesh.controller;

import io.hitesh.exception.EmployeeNotFoundException;
import io.hitesh.model.Employee;
import io.hitesh.service.EmployeeService;
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
	private EmployeeService service;

	@GetMapping("employees")
	public List<Employee> getAllEmployee() {
		return service.getEmployee();
	}

	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws EmployeeNotFoundException {
		Employee employee =
				service.getEmployeeById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
	                                               @Valid @RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
		Employee employee =
				service.getEmployeeById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		return ResponseEntity.ok(service.saveEmployee(employee));
	}

	@DeleteMapping("employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws EmployeeNotFoundException {
		Employee employee =
				service.getEmployeeById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		service.deleteEmployee(employee);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
