package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.utils.ApiResponse;

public interface EmployeeService {
	
	public ApiResponse findById(int id);

	public ApiResponse findAll();

	public ApiResponse save(Employee employee);

	public ApiResponse update(int id, Employee employee);

	public ApiResponse delete(int id);
	
	public ApiResponse search(String keyword);

}
