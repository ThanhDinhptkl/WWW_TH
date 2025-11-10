package iuh.fit.se.services;

import java.util.List;

import org.springframework.data.domain.Page;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.entities.Employee;

public interface EmployeeService {

	public EmployeeDTO findById(int id);

	public List<EmployeeDTO> findAll();

	public Page<EmployeeDTO> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);

	public EmployeeDTO save(EmployeeDTO employeeDTO);

	public EmployeeDTO update(int id, EmployeeDTO employeeDTO);

	public boolean delete(int id);
	
	public List<EmployeeDTO> search(String keyword);
}
