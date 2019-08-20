package com.globallogic.crud.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatNumber;

    @ManyToOne
    @JoinColumn(name = "screenId",nullable = false)
    private Screen screen;

}
