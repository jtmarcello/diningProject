package com.dining.diningProject.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "allergy_category")
    private AllergyCategory allergyCategory;

    @Column(name = "overall_score")
    private Integer overallScore;

    @Min(1)
    @Max(5)
    @Column(name = "peanut_score")
    private Integer peanutScore;

    @Min(1)
    @Max(5)
    @Column(name = "egg_score")
    private Integer eggScore;

    @Min(1)
    @Max(5)
    @Column(name = "dairy_score")
    private Integer dairyScore;

    @Column(name = "zip_code")
    private Integer zipCode;

    public enum AllergyCategory {
        PEANUT,
        EGG,
        DAIRY
    }

}