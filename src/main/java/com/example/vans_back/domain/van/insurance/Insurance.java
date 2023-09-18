package com.example.vans_back.domain.van.insurance;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "provider", nullable = false)
    private String provider;

    @Size(max = 255)
    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}