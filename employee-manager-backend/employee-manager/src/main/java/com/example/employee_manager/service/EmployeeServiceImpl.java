package com.example.employee_manager.service;
import com.example.employee_manager.exception.UserNotFoundException;
import com.example.employee_manager.model.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setCreatedOn(LocalDate.now());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User By Id"+ id+ "was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
