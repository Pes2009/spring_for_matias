package com.martin;

import javax.persistence.*;

/**
 * Created sy martin on 2016-11-05.
 */
@Entity
public class Phone {

    @Column(name ="number", unique =true)
    public String number;
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
