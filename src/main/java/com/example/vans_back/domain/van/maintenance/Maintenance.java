package com.example.vans_back.domain.van.maintenance;

import com.example.vans_back.domain.van.Van;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "van_id", nullable = false)
    private Van van;

    @Size(max = 1000)
    @NotNull
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @NotNull
    @Column(name = "total_mileage", nullable = false)
    private Integer totalMileage;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "attachment")
    private byte[] attachment;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;
}