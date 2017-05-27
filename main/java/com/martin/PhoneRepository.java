package com.martin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by martin on 2016-11-05.
 */
@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {


}
