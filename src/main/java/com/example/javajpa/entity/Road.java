package com.example.javajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "roads")
@Entity
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int RoadID;

    @Column(name = "RoadName")
    private String RoadName;

    @Column(name = "CreatedAt")
    private LocalDate CreatedAt;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Status")
    private int Status;

    @ManyToOne()
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    private District district;
}
