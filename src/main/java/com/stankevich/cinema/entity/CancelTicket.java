package com.stankevich.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cancel_ticket")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CancelTicket extends BaseEntity{

    @Column(nullable=false)
    @ManyToOne
    private Ticket ticket;
}
