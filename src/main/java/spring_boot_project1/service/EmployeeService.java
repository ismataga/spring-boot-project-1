package spring_boot_project1.service;

import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> getAllEmployee();
    EmployeeResponse getEmployeeById(Long id);

    void deleteEmployee(Long id);
    void updateEmployee(Long id,EmployeeRequest employeeRequest);
    void updateEmployeeByName(Long id,String name);
}
