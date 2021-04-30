package com.stankevich.cinema.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="movie_session")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieSession extends BaseEntity{
    //make them lazy?

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name="cinema_id")
    private Cinema cinema;

    private int price;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate startDate;

    @JsonFormat(pattern = "hh:mm")
    @Column(nullable = false)
    private LocalTime startTime;

    public MovieSession(Movie movie, Hall hall, LocalDate startDate, LocalTime startTime) {
        this.movie = movie;
        this.hall = hall;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovieSession that = (MovieSession) o;
        return movie.equals(that.movie) && hall.equals(that.hall) && startDate.equals(that.startDate) && startTime.equals(that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), movie, hall, startDate, startTime);
    }
}
