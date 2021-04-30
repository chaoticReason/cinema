package com.stankevich.cinema.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{

    @NaturalId(mutable = true)
    private String email;

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
    //точно такое управление?
}
