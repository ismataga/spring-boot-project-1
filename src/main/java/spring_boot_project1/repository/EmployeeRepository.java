package spring_boot_project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_boot_project1.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}
