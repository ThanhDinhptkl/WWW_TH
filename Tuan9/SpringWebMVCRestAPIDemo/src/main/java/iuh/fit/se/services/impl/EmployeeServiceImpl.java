package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import iuh.fit.se.utils.ApiResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private RestClient restClient;
	private ObjectMapper objectMapper;
	private static final String ENDPOINT = "http://localhost:9998/api";

	public EmployeeServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
		this.restClient = restClient;
		this.objectMapper = objectMapper;
	}

	@Override
	public ApiResponse findById(int id) {
		return restClient.get().uri(ENDPOINT + "/employees/{id}", id).accept(MediaType.APPLICATION_JSON)
				.exchange((request, response) -> {
					ApiResponse apiResponse = null;
					if (response.getBody().available() > 0) {
						apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
						apiResponse.setData(
								objectMapper.convertValue(apiResponse.getData(), new TypeReference<Employee>() {
								}));
					}
					return apiResponse;
				});
	}

	@Override
	public ApiResponse findAll() {
		return restClient.get().uri(ENDPOINT + "/employees").accept(MediaType.APPLICATION_JSON)
				.exchange((request, response) -> {
					ApiResponse apiResponse = null;
					if (response.getBody().available() > 0) {
						apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
						apiResponse.setData(
								objectMapper.convertValue(apiResponse.getData(), new TypeReference<List<Employee>>() {
								}));
					}

					return apiResponse;
				});
	}

	@Override
	public ApiResponse save(Employee employee) {
		return restClient.post().uri(ENDPOINT + "/employees").accept(MediaType.APPLICATION_JSON)
				.body(employee).exchange((request, response) -> {
					ApiResponse apiResponse = null;
					if (response.getBody().available() > 0) {
						apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
					}

					return apiResponse;
				});
	}

	@Override
	public ApiResponse update(int id, Employee employee) {
		return restClient.put().uri(ENDPOINT + "/employees/{id}", id).accept(MediaType.APPLICATION_JSON)
				.body(employee).exchange((request, response) -> {
					ApiResponse apiResponse = null;
					if (response.getBody().available() > 0) {
						apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
					}

					return apiResponse;
				});
	}

	@Override
	public ApiResponse delete(int id) {
		return restClient.delete().uri(ENDPOINT + "/employees/{id}", id)
				.accept(MediaType.APPLICATION_JSON).exchange((request, response) -> {
					ApiResponse apiResponse = null;
					if (response.getBody().available() > 0) {
						apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
					}

					return apiResponse;
				});
	}

	@Override
	public ApiResponse search(String keyword) {
		return restClient.get().uri(ENDPOINT + "/employees?keyword={keyword}", keyword)
				.accept(MediaType.APPLICATION_JSON).exchange((request, response) -> {
					ApiResponse apiResponse = null;
					if (response.getBody().available() > 0) {
						apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
						apiResponse.setData(
								objectMapper.convertValue(apiResponse.getData(), new TypeReference<List<Employee>>() {
								}));

					}

					return apiResponse;
				});
	}

}
