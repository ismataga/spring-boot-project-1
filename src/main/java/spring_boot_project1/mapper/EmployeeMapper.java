package spring_boot_project1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import spring_boot_project1.dto.EmployeeRequest;
import spring_boot_project1.dto.EmployeeResponse;
import spring_boot_project1.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    List<EmployeeResponse> mapToEmployeeResponseList(List<Employee> employees);

    EmployeeResponse mapToEmployeeResponse(Employee employee);

    Employee mapToEmployeeEntity(EmployeeRequest employeeRequest);
}
