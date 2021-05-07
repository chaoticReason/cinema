package com.stankevich.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cancel_ticket")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CancelTicket extends BaseEntity{

    @ManyToOne
    @JoinColumn(nullable=false)
    private Ticket ticket;
}
