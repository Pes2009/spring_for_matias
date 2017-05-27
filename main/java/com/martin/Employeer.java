package com.martin;

import javax.persistence.*;
import java.util.List;

/**
 * Created by martin on 2016-10-27.
 */
@Entity
public class Employeer {


    @Id
    @GeneratedValue
    private Long id;
    private double salary;
    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;
    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<Phone> phones;
    public Employeer(double salary, String firstName, String lastName, Address address) {
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Employeer() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
