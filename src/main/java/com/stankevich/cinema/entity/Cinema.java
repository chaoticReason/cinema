package com.stankevich.cinema.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="cinema")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Cinema extends BaseEntity{

    private String name;
    private String address;

    @Basic(fetch=FetchType.LAZY)
    private String description;


    @OneToMany(mappedBy = "cinema")
    private Set<Hall> halls;

}
