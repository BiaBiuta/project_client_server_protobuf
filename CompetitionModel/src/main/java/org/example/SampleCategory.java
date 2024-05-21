package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum SampleCategory {
    @JsonProperty("Desen")
    DESEN("Desen"),
    @JsonProperty("Cautare comoara")
    CAUTARE_COMOARA("Cautare comoara"),
    @JsonProperty("Poezie")
    POEZIE("Poezie"),
    @JsonProperty("Altele")
    ALTELE("Altele");

    private final String categoryName;

    SampleCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @JsonCreator
    public static SampleCategory fromString(String categoryName) {
        for (SampleCategory category : SampleCategory.values()) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Nu există o categorie pentru: " + categoryName);
    }
}
