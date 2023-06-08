package spring_boot_project1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_project1.entity.Employee;


@RestController
@RequestMapping("v1/locations")
public class LocationController {
    @GetMapping
    public Employee hello(){


        return null;
    }
}
