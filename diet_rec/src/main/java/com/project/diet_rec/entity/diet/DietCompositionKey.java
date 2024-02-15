package com.project.diet_rec.entity.diet;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class DietCompositionKey implements Serializable{
    
    private String dietKey1;
    private DietCategory dietKey2;
    private Long foodKey;
}
