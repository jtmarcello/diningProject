package com.dining.diningProject.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private Long id;
    private String city;
    private String state;
    private Integer zipCode;
    private boolean peanutInterest;
    private boolean eggInterest;
    private boolean dairyInterest;
}
