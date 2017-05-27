package com.martin;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by martin on 2016-11-08.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {


    void delete(Long id);

    List<Employeer> findAll(Sort sort);
}
