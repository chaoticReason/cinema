package com.stankevich.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Seat{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "row_id", referencedColumnName = "id",
                    insertable = false, updatable = false)
    })

    private Row row;

    @Column(name="seat_index")
    private int seatIndex;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="status")
    private SeatStatus status = SeatStatus.FREE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    public Seat(Row row, int seatIndex) {
        this.row = row;
        this.seatIndex = seatIndex;
    }


}
