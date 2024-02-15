package com.project.diet_rec.entity.diet;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = true)
    private String foodName;

    @NotNull
    @Column(name = "carbohydrate")
    private int carbohydrate;

    @NotNull
    @Column(name = "protain")
    private int protain;

    @NotNull
    @Column(name = "fat")
    private int fat;

    @NotNull
    @Column(name = "calories")
    private int calories;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<DietComposition> compositions;

    @Builder
    public Food(Long id, @NotNull String foodName, @NotNull int carbohydrate, @NotNull int protain,
                @NotNull int fat, @NotNull int calories, @NotNull int quantity) {
        this.id = id;
        this.foodName = foodName;
        this.carbohydrate = carbohydrate;
        this.protain = protain;
        this.fat = fat;
        this.calories = calories;
        this.quantity = quantity;
    }    
}
