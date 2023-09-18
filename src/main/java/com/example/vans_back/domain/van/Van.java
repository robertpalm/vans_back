package com.example.vans_back.domain.van;

import com.example.vans_back.domain.van.city.City;
import com.example.vans_back.domain.van.insurance.Insurance;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "van")
public class Van {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "model", nullable = false)
    private String model;

    @Size(max = 6)
    @NotNull
    @Column(name = "plate_number", nullable = false, length = 6)
    private String plateNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insurance_id", nullable = false)
    private Insurance insurance;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @NotNull
    @Column(name = "next_inspection", nullable = false)
    private LocalDate nextInspection;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;
}