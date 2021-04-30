package com.stankevich.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "seat_type")
@Getter
@Setter
@NoArgsConstructor
public class SeatType extends BaseEntity{
    @NaturalId
    private String name;

    @Column(name = "price_coef")
    private float priceCoef;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SeatType seatType = (SeatType) o;
        return name.equals(seatType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
