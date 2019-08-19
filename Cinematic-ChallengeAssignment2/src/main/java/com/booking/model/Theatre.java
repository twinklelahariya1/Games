package com.booking.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "theatre")
public class Theatre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonView
    private Long id;

    @Column(name = "theatrename")
    @JsonView
    private String theatrename;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "theatre")
    @JsonView
    private List<Screen> screenList;

}

