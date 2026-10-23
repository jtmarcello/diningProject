package com.dining.diningProject.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
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
@Table(name = "dining_review")
public class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reviewer_name", unique = true)
    private String reviewerName;

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

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "status")
    private Status status;

    public enum Status {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}
