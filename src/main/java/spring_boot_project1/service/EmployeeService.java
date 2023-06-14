package spring_boot_project1.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;

import java.util.List;
@Log4j2
@Service
public class EmployeeService implements EmployeeServiceImpl {
    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeResponse getEmployeeById() {
        return null;
    }

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {

    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public void updateEmployee(Long id, EmployeeRequest employeeRequest) {

    }
}
