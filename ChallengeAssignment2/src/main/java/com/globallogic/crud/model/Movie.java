package com.globallogic.crud.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;

    @Column(name = "moviename")
    @Size(max = 50)
    private String movieName;


    @OneToMany(mappedBy = "movie")
    private Set<Theatre> theatres;



}
