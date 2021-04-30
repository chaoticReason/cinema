package com.stankevich.cinema.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="ticket")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="user_id",
            insertable = false,
            updatable = false)
    private Long userId;

    @Transient
    private Long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_session_id", nullable = false)
    private MovieSession movieSession;

    @Embedded
    private Seat seat;

    public Ticket(MovieSession movieSession, Seat seat) {
        this.movieSession = movieSession;
        this.seat = seat;
    }

    public Long getCode() {
        if(userId != null)
            return ((userId+id)*(userId+id+1)/2 + id);
        return -1L;
    }
}