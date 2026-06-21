package com.pavan.microservices.department.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.microservices.department.entity.Department;
import com.pavan.microservices.department.exception.DepartmentNotFoundException;
import com.pavan.microservices.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Id " + id + " Not Found"));
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department updateDepartmentById(Long id, Department department) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
		if (department.getDepartmentName() != null) {
			existingDepartment.setDepartmentName(department.getDepartmentName());
		}
		if (department.getDepartmentCode() != null) {
			existingDepartment.setDepartmentCode(department.getDepartmentCode());
		}

		if (department.getLocation() != null) {
			existingDepartment.setLocation(department.getLocation());
		}

		if (department.getStatus() != null) {
			existingDepartment.setStatus(department.getStatus());
		}
		return departmentRepository.save(existingDepartment);
	}

	public void deleteDepartment(Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Id " + id + " Not Found"));
		departmentRepository.delete(department);
	}
}
