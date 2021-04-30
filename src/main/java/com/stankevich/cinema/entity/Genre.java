package com.stankevich.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="genre")
@Data
@NoArgsConstructor
public class Genre extends BaseEntity{

    @NaturalId
    private String name;

    public Genre(String name){
        this.name = name;
    }

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Genre genre = (Genre) o;
        return name.equals(genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    //toString
}
