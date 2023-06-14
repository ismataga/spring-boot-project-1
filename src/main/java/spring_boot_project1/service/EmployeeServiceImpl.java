package spring_boot_project1.service;

import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeServiceImpl {

    List<EmployeeResponse> getAllEmployee();
    EmployeeResponse getEmployeeById();
    void createEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(Long id);
    void updateEmployee(Long id,EmployeeRequest employeeRequest);
}
