package com.booking.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;


@Entity
@DynamicUpdate
@Table(name = "seat")
public class Screen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @JsonView
    private Long id;

    @Column(name = "showtime")
    @JsonView
    private Time showTime;


}
