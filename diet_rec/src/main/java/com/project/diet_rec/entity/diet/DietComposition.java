package com.project.diet_rec.entity.diet;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(DietCompositionKey.class)
public class DietComposition {
    
    @Id 
    private String dietKey1;

    @Id 
    private String dietKey2;

    @Id 
    private String foodKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "date", referencedColumnName = "diet_date"),
        @JoinColumn(name = "category", referencedColumnName = "diet_category")
    })
    private Diet diet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Builder
    public DietComposition(String dietKey1, String dietKey2, String foodKey, Diet diet, Food food) {
        this.dietKey1 = dietKey1;
        this.dietKey2 = dietKey2;
        this.foodKey = foodKey;
        this.diet = diet;
        this.food = food;
    }    
}
