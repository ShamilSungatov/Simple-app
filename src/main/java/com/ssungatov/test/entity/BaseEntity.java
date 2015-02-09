package com.ssungatov.test.entity;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class BaseEntity implements EntityI, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Version
    @Column(name = "VERSION")
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
