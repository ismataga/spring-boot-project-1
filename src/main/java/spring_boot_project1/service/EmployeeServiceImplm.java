package spring_boot_project1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;
import spring_boot_project1.entity.Employee;
import spring_boot_project1.mapper.EmployeeMapper;
import spring_boot_project1.repository.EmployeeRepository;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmployeeServiceImplm implements EmployeeService {

    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    private final EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        log.info("createEmployee().start id");
        Employee employee = mapper.mapToEmployeeEntity(employeeRequest);
        employeeRepository.save(employee);
        log.info("createEmployee().end id");
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        log.info("getEmployee().start id", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id" + id));

        EmployeeResponse employeeResponse = mapper.mapToEmployeeResponse(employee);
        log.info("getEmployee().end id", id);

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {

                log.info("getAllEmployee().start");
                List<Employee> employees = employeeRepository.findAll();
                List<EmployeeResponse> employeeResponses = mapper.mapToEmployeeResponseList(employees);
                log.info("getAllEmployee().end");

                return employeeResponses;
    }


    @Override
    public void updateEmployee(Long id, EmployeeRequest employeeRequest) {
        log.info("updateAllEmployee().start id", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id" + id));

        if (employeeRequest.getName() != null)
            employee.setName(employee.getName());

        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployeeByName(Long id, String name) {
        log.info("updateByNam   eAllEmployee().start id", id);
        Employee requestEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id" + id));
        requestEmployee.setName(name);

        employeeRepository.save(requestEmployee);

    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("deleteAllEmployee().start id", id);
        employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id" + id));
        employeeRepository.deleteById(id);
        log.info("deleteAllEmployee().end id", id);
    }


}
