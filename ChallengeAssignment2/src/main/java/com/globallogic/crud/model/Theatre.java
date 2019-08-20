package com.globallogic.crud.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "theatre")
public class Theatre {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long theatreId;

    @Column(name = "theatre_name")
    @Size(max = 50)
    private String theatreName;

    @OneToMany(mappedBy = "theatre")
    private Set<Screen> screens;

    @ManyToOne
    @JoinColumn(name = "movieId",nullable = false)
    private Movie movie;


}
