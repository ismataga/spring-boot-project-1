package spring_boot_project1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_project1.entity.Person;


@RestController
@RequestMapping
public class PersonController {
    @GetMapping
    public Person hello(){


        return null;
    }
}
