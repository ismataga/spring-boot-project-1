package spring_boot_project1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;

import spring_boot_project1.service.EmployeeServiceImplm;


import java.util.List;


@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImplm employeeServiceImplm;


    @PostMapping
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeServiceImplm.createEmployee(employeeRequest);
    }

    @GetMapping("{id}")
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        EmployeeResponse employeeResponse = employeeServiceImplm.getEmployeeById(id);
        return employeeResponse;
    }

    @GetMapping
    public List<EmployeeResponse> getEmployee() {
        return employeeServiceImplm.getAllEmployee();
    }



    @PatchMapping("{id}")
    public void updateEmployeeByName(@PathVariable Long id, @RequestParam String name) {
        employeeServiceImplm.updateEmployeeByName(id,name);

    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
       employeeServiceImplm.updateEmployee(id,employeeRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id){
        employeeServiceImplm.deleteEmployee(id);
    }


}
