package spring_boot_project1.controller;

import org.springframework.web.bind.annotation.*;
import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;
import spring_boot_project1.entity.Employee;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    List<Employee> employees = new ArrayList<>();

    @PostMapping
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .id((long) (employees.size() + 1))
                .name(employeeRequest.getName())
                .build();

        employees.add(employee);
    }

    @GetMapping("{id}")
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        Employee employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("employee is not founed" + id));

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .build();

    }

    @GetMapping
    public List<EmployeeResponse> getEmployee() {
        List<EmployeeResponse> responseList = new ArrayList<>();
        employees.forEach(e -> {
            responseList.add(new EmployeeResponse(e.getName(),
                    e.getId()));
        });
        return responseList;
    }


    @PatchMapping("{id}")
    public void updateEmployeeByName(@PathVariable Long id, @RequestParam String name) {
        Employee employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("employee is not founed" + id));
        employee.setName(name);

    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        Employee employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("employee is not founed" + id));
        if (request.getName() != null) {
            employee.setName(request.getName());
        }
    }


}
