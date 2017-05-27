package com.martin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("employee")
public class EmployeeController {

    public final EmployeeRepository employeeRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/employee")
    public Iterable<Employeer> getTalks() {
        return employeeRepository.findAll();

    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void saveEmployeer(@RequestBody Employeer employeer) {
        employeeRepository.save(employeer);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public void updateEmployeer(@RequestBody Employeer employeer) {
        employeeRepository.save(employeer);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "delete/{id:\\d+}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id) {
        employeeRepository.delete(id);
    }


    @GetMapping("/{firstName:[a-zA-Z]+}")
    Iterable<Employeer> findByFirstName(@PathVariable("firstName") String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }


    @GetMapping("/lastname/{lastName:[a-zA-Z]+}")
    Iterable<Employeer> findByLastName(@PathVariable("lastName") String lastName) {
        return employeeRepository.findByLastName(lastName);
    }


    @GetMapping("/{id:\\d+}")
    Employeer findOne(@PathVariable("id") Long id) {
        return employeeRepository.findOne(id);
    }


    @GetMapping("{id}/phones/{phoneId:\\d+}")
    Phone findCompanyEmployeeWithId(
            @PathVariable long id,
            @PathVariable long phoneId
    ) {
        return findOne(id)
                .getPhones()
                .stream()
                .filter(phone -> phone.getId() == phoneId)
                .findAny()
                .orElse(null);
    }

    @GetMapping("salary/{salary}")
    List<Employeer> findBySalaryGreaterThan(@PathVariable("salary") double salary) {
        return employeeRepository.findBySalaryGreaterThanOrderBySalaryDesc(salary);
    }

    @GetMapping("list/{firstName}")
    List<Employeer> countByFirstName(@PathVariable("firstName") String firstName) {
        return employeeRepository.countByFirstName(firstName);
    }

    @GetMapping("count/{salary}")
    List<Employeer> countBySalary(@PathVariable("salary") double salary) {
        return employeeRepository.countBySalaryGreaterThan(salary);
    }

}