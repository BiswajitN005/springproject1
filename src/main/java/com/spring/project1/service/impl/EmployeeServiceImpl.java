package com.spring.project1.service.impl;

import com.spring.project1.exception.EmployeeExeptions;
import com.spring.project1.entity.Employee;
import com.spring.project1.repository.EmployeeRepository;
import com.spring.project1.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }else {
            throw new EmployeeExeptions("Employee","id",id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
      Employee existingEmployee= employeeRepository.findById(id).orElseThrow(() -> new EmployeeExeptions("Employee","id",id));
      existingEmployee.setName(employee.getName());
      existingEmployee.setMsdn(employee.getMsdn());
      existingEmployee.setEmail(employee.getEmail());
      employeeRepository.save(existingEmployee);
      return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
    employeeRepository.findById(id).orElseThrow(()-> new EmployeeExeptions("employee","id",id));
    employeeRepository.deleteById(id);
    }
}
