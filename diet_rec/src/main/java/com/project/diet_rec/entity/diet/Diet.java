package com.project.diet_rec.entity.diet;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(DietPK.class)
public class Diet {

    @Id
    @NotNull
    @Column(name = "date")
    private String date;

    @Id
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private DietCategory category;

    @OneToMany(mappedBy = "diet", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DietComposition> composition = new ArrayList<>();

    @Builder
    public Diet(String date, DietCategory category) {
        this.date = date;
        this.category = category;
    }
}