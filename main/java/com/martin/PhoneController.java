package com.martin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martin on 2016-11-05.
 */
@Component
@RestController
@RequestMapping("phone")
public class PhoneController {

    public final PhoneRepository phoneRepository;


    @Autowired
    public PhoneController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;

    }
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "adds", method = RequestMethod.POST)
    public void savePhone(@RequestBody Phone phone) {
        phoneRepository.save(phone);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping
    public Iterable<Phone> getPhones() {
        return phoneRepository.findAll();


    }


    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "delete/{id:\\d+}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id) {
        phoneRepository.delete(id);
    }
}
