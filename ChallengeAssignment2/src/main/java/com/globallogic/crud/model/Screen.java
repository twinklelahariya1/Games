package com.globallogic.crud.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "screen")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ScreenId;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;


    @Column(name = "starttime")
    private Time startTime;

    @Column(name = "endtime")
    private  Time endTime;

    @OneToMany(mappedBy = "screen")
    private Set<Seat> seats;


    @ManyToOne
//    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "theatreId",nullable = false)
    private Theatre theatre;
}
