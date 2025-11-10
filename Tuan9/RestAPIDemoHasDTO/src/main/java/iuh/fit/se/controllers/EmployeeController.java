package iuh.fit.se.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;

@RepositoryRestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> getEmmployeeById(@PathVariable int id) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		response.put("data", employeeService.findById(id));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Map<String, Object>> saveEmployee(
			@Valid @RequestBody EmployeeDTO employeeDTO,
			BindingResult bindingResult) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		
		if (bindingResult.hasErrors()) {
			Map<String, Object> errors = new LinkedHashMap<String, Object>();
			
			bindingResult.getFieldErrors().stream().forEach(result -> {
				errors.put(result.getField(), result.getDefaultMessage());
			});
			
			System.out.println(bindingResult);
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("errors", errors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else {
			response.put("status", HttpStatus.OK.value());
			response.put("data", employeeService.save(employeeDTO));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		
		if (bindingResult.hasErrors()) {
			Map<String, Object> errors = new LinkedHashMap<String, Object>();
			bindingResult.getFieldErrors().stream().forEach(result -> {
				errors.put(result.getField(), result.getDefaultMessage());
			});
			
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("errors", errors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else {
			response.put("status", HttpStatus.OK.value());
			response.put("data", employeeService.update(id, employeeDTO));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		response.put("data", employeeService.delete(id));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Map<String, Object>> getEmployees(@RequestParam(required = false) String keyword) {
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		
		if (keyword == null || keyword.isEmpty()) {
			response.put("data", employeeService.findAll());
		}
		else {
			response.put("data", employeeService.search(keyword));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@GetMapping("/employees/page")
	public ResponseEntity<Map<String, Object>> getList(
		   @RequestParam(defaultValue = "0", required = false) int page,
		    @RequestParam(defaultValue = "20", required = false) int size,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "ASC", required = false) String sortDirection) {
		Page<EmployeeDTO> employees = employeeService.findAllWithPaging(page, size, sortBy, sortDirection);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("data", employees);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
