package com.dining.diningProject.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
public class Restaurant {

    private Long id;
    private AllergyCategory allergyCategory;
    private int overallScore;
    private int categoryScore;

    public enum AllergyCategory {
        PEANUT,
        EGG,
        DAIRY
    }
    
}