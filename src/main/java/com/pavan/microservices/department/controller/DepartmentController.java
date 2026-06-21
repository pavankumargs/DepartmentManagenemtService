package com.pavan.microservices.department.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.microservices.department.entity.Department;
import com.pavan.microservices.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		 Department savedDepartment = departmentService.saveDepartment(department);
		 return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department>  getDepartmentById(@PathVariable Long id) {
		 Department department = departmentService.getDepartmentById(id);
		 return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Department>>  getAllDepartments() {
		 List<Department> allDepartments = departmentService.getAllDepartments();
		 return new ResponseEntity<List<Department>>(allDepartments, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		 Department updatedDepartment = departmentService.updateDepartmentById(id, department);
		 return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
