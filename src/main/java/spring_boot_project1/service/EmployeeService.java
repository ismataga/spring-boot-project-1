package spring_boot_project1.service;

import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAllEmployee();
    EmployeeResponse getEmployeeById(Long id);
    void createEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(Long id);
    void updateEmployee(Long id,EmployeeRequest employeeRequest);
    void updateEmployeeByName(Long id,String name);
}
