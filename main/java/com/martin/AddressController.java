package com.martin;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("address")
public class AddressController {

    public final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void saveAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

        @CrossOrigin(origins = "http://localhost:63342")
        @RequestMapping(value = "delete/{id:\\d+}", method = RequestMethod.DELETE)
        void delete(@PathVariable("id") Long id) {
            addressRepository.delete(id);
        }


    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/address")
    public Iterable<Address> getAddress() {
        return addressRepository.findAll();

    }

}
