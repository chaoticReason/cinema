package com.stankevich.cinema.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="movie")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity{
    private String name;

    @Basic(fetch = FetchType.LAZY)
    private String description;
    @Basic(fetch = FetchType.LAZY)
    private String director;

    @ElementCollection
    private List<String> actors;

    @Basic(fetch = FetchType.LAZY)
    private short year;

    @Basic(fetch = FetchType.LAZY)
    private String country;

    @Basic(fetch = FetchType.LAZY)
    private Duration duration;

    @ManyToMany
    private Set<Genre> genres;

    @Basic(fetch = FetchType.LAZY)
    private float rating;

    //add, remove

}
