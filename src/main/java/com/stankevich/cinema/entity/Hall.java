package com.stankevich.cinema.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="hall")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Hall extends BaseEntity{

    private String name;
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cinema_id", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Row> rows;


    @OneToMany(mappedBy="hall", cascade = CascadeType.ALL)
    private Set<MovieSession> sessions;
}
