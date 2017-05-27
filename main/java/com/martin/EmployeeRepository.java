package com.martin;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin on 2016-10-27.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employeer, Long> {


    List<Employeer> findBySalary(double salary);

    List<Employeer> findAll(Sort sort);

    Employeer findOne(Long id);

    void delete(Long id);

    Iterable<Employeer> findByFirstName(String firstName);

    Iterable<Employeer> findByLastName(String lastName);

    List<Employeer> findBySalaryGreaterThan(double salary);

    List<Employeer> countByFirstName(String firstName);

    List<Employeer> countBySalaryGreaterThan(double id);

    List<Employeer> findBySalaryGreaterThanOrderBySalaryDesc(double salary);


}