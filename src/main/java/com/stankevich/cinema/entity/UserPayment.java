package com.stankevich.cinema.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user_payment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserPayment extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(unique = true)
    private Long number;
}
